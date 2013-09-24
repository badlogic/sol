package com.badlogic.sol.scenes;

import com.badlogic.sol.Scene;
import com.badlogic.sol.command.MoveTo;
import com.badlogic.sol.command.NewAnimation;
import com.badlogic.sol.command.NewImage;
import com.badlogic.sol.command.SetAnimation;
import com.badlogic.sol.command.Wait;

public class OutdoorScene extends Scene {
	public OutdoorScene() {
		commands.add(new NewImage("background", "outdoor", 0, 0, 0));
		commands.add(new NewAnimation("stef", "idle-left", 280, 80, 0));
//		commands.add(new Wait(2));
		commands.add(new SetAnimation("stef", "walk-left"));
		commands.add(new MoveTo("stef", 87, 80, 64));
		commands.add(new SetAnimation("stef", "back"));
	}
}
