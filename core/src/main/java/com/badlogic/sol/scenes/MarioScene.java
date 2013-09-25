package com.badlogic.sol.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.sol.Scene;
import com.badlogic.sol.command.MoveTo;
import com.badlogic.sol.command.SetAnimation;
import com.badlogic.sol.command.Wait;
import com.badlogic.sol.entity.Animated;
import com.badlogic.sol.entity.Fade;
import com.badlogic.sol.entity.Image;
import com.badlogic.sol.entity.Text;

public class MarioScene extends Scene {
	public MarioScene() {
		add(new Image("background", "supermario", 0, 0, 0));
		add(new Animated("stef", "idle-left", 280, 32, 0));
		add(new Image("mushroom", "mushroom", 0, 0, 0));
		
		add(new Fade(Color.WHITE, 1, true));
		add(new Wait(1));
		add(new SetAnimation("stef", "walk-left"));
		add(new MoveTo("stef", 87, 32, 64));
		add(new SetAnimation("stef", "front"));
		add(new Wait(1));
		add(new SetAnimation("stef", "idle-left"));
		add(new Wait(1f));
		add(new SetAnimation("stef", "idle-right"));
		add(new Wait(1f));
		add(new SetAnimation("stef", "front"));
		add(new Text("W.T.F?!", Color.WHITE, 30, 87, 130));
		add(new Fade(Color.WHITE, 3600, false));
	}
}
