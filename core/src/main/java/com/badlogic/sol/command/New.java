package com.badlogic.sol.command;

import com.badlogic.sol.Command;
import com.badlogic.sol.Entity;
import com.badlogic.sol.Game;

/**
 * Creates a new {@link Entity} and adds it to 
 * the {@link Game}
 * @author badlogic
 *
 */
public class New implements Command {
	Entity drawable;
	
	public New(Entity drawable) {
		this.drawable = drawable;
	}
	
	@Override
	public void update (float delta) {
		Game.ctx.addDrawable(drawable);
	}

	@Override
	public boolean isDone () {
		return true;
	}

	@Override
	public Command copy () {
		return new New(drawable.copy());
	}
}
