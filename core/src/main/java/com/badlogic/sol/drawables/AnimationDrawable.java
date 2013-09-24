package com.badlogic.sol.drawables;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.sol.Assets;
import com.badlogic.sol.Drawable;

public class AnimationDrawable extends Drawable {
	String animationName;
	float stateTime;
	
	public AnimationDrawable (String name, String animationName, int x, int y, int z) {
		super(name, x, y, z);
		this.animationName = animationName;
	}

	@Override
	public void draw (float deltaTime, SpriteBatch batch) {
		stateTime += deltaTime;
		TextureRegion region = Assets.getAnimation(animationName).getKeyFrame(stateTime, true);
		batch.draw(region, x, y);
	}
	
	public void setAnimation(String animationName) {
		this.animationName = animationName;
		this.stateTime = 0;
	}
}
