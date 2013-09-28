package com.badlogic.sol.command;

import com.badlogic.sol.Assets;
import com.badlogic.sol.Command;

public class PlayMusic implements Command {
	String name;
	boolean looped = true;
	
	public PlayMusic(String name) {
		this(name, true);
	}
	
	public PlayMusic(String name, boolean looped) {
		this.name = name;
		this.looped = looped;
	}
	
	@Override
	public void update (float delta) {
		Assets.playMusic(name, 0.8f, looped);
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
