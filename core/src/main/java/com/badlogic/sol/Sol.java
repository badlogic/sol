
package com.badlogic.sol;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.sol.scenes.BowserScene;


public class Sol extends ApplicationAdapter {
	Game game;
	
	@Override
	public void create () {
		game = new Game();
		game.setScene(new BowserScene());
	}

	@Override
	public void render () {
		game.render();
	}
}
