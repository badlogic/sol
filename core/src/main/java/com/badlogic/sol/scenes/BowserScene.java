package com.badlogic.sol.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.sol.Scene;
import com.badlogic.sol.command.MoveToAnim;
import com.badlogic.sol.command.SetAnimation;
import com.badlogic.sol.command.Wait;
import com.badlogic.sol.entity.Animated;
import com.badlogic.sol.entity.Fade;
import com.badlogic.sol.entity.Image;

public class BowserScene extends Scene {
	Animated stef;
	Animated bowser;
	
	public BowserScene() {
		add(new Image("background", "dungeon", 0, 0, 0));
		stef = new Animated("stef", "idle-left", -32, 60, 0);
		bowser = new Animated("bowser", "bowser", 230, 60, 3);	
		add(stef);
		add(bowser);
		add(new Image("chain", "chain", 280, 60, 1));
		
		add(new Fade(Color.WHITE, 1, true));
		add(new Wait(1));
		add(new MoveToAnim("stef", "walk", 52, 60, 64));
		add(new SetAnimation("stef", "idle-right"));
	}

	@Override
	public void update (float deltaTime) {
		super.update(deltaTime);
		
		if(commands.size == 0) {
			
		}
	}
}
