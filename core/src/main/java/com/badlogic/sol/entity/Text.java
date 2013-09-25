package com.badlogic.sol.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.sol.Assets;
import com.badlogic.sol.Entity;
import com.badlogic.sol.Game;

public class Text extends Entity {
	String fontName;
	Color color;
	String text;	
	float duration;
	float stateTime;
	
	public Text(String text, Color color, float duration, int x, int y) {
		this("default", text, color, duration, x, y, 10000000);
	}
	
	public Text(String fontName, String text, Color color, float duration, int x, int y, int z) {
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
		
		float alpha = 1;
		if(stateTime < 0.4f) {
			alpha = stateTime / 0.4f;
		}
		
		if(stateTime > duration - 0.2f) {			
			alpha = ((duration - stateTime) / 0.2f);
		}
		
		TextBounds bounds = Assets.font.getBounds(text);
		Assets.font.setColor(color.r, color.g, color.b, alpha);
		Assets.font.draw(batch, text, x - (int)(bounds.width / 2), y + (int)(bounds.height / 2));
	}

	@Override
	public Entity copy () {
		return new Text(fontName, text, color, duration, (int)x, (int)y, (int)z);
	};
}
