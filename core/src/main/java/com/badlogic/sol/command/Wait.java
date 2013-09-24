package com.badlogic.sol.command;

import com.badlogic.sol.Command;

public class Wait implements Command {
	float duration;
	float stateTime;
	
	public Wait(float duration) {
		this.duration = duration;
	}

	@Override
	public void update (float delta) {
		stateTime += delta;
	}

	@Override
	public boolean isDone () {
		return stateTime >= duration;
	}
}
