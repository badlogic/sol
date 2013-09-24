package com.badlogic.sol.command;

import com.badlogic.sol.Command;
import com.badlogic.sol.Drawable;
import com.badlogic.sol.Game;

public class New implements Command {
	Drawable drawable;
	
	public New(Drawable drawable) {
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
}
