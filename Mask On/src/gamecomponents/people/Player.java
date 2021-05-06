package gamecomponents.people;

import display.Location;

public class Player extends Person {

	int[] inventory; //0 = mask, 1= infected, 2= doctor, 3= researcher
	
	public Player(Location loc, boolean isInfected, char direction) {
		super(loc, isInfected, direction);
		inventory = new int[]{0,0,0,0};
		
		// TODO Auto-generated constructor stub
	}
	public int[] getInventory() {
		return inventory;
	}
	
}