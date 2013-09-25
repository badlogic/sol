package com.badlogic.sol;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.ObjectMap;

public class Assets {
	static ObjectMap<String, Animation> animations = new ObjectMap<String, Animation>();
	static ObjectMap<String, Texture> images = new ObjectMap<String, Texture>();
	public static BitmapFont font;
	
	public static void load() {
		// stef
		animations.put("idle-right", loadAnim("stef-idle.png", 32, 64, 0.5f, false));
		animations.put("idle-left", loadAnim("stef-idle.png", 32, 64, 0.5f, true));
		animations.put("walk-right", loadAnim("stef-walk.png", 32, 64, 0.5f, false));
		animations.put("walk-left", loadAnim("stef-walk.png", 32, 64, 0.5f, true));
		animations.put("back", loadAnim("stef-back.png", 32, 64, 0.5f, false));
		animations.put("front", loadAnim("stef-front.png", 32, 64, 0.5f, false));
		
		// outdoor
		images.put("outdoor", loadImage("outdoor.png"));
		animations.put("bird", loadAnim("bird.png", 16, 16, 2, false));
		animations.put("bird-fly", loadAnim("bird-fly.png", 16, 16, 0.3f, false));
		
		images.put("supermario", loadImage("supermario.png"));
		images.put("mushroom", loadImage("mushroom.png"));
		
		font = new FreeTypeFontGenerator(Gdx.files.internal("wendy.ttf")).generateFont(20, FreeTypeFontGenerator.DEFAULT_CHARS, false);
	}
	
	private static Texture loadImage(String fileName) {
		return new Texture(fileName);
	}
	
	private static Animation loadAnim(String fileName, int fWidth, int fHeight, float frameDuration, boolean flipX) {
		Texture texture = new Texture(fileName);
		TextureRegion[] frames = TextureRegion.split(texture, fWidth, fHeight)[0];
		if(flipX) {
			for(TextureRegion r: frames) {
				r.flip(true, false);
			}
		}
		return new Animation(frameDuration, frames);
	}
	
	public static Animation getAnimation(String name) {
		return animations.get(name);
	}
	
	public static Texture getImage(String name) {
		return images.get(name);
	}
}