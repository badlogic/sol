package com.badlogic.sol.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.sol.Scene;
import com.badlogic.sol.command.MoveTo;
import com.badlogic.sol.command.MoveToAnim;
import com.badlogic.sol.command.SetAnimation;
import com.badlogic.sol.command.Wait;
import com.badlogic.sol.entity.Animated;
import com.badlogic.sol.entity.Fade;
import com.badlogic.sol.entity.Image;
import com.badlogic.sol.entity.Text;

public class MarioScene extends Scene {
	public MarioScene() {
		add(new Image("background", "supermario", 0, 0, 0));
		add(new Animated("stef", "idle-left", 280, 64, 0));
		
		add(new Fade(Color.WHITE, 1, true));
		add(new Wait(1));
		add(new MoveToAnim("stef", "walk", 87, 64, 64));
		add(new SetAnimation("stef", "front"));
		add(new Wait(1));
		add(new SetAnimation("stef", "idle-left"));
		add(new Wait(1f));
		add(new SetAnimation("stef", "idle-right"));
		add(new Wait(1f));
		add(new SetAnimation("stef", "front"));
		add(new Text("W.T.F?!", Color.WHITE, 3, 87, 130));
		add(new Animated("goomba", "goomba", 320, 64, 0));
		add(new MoveTo("goomba", 240, 64, 50));
		add(new SetAnimation("stef", "idle-right"));
		add(new Wait(2));
		add(new SetAnimation("stef", "front"));
		add(new Text("Uh Oh", Color.WHITE, 2, 87, 130));
		add(new SetAnimation("stef", "idle-right"));
		add(new MoveTo("goomba", 104, 64, 50));
		add(new SetAnimation("goomba", "goomba-dead", false));
		add(new SetAnimation("stef", "kick-right", false));
		add(new Wait(1));
		add(new SetAnimation("stef", "front", false));
		add(new Text("Stomp Stomp Motherfucker", Color.WHITE, 2, 110, 130));
	}
}
