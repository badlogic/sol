package com.badlogic.sol;

import com.badlogic.gdx.utils.Array;
import com.badlogic.sol.command.New;

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
	
	public void add(Drawable drawable) {
		commands.add(new New(drawable));
	}
	
	public void add(Command command) {
		commands.add(command);
	}
}
