package com.badlogic.sol.command;

import com.badlogic.sol.Command;
import com.badlogic.sol.Game;
import com.badlogic.sol.drawables.ImageDrawable;

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
		Game.ctx.addDrawable(new ImageDrawable(name, imageName, x, y, z));
	}

	@Override
	public boolean isDone () {
		return true;
	}
}
