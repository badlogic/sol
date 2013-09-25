package com.badlogic.sol.command;

import com.badlogic.sol.Command;
import com.badlogic.sol.Inventory;

/**
 * Adds the item to the inventory
 * @author badlogic
 *
 */
public class AddItem implements Command {
	String item;
	
	public AddItem(String item) {
		this.item = item;
	}
	
	@Override
	public void update (float delta) {
		Inventory.add(item);
	}

	@Override
	public boolean isDone () {
		return true;
	}

	@Override
	public Command copy () {
		return this;
	}
}
