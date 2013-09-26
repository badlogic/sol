package com.badlogic.sol;

import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.uikit.UIApplication;

import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration;
import com.badlogic.sol.Sol;

public class IOSLauncher extends IOSApplication.Delegate {
	@Override
	protected IOSApplication createApplication() {
		IOSApplicationConfiguration config = new IOSApplicationConfiguration();
		return new IOSApplication(new Sol(), config);
	}

	public static void main(String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, IOSLauncher.class);
		pool.drain();
	}
}
