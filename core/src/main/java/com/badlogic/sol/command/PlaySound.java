package com.badlogic.sol.command;

import com.badlogic.sol.Assets;
import com.badlogic.sol.Command;

public class PlaySound implements Command {
	String name;
	
	public PlaySound(String name) {
		this.name = name;
	}
	
	@Override
	public void update (float delta) {
		Assets.playSound(name);
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
