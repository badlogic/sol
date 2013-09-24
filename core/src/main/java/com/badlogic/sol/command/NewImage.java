package com.badlogic.sol.command;

import com.badlogic.sol.Command;
import com.badlogic.sol.Game;

public class NewImage implements Command {
	String name;
	String imageName;
	int x, y, z;
	
	public NewImage(String name, String imageName, int x, int y, int z) {
		this.name = name;
		this.imageName = imageName;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void update (float delta) {
		Game.ctx.addImage(name, imageName, x, y, z);
	}

	@Override
	public boolean isDone () {
		return true;
	}
}
