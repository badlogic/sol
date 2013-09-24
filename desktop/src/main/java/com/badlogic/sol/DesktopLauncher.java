
package com.badlogic.sol;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.sol.Sol;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.useGL20 = true;
		config.width = 320 * 4;
		config.height = 240 * 4;
		new LwjglApplication(new Sol(), config);
	}
}
