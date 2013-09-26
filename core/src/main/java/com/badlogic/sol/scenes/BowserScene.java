package com.badlogic.sol.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.sol.Scene;
import com.badlogic.sol.command.MoveToAnim;
import com.badlogic.sol.command.Wait;
import com.badlogic.sol.entity.Animated;
import com.badlogic.sol.entity.Fade;
import com.badlogic.sol.entity.Image;

public class BowserScene extends Scene {
	Animated stef;
	
	public BowserScene() {
		add(new Image("background", "supermario", 0, 0, 0));
		stef = new Animated("stef", "idle-left", 280, 64, 0); 
		add(stef);
		
		add(new Fade(Color.WHITE, 1, true));
		add(new Wait(1));
		add(new MoveToAnim("stef", "walk", 87, 64, 64));
	}
}
