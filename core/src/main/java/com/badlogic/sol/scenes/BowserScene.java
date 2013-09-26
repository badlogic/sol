package com.badlogic.sol.scenes;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.sol.Assets;
import com.badlogic.sol.Game;
import com.badlogic.sol.Scene;
import com.badlogic.sol.command.SetAnimation;
import com.badlogic.sol.entity.Animated;
import com.badlogic.sol.entity.Image;

public class BowserScene extends Scene {
	Animated stef;
	Animated bowser;
	
	public BowserScene() {
		add(new Image("background", "dungeon", 0, 0, 0));
		stef = new Animated("stef", "idle-left", 52, 60, 0);
		bowser = new Animated("bowser", "bowser", 230, 60, 3);	
		add(stef);
		add(bowser);
		add(new Image("chain", "chain", 280, 60, 1));
		
//		add(new Fade(Color.WHITE, 1, true));
//		add(new Wait(1));
//		add(new MoveToAnim("stef", "walk", 52, 60, 64));
//		add(new SetAnimation("stef", "idle-right"));
		add(new SetAnimation("stef", "paddle"));
	}

	class Fireball extends Image {
		float dirX = -1, dirY = 0;
		int bounces = 0;
		
		public Fireball (int x, int y) {
			super("fireball", "fireball", x, y, 2);
		}

		@Override
		public void draw (float deltaTime, SpriteBatch batch) {
			if(dirX < 0) {
				batch.draw(Assets.getImage(imageName), x, y);
			} else {
				TextureRegion image = Assets.getImage(imageName);
				image.flip(true, false);
				batch.draw(image, x, y);
				image.flip(true, false);
			}
		}
	}
	
	long lastFire;
	Array<Fireball> fireballs = new Array<Fireball>();
	float lastY = 0;
	
	@Override
	public void update (float deltaTime) {
		super.update(deltaTime);
		
		if(commands.size == 0) {									
			processInput();
			updateFireballs(deltaTime);
			updateBowser(deltaTime);
			
			if(System.nanoTime() - lastFire > 3000000000l) {
				Fireball fb = new Fireball((int)bowser.x - 16, (int)bowser.y + 20);
				fireballs.add(fb);
				Game.ctx.addDrawable(fb);
				lastFire = System.nanoTime();
			}
		}
	}
	
	public void processInput() {
		if(Gdx.input.isTouched()) {
			float delta = Gdx.input.getDeltaY() / (float)Gdx.graphics.getHeight() * 240;
			stef.y -= delta;
			if(stef.y < 60) stef.y = 60;
			if(stef.y > 204 - 32) stef.y = 204 - 32;
		}
	}
		
	public void updateFireballs(float deltaTime) {
		Iterator<Fireball> iter = fireballs.iterator();
		while(iter.hasNext()) {
			Fireball fb = iter.next();
			fb.x += fb.dirX * deltaTime * 70;
			fb.y += fb.dirY * deltaTime * 70;
			if(fb.x < -16) {
				iter.remove();
				Game.ctx.removeDrawable(fb);
			}
			
			if(fb.x > 66 && fb.x < 73) {
				if(fb.y > stef.y - 16 && fb.y < stef.y + 56) {
					fb.dirX = 1;
					fb.dirY = MathUtils.random(-1f, 1f);
					fb.bounces ++;
				}
			}
			
			if(fb.x > 265) {
				fb.dirX = -1;
				fb.bounces++;
			}
			
			if(fb.y + 16 > 223) {
				fb.y = 223 - 17;
				fb.dirY = -fb.dirY;
				fb.bounces++;
			}
			
			if(fb.y < 60) {
				fb.y = 60;
				fb.dirY = -fb.dirY;
				fb.bounces++;
			}
			
			if(fb.bounces > 2) {
				iter.remove();
				Game.ctx.removeDrawable(fb);
			}
		}
	}
	
	float bowserDir = -1;
	public void updateBowser(float deltaTime) {
		bowser.x += bowserDir * 30 * deltaTime;
		if(bowser.x < 160) {
			bowserDir = 1;
			bowser.x = 160;
		}
		if(bowser.x > 230) {
			bowserDir = -1;
			bowser.x = 230;
		}
	}
}
