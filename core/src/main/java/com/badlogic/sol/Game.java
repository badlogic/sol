package com.badlogic.sol;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.sol.drawables.AnimationDrawable;
import com.badlogic.sol.drawables.ImageDrawable;
import com.badlogic.sol.drawables.TextDrawable;

public class Game {
	public static Game ctx;
	SpriteBatch batch;
	OrthographicCamera camera;
	Array<Drawable> drawables = new Array<Drawable>();
	Set<Drawable> removed = new HashSet<Drawable>();
	Scene scene;
	Vector3 v = new Vector3();
	ShapeRenderer renderer;
	
	public Game() {
		ctx = this;
		Assets.load();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 320, 240);
		batch = new SpriteBatch();
		renderer = new ShapeRenderer();
	}
	
	public void setScene(Scene scene) {
		drawables.clear();
		this.scene = scene;
	}
	
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		float deltaTime = Gdx.graphics.getDeltaTime();
		scene.update(deltaTime);
		
		drawables.sort(new Comparator<Drawable>() {
			@Override
			public int compare (Drawable o1, Drawable o2) {
				return o1.z - o2.z;
			}
		});
		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		renderer.setProjectionMatrix(camera.combined);
		
		batch.begin();
		for(Drawable d: drawables) {
			d.draw(deltaTime, batch);
		}
		camera.unproject(v.set(Gdx.input.getX(), Gdx.input.getY(), 0));
		Assets.font.draw(batch, (int)v.x + ", " + (int)v.y, 0, 12);
		batch.end();
		
		if(removed.size() > 0) {
			Iterator<Drawable> iter = drawables.iterator();
			while(iter.hasNext()) {
				if(removed.contains(iter.next())) {
					iter.remove();
				}
			}
		}
		
//		renderer.setProjectionMatrix(camera.combined);
//		renderer.begin(ShapeType.Filled);
//		renderer.setColor(1, 0, 0, 1);
//		for(Drawable d: drawables) {
//			renderer.rect(d.x, d.y, 2, 2);
//		}
//		renderer.end();
	}

	public void addDrawable(Drawable drawable) {
		drawables.add(drawable);
	}
	
	public void removeDrawable(String name) {
		Iterator<Drawable> iter = drawables.iterator();
		while(iter.hasNext()) {
			if(iter.next().name.equals(name)) {
				iter.remove();	
				break;
			}
		}
	}

	public Drawable getDrawable (String name) {
		Iterator<Drawable> iter = drawables.iterator();
		while(iter.hasNext()) {
			Drawable d = iter.next();
			if(d.name.equals(name)) {
				return d;
			}
		}
		return null;
	}

	public void removeDrawable (Drawable drawable) {
		removed.add(drawable);
	}

	public SpriteBatch getBatch () {
		return batch;
	}
	
	public ShapeRenderer getRenderer() {
		return renderer;
	}
}
