package com.badlogic.sol.command;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.sol.Command;
import com.badlogic.sol.Game;
import com.badlogic.sol.drawables.TextDrawable;

public class NewText implements Command {
	String fontName;
	Color color = Color.WHITE;
	String text;
	int x, y, z;
	float duration;
	
	public NewText(String text, Color color, float duration, int x, int y, int z) {
		this.text = text;
		this.color = color;
		this.x = x;
		this.y = y;
		this.z = z;
		this.duration = duration;
	}
	
	public NewText(String text, float duration, int x, int y, int z) {
		this(text, Color.WHITE, duration, x, y, z);
	}
	
	@Override
	public void update (float delta) {
		Game.ctx.addDrawable(new TextDrawable(fontName, color, text, duration, x, y, z));
	}

	@Override
	public boolean isDone () {
		return true;
	}
}
