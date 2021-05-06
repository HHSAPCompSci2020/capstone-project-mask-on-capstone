package gamecomponents.people;

import display.Location;
import display.Tier;
import processing.core.PApplet;

public class Player extends Person {

	int[] inventory; //0 = mask, 1= infected, 2= doctor, 3= researcher
	boolean isInfected;
	boolean hasPPE;
	boolean hasPerson;
	char direction;
	
	public Player(Location loc, boolean isInfected, char direction) {
		super(loc, isInfected, direction);
		inventory = new int[]{0,0,0,0};
		
		// TODO Auto-generated constructor stub
	}
	
	@Override 
	public void draw(PApplet marker, Tier t) {
		if (this.getLocation() != null) {
			if(inventory[0] > 0) 
				marker.image(marker.loadImage("images/HazmatManMask.png"), t.getX() + 40 * this.getLocation().getCol(), t.getY() + 40 * this.getLocation().getRow(), 40, 40);
			else
				marker.image(marker.loadImage("images/HazmatMan.png"), t.getX() + 40 * this.getLocation().getCol(), t.getY() + 40 * this.getLocation().getRow(), 40, 40);
				
		}
	}
	public void grabPerson(Person p) {
		
	}
	public void dropPerson(Person p) {
		
	}
	public void giveMask(Person p) {
		if (inventory[0] >0) inventory[0]--;
		if (!p.isInfected() || p.isVaccinated() && !p.isMasked()) {
			p.takeMask();
		}
	}
	public void update(Tier t) {

	}
	
	public int[] getInventory() {
		return inventory;
	}
	
}