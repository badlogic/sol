
package com.badlogic.sol;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.sol.scenes.OutdoorScene;


public class Sol extends ApplicationAdapter {
	Game game;
	
	@Override
	public void create () {
		game = new Game();
		game.setScene(new OutdoorScene());
	}

	@Override
	public void render () {
		game.render();
	}
}
