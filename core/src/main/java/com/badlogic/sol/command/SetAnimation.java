package com.badlogic.sol.command;

import com.badlogic.sol.Command;
import com.badlogic.sol.Game;
import com.badlogic.sol.drawables.AnimationDrawable;

public class SetAnimation implements Command {
	String name;
	String animationName;
	
	public SetAnimation(String name, String animationName) {
		this.name = name;
		this.animationName = animationName;
	}
	
	
	@Override
	public void update (float delta) {
		((AnimationDrawable)Game.ctx.getDrawable(name)).setAnimation(animationName);
	}

	@Override
	public boolean isDone () {
		return true;
	}
}
