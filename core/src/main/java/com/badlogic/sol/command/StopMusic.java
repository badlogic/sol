package com.badlogic.sol.command;

import com.badlogic.sol.Assets;
import com.badlogic.sol.Command;

public class StopMusic implements Command {
	String name;
	
	public StopMusic(String name) {
		this.name = name;
	}
	
	@Override
	public void update (float delta) {
		Assets.stopMusic(name);
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
