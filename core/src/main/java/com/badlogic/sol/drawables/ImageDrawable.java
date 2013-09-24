package com.badlogic.sol.drawables;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.sol.Assets;
import com.badlogic.sol.Drawable;

public class ImageDrawable extends Drawable {
	String imageName;
	
	public ImageDrawable(String name, String imageName, int x, int y, int z) {
		super(name, x, y, z);
		this.imageName = imageName;
	}
	
	@Override
	public void draw (float deltaTime, SpriteBatch batch) {
		batch.draw(Assets.getImage(imageName), x, y);
	}
}
