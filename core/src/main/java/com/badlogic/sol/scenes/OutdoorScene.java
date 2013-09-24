package com.badlogic.sol.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.sol.Scene;
import com.badlogic.sol.command.New;
import com.badlogic.sol.command.SetAnimation;
import com.badlogic.sol.command.Wait;
import com.badlogic.sol.drawables.AnimationDrawable;
import com.badlogic.sol.drawables.Fade;
import com.badlogic.sol.drawables.ImageDrawable;
import com.badlogic.sol.drawables.TextDrawable;

public class OutdoorScene extends Scene {
	public OutdoorScene() {
		commands.add(new New(new ImageDrawable("background", "outdoor", 0, 0, 0)));
		commands.add(new New(new AnimationDrawable("stef", "idle-left", 280, 80, 10)));
		
		commands.add(new New(new Fade(Color.WHITE, 1, true)));
		commands.add(new Wait(2));
		commands.add(new New(new TextDrawable("Dum Di Dum...", Color.BLACK, 2.5f, 250, 82 + 64 + 40, 0)));
		commands.add(new Wait(2.5f));
		commands.add(new SetAnimation("stef", "front"));		
		commands.add(new New(new TextDrawable("Cold out here", Color.BLACK, 2.5f, 250, 82 + 64 + 40, 0)));
	}
}
