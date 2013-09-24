package com.badlogic.sol.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.sol.Scene;
import com.badlogic.sol.command.MoveTo;
import com.badlogic.sol.command.SetAnimation;
import com.badlogic.sol.command.Wait;
import com.badlogic.sol.drawables.AnimationDrawable;
import com.badlogic.sol.drawables.Fade;
import com.badlogic.sol.drawables.ImageDrawable;
import com.badlogic.sol.drawables.TextDrawable;

public class MarioScene extends Scene {
	public MarioScene() {
		add(new ImageDrawable("background", "supermario", 0, 0, 0));
		add(new AnimationDrawable("stef", "idle-left", 280, 32, 0));
		add(new ImageDrawable("mushroom", "mushroom", 0, 0, 0));
		
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
		add(new TextDrawable("W.T.F?!", Color.WHITE, 30, 87, 130, 10));
		add(new Fade(Color.WHITE, 3600, false));
	}
}
