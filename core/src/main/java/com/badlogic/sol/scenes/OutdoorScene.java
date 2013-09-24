package com.badlogic.sol.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.sol.Scene;
import com.badlogic.sol.command.NewAnimation;
import com.badlogic.sol.command.NewFadein;
import com.badlogic.sol.command.NewImage;
import com.badlogic.sol.command.NewText;
import com.badlogic.sol.command.SetAnimation;
import com.badlogic.sol.command.Wait;

public class OutdoorScene extends Scene {
	public OutdoorScene() {
		commands.add(new NewImage("background", "outdoor", 0, 0, 0));
		commands.add(new NewAnimation("stef", "idle-left", 280, 80, 10));
		commands.add(new NewFadein(Color.WHITE, 1));
		commands.add(new Wait(2));
		commands.add(new NewText("Dum Di Dum...", Color.BLACK, 2.5f, 250, 82 + 64 + 40, 0));
		commands.add(new Wait(2.5f));
		commands.add(new SetAnimation("stef", "front"));		
		commands.add(new NewText("Cold out here", Color.BLACK, 2.5f, 250, 82 + 64 + 40, 0));
	}
}
