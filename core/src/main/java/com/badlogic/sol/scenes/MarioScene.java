package com.badlogic.sol.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.sol.Game;
import com.badlogic.sol.Scene;
import com.badlogic.sol.command.MoveTo;
import com.badlogic.sol.command.MoveToAnim;
import com.badlogic.sol.command.NextScene;
import com.badlogic.sol.command.Remove;
import com.badlogic.sol.command.SetAnimation;
import com.badlogic.sol.command.Wait;
import com.badlogic.sol.entity.Animated;
import com.badlogic.sol.entity.Fade;
import com.badlogic.sol.entity.Image;
import com.badlogic.sol.entity.Text;

public class MarioScene extends Scene {
	Animated stef;
	Array<Goomba> goombas = new Array<Goomba>();
	Vector3 touch = new Vector3();
	long kickstart = 0;
	float lastMovingDirection = 1;
	State state = State.Idle;
	
	String[] messages = {
		"Come Get Some",
		"Groovy",
		"And stay dead",
		"muahahaha",
		"blood is in the air",
		"bam",
		"Pow",
	};
	
	enum State {
		Left,
		Right,
		Idle,
		Kick
	}
	
	class Goomba extends Animated {
		float dir = -1;
		public Goomba (String name, String animationName, int x, int y, int z) {
			super(name, animationName, x, y, z);
		}
	}
	
	class MovingText extends Text {

		public MovingText (String text, Color color, float duration, int x, int y) {
			super(text, color, duration, x, y);
		}

		@Override
		public void draw (float deltaTime, SpriteBatch batch) {
			super.draw(deltaTime, batch);
			y+=deltaTime * 30;
		}
	}
	
	public MarioScene() {
		for(int i = 0; i < 20; i++) {
			Goomba g = new Goomba("g" + i, "goomba", 320 + i * MathUtils.random(16, 32), 64, MathUtils.random(1, 10));
			g.dir = -1;
			goombas.add(g);
			add(g);
		}
		
		for(int i = 0; i < 20; i++) {
			Goomba g = new Goomba("g" + i, "goomba", -100 - i * MathUtils.random(16, 32), 64, MathUtils.random(1, 10));
			g.dir = 1;
			goombas.add(g);
			add(g);
		}
		
		add(new Image("background", "supermario", 0, 0, 0));
		stef = new Animated("stef", "idle-left", 280, 64, 0); 
		add(stef);	
		
		add(new Fade(Color.WHITE, 1, true));
		add(new Wait(1));
		add(new MoveToAnim("stef", "walk", 87, 64, 64));
		add(new SetAnimation("stef", "front"));
		add(new Wait(1));
		add(new SetAnimation("stef", "idle-left"));
		add(new Wait(1f));
		add(new SetAnimation("stef", "idle-right"));
		add(new Wait(1f));
		add(new SetAnimation("stef", "front"));
		add(new Text("W.T.F?!", Color.WHITE, 3, 87, 130));
		add(new Animated("goomba", "goomba", 320, 64, 0));
		add(new MoveTo("goomba", 240, 64, 50));
		add(new SetAnimation("stef", "idle-right"));
		add(new Wait(2));
		add(new SetAnimation("stef", "front"));
		add(new Text("Uh Oh", Color.WHITE, 2, 87, 130));
		add(new SetAnimation("stef", "idle-right"));
		add(new MoveTo("goomba", 104, 64, 50));
		add(new SetAnimation("goomba", "goomba-dead", false));
		add(new SetAnimation("stef", "kick-right", false));
		add(new Wait(1));
		add(new SetAnimation("stef", "front", false));
		add(new Text("Stomp Stomp Motherfucker", Color.WHITE, 2, 110, 130));		
	}	

	@Override
	public void update (float deltaTime) {
		super.update(deltaTime);
		
		if(commands.size == 0) {
			processInput(deltaTime);
			updateGoombas(deltaTime);
		}
	}
	
	Rectangle rNear = new Rectangle(0, 0, 0, 0);
	Rectangle rFar = new Rectangle(0, 0, 0, 0);
	Rectangle r2 = new Rectangle(0, 0, 0, 0);
	
	public void updateGoombas(float deltaTime) {
		rNear.set(stef.x+13, 0, 6, 240);
		rFar.set(stef.x+2, 0, 30, 240);
		int deadGoombas = 0;
		boolean dead = false;
		
		for(Goomba g: goombas) {			
			if(!g.animationName.equals("goomba-dead")) {
				g.x += g.dir * 36 * deltaTime;
				r2.set(g.x, 0, 16, 240);
				if(rFar.overlaps(r2) && state == State.Kick) {
					g.setAnimation("goomba-dead", false);
					if(MathUtils.random() > 0.7f) {
						Game.ctx.addDrawable(new MovingText(messages[MathUtils.random(0, messages.length - 1)], Color.RED, 1f, (int)stef.x, (int)stef.y + 100));
					}
				}
				if(rNear.overlaps(r2)) {
					dead = true;
				}
			} else {
				deadGoombas++;
			}
		}
		
		if(deadGoombas == goombas.size) {
			add(new SetAnimation("stef", "front"));
			add(new MoveToAnim("stef", "walk", 160, 64, 64));
			add(new SetAnimation("stef", "front"));
			add(new Text("I Won't clean this mess up", Color.RED, 2, 160, 164));
			add(new Wait(2));
			add(new Image("mushroom", "mushroom", 240, 64, 0));
			add(new Wait(0.5f));
			add(new SetAnimation("stef", "idle-right"));
			add(new Text("I love mushrooms!", Color.RED, 2, 160, 164));
			add(new Wait(2));
			add(new MoveToAnim("stef", "walk", 240, 64, 64));
			add(new SetAnimation("stef", "front"));
			add(new Remove("mushroom"));
			add(new Text("Om nom nom", Color.RED, 2, 160, 164));
			add(new Fade(Color.WHITE, 2.4f, false));
			add(new Wait(1));
			add(new MoveToAnim("stef", "walk", 320, 64, 64));
			add(new NextScene(new BowserScene()));
		}
		
		if(dead) {
			add(new SetAnimation("stef", "front"));
			add(new Text("Ouch", Color.RED, 2, (int)stef.x, (int)stef.y + 100));
			add(new MoveTo("stef", (int)stef.x, (int)stef.y + 40, 40 * 3));
			add(new MoveTo("stef", (int)stef.x, (int)-64, 40 * 6));
			add(new Fade(Color.WHITE, 1, false));
			add(new Wait(1));
			add(new NextScene(new MarioScene()));
		}
	}
	
	public void processInput(float deltaTime) {
		boolean kickingStart = false;
		
		if(state != State.Kick) {
			state = State.Idle;
			
			if(Gdx.input.isKeyPressed(Keys.A)) {
				state = State.Left;
				lastMovingDirection = -1;
			}
			if(Gdx.input.isKeyPressed(Keys.D)) {
				state = State.Right;
				lastMovingDirection = 1;
			}
			
			for(int i = 0; i < 2; i++) {
				touch.set(Gdx.input.getX(i), Gdx.input.getY(i), 0);
				Game.ctx.camera.unproject(touch);
				
				if(Gdx.input.isTouched(i)) {
					if(touch.x < 64) {
						state = State.Left;
						lastMovingDirection = 1;
					}
					
					if(touch.x > 64 && touch.x < 128) {
						state = State.Right;
						lastMovingDirection = -1;
					}
				}
				
				if(Game.ctx.justTouched[i]) {																
					if(touch.x > 214) {
						state = State.Kick;
						kickingStart = true;
					}
				}									
			}							
		}				
		
		if(kickingStart) {
			kickstart = System.nanoTime();
			if(lastMovingDirection < 0) stef.setAnimation("kick-left", false);
			if(lastMovingDirection >= 0) stef.setAnimation("kick-right", false);
		}		
		
		if(state == State.Left) {
			stef.setAnimation("walk-left", true);
			stef.x += -80 * deltaTime;
			if(stef.x < 0) stef.x = 0;
		}
		if(state == State.Right) {
			stef.setAnimation("walk-right", true);
			stef.x += 80 * deltaTime;
			if(stef.x > 288) stef.x = 288;
		}
		
		if(state == State.Idle) {
			if(lastMovingDirection < 0) stef.setAnimation("idle-left", true);
			else stef.setAnimation("idle-right", true);
		}
		
		if(state == State.Kick && (System.nanoTime() - kickstart > 100000000)) {
			kickstart = 0;				
			state = State.Idle;
		}
	}
}
