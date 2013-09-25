package com.badlogic.sol.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.sol.Scene;
import com.badlogic.sol.Trigger;
import com.badlogic.sol.command.MoveTo;
import com.badlogic.sol.command.MoveToAnim;
import com.badlogic.sol.command.SetAnimation;
import com.badlogic.sol.command.Wait;
import com.badlogic.sol.entity.Animated;
import com.badlogic.sol.entity.Fade;
import com.badlogic.sol.entity.Image;
import com.badlogic.sol.entity.Text;

public class OutdoorScene extends Scene {
	public OutdoorScene() {
		add(new Image("background", "outdoor", 0, 0, 0));
		add(new Animated("bird", "bird", 71, 177, 1));
		add(new Animated("stef", "idle-left", 320, 80, 10));
		
		// intro
		add(new Fade(Color.WHITE, 1, true));
		add(new MoveToAnim("stef", "walk", 220, 80, 64));
		add(new SetAnimation("stef", "front"));
		add(new Text("Dum Di Dum...", Color.BLACK, 2.5f, 250, 186));
		add(new Wait(2.5f));
		add(new SetAnimation("stef", "front"));		
		add(new Text("Cold out here", Color.BLACK, 2.5f, 250, 186));
		
		// bird trigger
		add(new Trigger("bird-trigger", 70, 177, 87, 195)
				.add(new MoveToAnim("stef", "walk", 60, 80, 64))
				.add(new SetAnimation("stef", "back"))
				.add(new Wait(1))
				.add(new Text("Away, stupid bird!", Color.BLACK, 2f, 71, 220))
				.add(new Wait(0.5f))
				.add(new SetAnimation("bird", "bird-fly"))
				.add(new MoveTo("bird", 200, 241, 80))
				.add(new SetAnimation("stef", "front"))
				.disable()
		);
		
		// window trigger
		add(new Trigger("window-trigger", 183, 118, 226, 152)
				.add(new MoveToAnim("stef", "walk", 200, 80, 64))
				.add(new SetAnimation("stef", "back"))
				.add(new Wait(1))
				.add(new SetAnimation("stef", "back"))
				.add(new Text("I hope he cleans that soon", Color.BLACK, 2f, 220, 186))
		);
	}
}
