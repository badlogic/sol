package com.badlogic.sol.scenes;

import com.badlogic.sol.Scene;
import com.badlogic.sol.command.MoveTo;
import com.badlogic.sol.command.NewAnimation;
import com.badlogic.sol.command.NewImage;
import com.badlogic.sol.command.NewText;
import com.badlogic.sol.command.SetAnimation;
import com.badlogic.sol.command.Wait;

public class MarioScene extends Scene {
	public MarioScene() {
		commands.add(new NewImage("background", "supermario", 0, 0, 0));
		commands.add(new NewAnimation("stef", "idle-left", 280, 32, 0));
		commands.add(new NewImage("mushroom", "mushroom", 0, 0, 0));
//		commands.add(new Wait(2));
		commands.add(new SetAnimation("stef", "walk-left"));
		commands.add(new MoveTo("stef", 87, 32, 64));
		commands.add(new SetAnimation("stef", "front"));
		commands.add(new Wait(1));
		commands.add(new SetAnimation("stef", "idle-left"));
		commands.add(new Wait(1f));
		commands.add(new SetAnimation("stef", "idle-right"));
		commands.add(new Wait(1f));
		commands.add(new SetAnimation("stef", "front"));
		commands.add(new NewText("W.T.F?!", 30, 87, 130, 10));
	}
}
