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
	static ObjectMap<String, TextureRegion> images = new ObjectMap<String, TextureRegion>();
	public static BitmapFont font;
	
	public static void load() {
		// stef
		animations.put("idle-right", loadAnim("stef/stef-idle.png", 32, 64, 0.5f, false));
		animations.put("idle-left", loadAnim("stef/stef-idle.png", 32, 64, 0.5f, true));
		animations.put("walk-right", loadAnim("stef/stef-walk_new.png", 32, 64, 0.3f, false));
		animations.put("walk-left", loadAnim("stef/stef-walk_new.png", 32, 64, 0.3f, true));
		animations.put("back", loadAnim("stef/stef-back.png", 32, 64, 0.5f, false));
		animations.put("front", loadAnim("stef/stef-front.png", 32, 64, 0.5f, false));
		animations.put("kick-right", loadAnim("stef/stef-kick.png", 32, 64, 0.5f, false));
		animations.put("kick-left", loadAnim("stef/stef-kick.png", 32, 64, 0.5f, true));
		animations.put("paddle", loadAnim("stef/stef-paddle.png", 32, 64, 0.5f, false));
		
		// outdoor
		images.put("outdoor", loadImage("outdoor/outdoor.png"));
		animations.put("bird", loadAnim("outdoor/bird.png", 16, 16, 2, false));
		animations.put("bird-fly", loadAnim("outdoor/bird-fly.png", 16, 16, 0.3f, false));
		
		// entrance
		images.put("entrance", loadImage("entrance/entrance.png"));
		images.put("door", loadImage("entrance/door.png"));
		images.put("opendoor", loadImage("entrance/opendoor.png"));
		animations.put("panel", loadAnim("entrance/panel.png", 7, 11, 1, false));
		
		// mario
		images.put("supermario", loadImage("mario/supermario.png"));
		animations.put("goomba", loadAnim("mario/goomba.png", 16, 16, 0.5f, false));
		animations.put("goomba-dead", loadAnim("mario/goomba-dead.png", 16, 16, 0.1f, false));
		images.put("mushroom", loadImage("mario/mushroom.png"));
		animations.put("mario-right", loadAnim("mario/mario.png", 16, 16, 1, false));
		animations.put("mario-left", loadAnim("mario/mario.png", 16, 16, 1, true));
		animations.put("mario-walk-left", loadAnim("mario/mario-walk.png", 16, 16, 0.3f, true));
		animations.put("mario-walk-right", loadAnim("mario/mario-walk.png", 16, 16, 0.3f, false));
		images.put("controller", loadImage("mario/controller.png"));
		
		// bowser
		images.put("dungeon", loadImage("bowser/dungeon.png"));
		images.put("chain", loadImage("bowser/chain.png"));
		images.put("fireball", loadImage("bowser/fire.png"));
		animations.put("bowser", loadAnim("bowser/bowser.png", 32, 32, 0.3f, false));
		
		
		font = new FreeTypeFontGenerator(Gdx.files.internal("wendy.ttf")).generateFont(20, FreeTypeFontGenerator.DEFAULT_CHARS, false);
	}
	
	private static TextureRegion loadImage(String fileName) {
		return new TextureRegion(new Texture(fileName));
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
	
	public static TextureRegion getImage(String name) {
		return images.get(name);
	}
}
