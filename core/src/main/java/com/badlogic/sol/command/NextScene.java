package com.badlogic.sol.command;

import com.badlogic.sol.Command;
import com.badlogic.sol.Game;
import com.badlogic.sol.Scene;

/**
 * Switches to the next scene
 * @author badlogic
 *
 */
public class NextScene implements Command {
	Scene scene;
	
	public NextScene(Scene scene) {
		this.scene = scene;
	}
	
	@Override
	public void update (float delta) {
		Game.ctx.setScene(scene);
	}

	@Override
	public boolean isDone () {
		return true;
	}

	@Override
	public Command copy () {
		return this;
	}

}
