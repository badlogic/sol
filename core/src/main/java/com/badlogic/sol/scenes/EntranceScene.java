package com.badlogic.sol.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.sol.Inventory;
import com.badlogic.sol.Scene;
import com.badlogic.sol.Trigger;
import com.badlogic.sol.command.AddItem;
import com.badlogic.sol.command.IfHas;
import com.badlogic.sol.command.IfHasNot;
import com.badlogic.sol.command.MoveToAnim;
import com.badlogic.sol.command.New;
import com.badlogic.sol.command.NextScene;
import com.badlogic.sol.command.Remove;
import com.badlogic.sol.command.SetAnimation;
import com.badlogic.sol.command.SetZ;
import com.badlogic.sol.command.Wait;
import com.badlogic.sol.entity.Animated;
import com.badlogic.sol.entity.Fade;
import com.badlogic.sol.entity.Image;
import com.badlogic.sol.entity.Text;

public class EntranceScene extends Scene {
	public EntranceScene() {
		// setup scene
		add(new Image("background", "entrance", 0, 0, 0));
		add(new Animated("stef", "front", 35, 80, 10));
		add(new Animated("panel", "panel", 68, 120, 0));
		
		// intro
		add(new Fade(Color.WHITE, 1, true));		
		add(new SetAnimation("stef", "front"));
		add(new Text("I feel stinky", Color.BLACK, 2f, 50, 186));
		add(new Wait(2f));
		
		// books trigger
		add(new Trigger("books", 242, 80, 283, 145)
			.add(new MoveToAnim("stef", "walk", 250, 80, 64))
			.add(new SetAnimation("stef", "back"))
			.add(new Wait(0.2f))
			.add(new Text("books", Color.BLACK, 1, 260, 186))
			.add(new Wait(1))
			.add(new SetAnimation("stef", "front"))
			.add(new Wait(0.5f))
			.add(new Text("Duh", Color.BLACK, 1, 260, 186))
		);
		
		// outdoor trigger
		add(new Trigger("outdoor", 35, 86, 65, 162)
			.add(new MoveToAnim("stef", "walk", 35, 80, 64))
			.add(new SetAnimation("stef", "front"))
			.add(new Text("No way", Color.BLACK, 1, 50, 186))
			.add(new Wait(1))
			.add(new Text("It's even colder outside!", Color.BLACK, 2, 100, 186))
			.add(new Wait(2))
			.add(new Text("Also, birds", Color.BLACK, 2, 60, 186))
			.add(new Wait(2))
		);
		
		// washingroom trigger
		add(new Trigger("washingroom", 89, 80, 120, 155)
			.add(new MoveToAnim("stef", "walk", 89, 80, 64))
			.add(new SetAnimation("stef", "front"))
			.add(new Text("Nothing to wash", Color.BLACK, 1, 70, 186))
			.add(new Wait(1))
		);
		
		// wc trigger
		add(new Trigger("wc", 140, 80, 174, 155)
			.add(new MoveToAnim("stef", "walk", 142, 80, 64))
			.add(new SetAnimation("stef", "back"))
			.add(new IfHas(set("peepee"), array(
				new SetAnimation("stef", "front"),
				new New(new Text("I'm empty", Color.BLACK, 2f, 157, 186))
			)))			
			.add(new Text("Commencing Pee Pee", Color.BLACK, 2, 157, 186))
			.add(new Wait(2))
			.add(new Image("opendoor", "opendoor", 137, 80, 1))
			.add(new Wait(1))
			.add(new Remove("opendoor"))
			.add(new Image("door", "door", 137, 80, 100))
			.add(new Text("*Censored*", Color.MAGENTA, 2, 157, 186))
			.add(new Wait(2))
			.add(new Text("*FLUSH*", Color.MAGENTA, 2, 157, 186))
			.add(new Wait(3))
			.add(new Text("GOD DAMNIT", Color.RED, 2, 157, 186))
			.add(new Wait(2))
			.add(new Text("*FLUSH FLUSH*", Color.MAGENTA, 2, 157, 186))
			.add(new Wait(3))
			.add(new Text("GAHHH", Color.RED, 2, 157, 186))
			.add(new Wait(2))
			.add(new Text("*FLUSH FLUSH FLUSH*", Color.MAGENTA, 2, 157, 186))
			.add(new Wait(3))
			.add(new Remove("door"))
			.add(new SetAnimation("stef", "front"))
			.add(new Image("opendoor", "opendoor", 137, 80, 100))
			.add(new Wait(0.5f))
			.add(new SetZ("opendoor", 1))
			.add(new Wait(0.5f))
			.add(new Remove("opendoor"))
			.add(new Text("This Toilet must die", Color.RED, 2, 157, 186))
			.add(new Wait(2))
			.add(new Text("Achievement Unlocked: Rage Flush", Color.GREEN, 3, 157, 50))
			.add(new Wait(3))
			.add(new Text("Not funny!", Color.RED, 2, 157, 186))
			.add(new Wait(2))
			.add(new AddItem("peepee"))
		);
		
		// heating panel trigger
		add(new Trigger("panel", 66, 119, 78, 132)
			.add(new MoveToAnim("stef", "walk", 50, 80, 64))
			.add(new IfHasNot(set("panel"), array(				
				new SetAnimation("stef", "back"),
				new New(new Text("I hope heating works", Color.BLACK, 2, 100, 186)),
				new Wait(2),
				new New(new Text("*Tip Tap*", Color.MAGENTA, 2, 66, 186)),
				new Wait(2),
				new SetAnimation("stef", "front"),
				new New(new Text("Well, that didn't do anything", Color.BLACK, 2, 120, 186)),
				new AddItem("panel")
			)))
			.add(new IfHas(set("panel"), array(
				new SetAnimation("stef", "front"),
				new New(new Text("It's broken, no use in trying", Color.BLACK, 2, 120, 186)),
				new Wait(2)
			)))
		);

		// bathroom trigger
		add(new Trigger("bathroom", 195, 80, 228, 155)
			.add(new MoveToAnim("stef", "walk", 199, 80, 64))
			.add(new SetAnimation("stef", "back"))
			.add(new IfHasNot(set("peepee"), array(
				new SetAnimation("stef", "front"),
				new New(new Text("Not now, I really need to pee!", Color.BLACK, 2, 160, 186)),
				new Wait(2)
			)))
			.add(new IfHasNot(set("panel"), array(
				new SetAnimation("stef", "front"),
				new New(new Text("Got to turn up the heat first", Color.BLACK, 2, 160, 186)),
				new Wait(2)
			)))
			.add(new Text("To the shower!", Color.BLACK, 2, 160, 186))
			.add(new Wait(2))
			.add(new Image("opendoor", "opendoor", 190, 80, 1))
			.add(new Wait(1))
			.add(new Remove("opendoor"))
			.add(new Image("door", "door", 190, 80, 100))
			
			.add(new Text("*Undresses*", Color.MAGENTA, 2, 157, 186))
			.add(new Wait(2))
			.add(new Text("*Wooohooo*", Color.GREEN, 3, 157, 50))
			.add(new Wait(3))
			.add(new Text("Get the fuck out!", Color.RED, 2, 157, 186))
			.add(new Wait(2))
			.add(new Text("*Watersounds*", Color.MAGENTA, 2, 157, 186))
			.add(new Wait(2))
			.add(new Text("*Scrub Scrub*", Color.MAGENTA, 2, 157, 186))
			.add(new Wait(2))
			.add(new Text("*Towel Towel*", Color.MAGENTA, 2, 157, 186))
			.add(new Wait(2))
			.add(new Text("*Cream Cream*", Color.MAGENTA, 2, 157, 186))
			.add(new Wait(2))
			.add(new Text("*More Cream*", Color.MAGENTA, 2, 157, 186))
			.add(new Wait(2))
			.add(new Text("*Puts on Clothes*", Color.MAGENTA, 2, 157, 186))
			.add(new Wait(2))
			.add(new Text("*Boo Booo*", Color.GREEN, 3, 157, 50))
			.add(new Wait(3))
			
			.add(new Remove("door"))
			.add(new SetAnimation("stef", "front"))
			.add(new Image("opendoor", "opendoor", 190, 80, 100))
			.add(new Wait(0.5f))
			.add(new SetZ("opendoor", 1))
			.add(new Wait(0.5f))
			.add(new Remove("opendoor"))
			.add(new Text("My body is a temple", Color.RED, 2, 157, 186))
			.add(new Wait(2))
			.add(new Text("Achievement Unlocked: you sexy thing", Color.GREEN, 3, 157, 50))
			.add(new Wait(3))
			.add(new Text("Damn right", Color.RED, 2, 157, 186))
			.add(new Wait(2))
			.add(new Text("Time to play!", Color.RED, 2, 157, 186))
			.add(new Wait(2))
			.add(new MoveToAnim("stef", "walk", -32, 80, 64))
			.add(new Fade(Color.WHITE, 1, false))
			.add(new Wait(1))
			.add(new NextScene(new MarioScene(false)))
		);
	}
}
