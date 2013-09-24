package com.badlogic.sol.drawables;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.sol.Drawable;

public class TextDrawable extends Drawable {
	String fontName;
	String text;
	int x, y, z;
	
	public TextDrawable(String name, String fontName, String text, int x, int y, int z) {
		super(name);
		this.fontName = fontName;
		this.text = text;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void draw (float deltaTime, SpriteBatch batch) {
	};
}
