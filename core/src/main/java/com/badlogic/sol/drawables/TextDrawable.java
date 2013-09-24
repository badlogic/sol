package com.badlogic.sol.drawables;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.sol.Assets;
import com.badlogic.sol.Drawable;
import com.badlogic.sol.Game;

public class TextDrawable extends Drawable {
	String fontName;
	Color color;
	String text;	
	float duration;
	float stateTime;
	
	public TextDrawable(String fontName, Color color, String text, float duration, int x, int y, int z) {
		super("" + MathUtils.random(), x, y, z);
		this.fontName = fontName;
		this.color = color;
		this.text = text;
		this.duration = duration;
	}

	@Override
	public void draw (float deltaTime, SpriteBatch batch) {
		stateTime += deltaTime;
		if(stateTime > duration) {
			Game.ctx.removeDrawable(this);
			return;
		}
		
		TextBounds bounds = Assets.font.getBounds(text);
		Assets.font.setColor(color);
		Assets.font.draw(batch, text, x - (int)(bounds.width / 2), y + (int)(bounds.height / 2));
	};
}
