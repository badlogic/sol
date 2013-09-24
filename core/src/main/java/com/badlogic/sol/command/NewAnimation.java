package com.badlogic.sol.command;

import com.badlogic.sol.Command;
import com.badlogic.sol.Game;

public class NewAnimation implements Command {
	String name;
	String animationName;
	int x, y, z;
	
	public NewAnimation(String name, String imageName, int x, int y, int z) {
		this.name = name;
		this.animationName = imageName;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void update (float delta) {
		Game.ctx.addAnimation(name, animationName, x, y, z);
	}

	@Override
	public boolean isDone () {
		return true;
	}
}
