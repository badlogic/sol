package com.badlogic.sol.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.sol.Scene;
import com.badlogic.sol.command.MoveTo;
import com.badlogic.sol.command.New;
import com.badlogic.sol.command.SetAnimation;
import com.badlogic.sol.command.Wait;
import com.badlogic.sol.drawables.AnimationDrawable;
import com.badlogic.sol.drawables.Fade;
import com.badlogic.sol.drawables.ImageDrawable;
import com.badlogic.sol.drawables.TextDrawable;

public class MarioScene extends Scene {
	public MarioScene() {
		commands.add(new New(new ImageDrawable("background", "supermario", 0, 0, 0)));
		commands.add(new New(new AnimationDrawable("stef", "idle-left", 280, 32, 0)));
		commands.add(new New(new ImageDrawable("mushroom", "mushroom", 0, 0, 0)));
		
		commands.add(new New(new Fade(Color.WHITE, 1, true)));
		commands.add(new Wait(1));
		commands.add(new SetAnimation("stef", "walk-left"));
		commands.add(new MoveTo("stef", 87, 32, 64));
		commands.add(new SetAnimation("stef", "front"));
		commands.add(new Wait(1));
		commands.add(new SetAnimation("stef", "idle-left"));
		commands.add(new Wait(1f));
		commands.add(new SetAnimation("stef", "idle-right"));
		commands.add(new Wait(1f));
		commands.add(new SetAnimation("stef", "front"));
		commands.add(new New(new TextDrawable("W.T.F?!", Color.WHITE, 30, 87, 130, 10)));
		commands.add(new New(new Fade(Color.WHITE, 3600, false)));
	}
}
