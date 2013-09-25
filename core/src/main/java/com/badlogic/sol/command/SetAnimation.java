package com.badlogic.sol.command;

import com.badlogic.sol.Command;
import com.badlogic.sol.Game;
import com.badlogic.sol.entity.Animated;

/**
 * Sets the animation on an {@link Animated} entity.
 * @author badlogic
 *
 */
public class SetAnimation implements Command {
	String name;
	String animationName;
	
	public SetAnimation(String name, String animationName) {
		this.name = name;
		this.animationName = animationName;
	}
	
	
	@Override
	public void update (float delta) {
		((Animated)Game.ctx.getDrawable(name)).setAnimation(animationName);
	}

	@Override
	public boolean isDone () {
		return true;
	}


	@Override
	public Command copy () {
		return new SetAnimation(name, animationName);
	}
}
