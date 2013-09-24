package com.badlogic.sol.drawables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.sol.Drawable;
import com.badlogic.sol.Game;

public class Fadein extends Drawable {
	Color color;
	float duration;
	float stateTime;
	
	public Fadein (Color color, float duration) {
		super("", 0, 0, 10000000);
		this.color = color;
		this.duration = duration;
	}

	@Override
	public void draw (float deltaTime, SpriteBatch batch) {
		stateTime += deltaTime;
		if(stateTime > duration) {
			Game.ctx.removeDrawable(this);
		}
		
		float alpha = 1 - stateTime / duration;
		Game.ctx.getBatch().end();

		Gdx.gl.glEnable(GL20.GL_BLEND);
		Game.ctx.getRenderer().begin(ShapeType.Filled);
		Game.ctx.getRenderer().setColor(color.r, color.g, color.b, alpha);
		Game.ctx.getRenderer().rect(0, 0, 320, 240);
		Game.ctx.getRenderer().end();
		Gdx.gl.glDisable(GL20.GL_BLEND);
		
		Game.ctx.getBatch().begin();
	}
}
