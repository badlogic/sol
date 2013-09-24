package com.badlogic.sol.command;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.sol.Command;
import com.badlogic.sol.Drawable;
import com.badlogic.sol.Game;

public class MoveTo implements Command {
	Drawable d;
	String name;
	int x, y;
	float speed;
	Vector2 v = new Vector2();
	
	public MoveTo(String name, int x, int y, float speed) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
	
	@Override
	public void update (float delta) {
		if(d == null) d = Game.ctx.getDrawable(name);
		v.set(x - d.x, y - d.y).nor().scl(delta * speed);
		d.x = d.x + v.x;
		d.y = d.y + v.y;
	}

	@Override
	public boolean isDone () {
		return Math.abs(d.x - x) < 1 && Math.abs(d.y - y) < 1;
	}
}
