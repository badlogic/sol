
package com.badlogic.sol;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.sol.scenes.MarioScene;


public class Sol extends ApplicationAdapter {
	Game game;
	
	@Override
	public void create () {
		game = new Game();
		game.setScene(new MarioScene());
	}

	@Override
	public void render () {
		game.render();
	}
}
