package com.badlogic.sol;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Drawable {
	public String name;
	public int z;
	public float x;
	public float y;
	
	public Drawable(String name) {
		this.name = name;
	}
	
	public abstract void draw(float deltaTime, SpriteBatch batch);
}
