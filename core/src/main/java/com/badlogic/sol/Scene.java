package com.badlogic.sol;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.sol.command.New;

public class Scene {
	protected Array<Command> commands = new Array<Command>();
	protected Array<Trigger> triggers = new Array<Trigger>();
	
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
		
		if(commands.size == 0 && Gdx.input.justTouched()) {
			for(Trigger t: triggers) {
				if(t.hit(Game.ctx.getX(), Game.ctx.getY()) & !t.disabled) {
					for(Command c: t.commands) {
						commands.add(c.copy());
					}
				}
			}
		}
	}
	
	public void add(Entity drawable) {
		commands.add(new New(drawable));
	}
	
	public void add(Command command) {
		commands.add(command);
	}
	
	public void add(Trigger trigger) {
		triggers.add(trigger);
	}
	
	public void remove(Trigger trigger) {
		Iterator<Trigger> iter = triggers.iterator();
		while(iter.hasNext()) {
			Trigger t = iter.next();
			if(t == trigger) {
				iter.remove();
				break;
			}
		}
	}
}
