package com.badlogic.sol.drawables;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.sol.Assets;
import com.badlogic.sol.Drawable;

public class AnimationDrawable extends Drawable {
	public String animationName;
	float stateTime;
	
	public AnimationDrawable (String name, String animationName, int startX, int startY, int z) {
		super(name);
		this.animationName = animationName;
		this.x = startX;
		this.y = startY;
		this.z = z;
	}

	@Override
	public void draw (float deltaTime, SpriteBatch batch) {
		stateTime += deltaTime;
		TextureRegion region = Assets.getAnimation(animationName).getKeyFrame(stateTime, true);
		batch.draw(region, x, y);
	}
}
