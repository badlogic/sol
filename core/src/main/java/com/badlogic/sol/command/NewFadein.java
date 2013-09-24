package com.badlogic.sol.command;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.sol.Command;
import com.badlogic.sol.Game;
import com.badlogic.sol.drawables.Fadein;

public class NewFadein implements Command {
	Color color;
	float duration;
	
	public NewFadein(Color color, float duration) {
		this.color = color;
		this.duration = duration;
	}

	@Override
	public void update (float delta) {
		Game.ctx.addDrawable(new Fadein(color, duration));
	}

	@Override
	public boolean isDone () {
		return true;
	}
}
