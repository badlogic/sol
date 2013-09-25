package com.badlogic.sol.command;

import com.badlogic.sol.Command;

public class Nop implements Command {
	@Override
	public void update (float delta) {
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
