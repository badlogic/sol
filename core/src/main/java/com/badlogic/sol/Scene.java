package com.badlogic.sol;

import com.badlogic.gdx.utils.Array;

public class Scene {
	protected Array<Command> commands = new Array<Command>();
	
	public void update(float deltaTime) {
		while(commands.size > 0) {
			Command cmd = commands.get(0);
			cmd.update(deltaTime);
			if(cmd.isDone()) {
				commands.removeIndex(0);
			} else {
				break;
			}
		}
	}
}
