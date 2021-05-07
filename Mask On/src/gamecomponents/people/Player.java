package gamecomponents.people;

import display.Location;
import display.Tier;
import processing.core.PApplet;
/**
 * The Player class is a Person that is controlled by the user.
 */
public class Player extends Person {

	int[] inventory; //0 = mask, 1= infected, 2= doctor, 3= researcher
	boolean isInfected;
	boolean hasPPE;
	boolean hasPerson;
	/**
	 * Creates a Player with given information
	 * @param loc Location at which the Player starts at
	 * @param isInfected whether the Player starts out infected or not
	 * @param direction which direction the Player will start moving in
	 */
	public Player(Location loc, boolean isInfected, char direction) {
		super(loc, isInfected, direction);
		inventory = new int[]{0,0,0,0};
		
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Draws the Player in the given Tier with the given PApplet
	 * @param marker PApplet on which the Player is drawn
	 * @param t Tier in which the Player is drawn
	 * @pre this method runs with the conditions previously set on the given PApplet
	 */
	public void draw(PApplet marker, Tier t) {
		if (this.getLocation() != null) {
			if(inventory[0] > 0) 
				marker.image(marker.loadImage("images/HazmatManMask.png"), t.getX() + 40 * this.getLocation().getCol(), t.getY() + 40 * this.getLocation().getRow(), 40, 40);
			else
				marker.image(marker.loadImage("images/HazmatMan.png"), t.getX() + 40 * this.getLocation().getCol(), t.getY() + 40 * this.getLocation().getRow(), 40, 40);
				
		}
	}
	/**
	 * Picks up a person from the Tier and updates the Inventory
	 * @param p the person that needs to put in the Inventory
	 * @param t the Tier in which the the person is in
	 */
	public void grabPerson(Person p, Tier t) {
		if (p.isInfected()) inventory[1]++;
		if (p instanceof Doctor) inventory[2]++;
		if (p instanceof Researcher) inventory[3]++;
		
		t.removeFromGrid(p);	
	}
	/**
	 * Puts the person in a random adjacent spot
	 * @param p the person that needs to be placed
	 * @param t the Tier in which the the person is in
	 */
	public void dropPerson(Person p, Tier t) {
		if (p.isInfected()) inventory[1]--;
		if (p instanceof Doctor) inventory[2]--;
		if (p instanceof Researcher) inventory[3]--;
		
		p.setLocation(new Location(this.getLocation().getRow()+1, this.getLocation().getCol()));
		t.addPersonToGrid(p);
	}
	/**
	 * Gives a person a mask
	 * @param p the person that needs a mask
	 */
	public void giveMask(Person p) {
		if (inventory[0] >0) inventory[0]--;
		if (!p.isInfected() || p.isVaccinated() && !p.isMasked()) {
			p.takeMask();
		}
	}
	/**
	 * Updates a Tier
	 * @param t the Tier that needs to be updated
	 */
	public void update(Tier t) {
		
	}
	
	@Override
	//player cannot contract the virus
	//not yet coded
	public void contractVirus() {
		
	}
	/**
	 * 
	 * @return the inventory
	 */
	public int[] getInventory() {
		return inventory;
	}
	/**
	 * Checks whether the Player can move
	 * @param t Tier in which the Player is inside
	 * @return whether or not the Player can move
	 */
	public boolean canMove(Tier t) {
		Location loc = this.getLocation();
				System.out.println("You are at: " + this.getLocation().getRow() + "," + this.getLocation().getCol());
		char direction = this.getDirection();
	
		if (loc.isOutOfBounds(t)) return false;
		
				//System.out.println(loc.getRow() + "," + loc.getCol());
				
		if (direction == 'u') 
			if (t.getComponentAtLoc(loc.getTop(t)) != null) 
				if (t.getComponentAtLoc(loc.getBottom()) != null) 
					return false;
		
		else if (direction == 'd') 
			if (t.getComponentAtLoc(loc.getBottom()) != null) 
				if (t.getComponentAtLoc(loc.getTop(t)) != null) 
					return false;
		
		else if (direction == 'l') 
			if (t.getComponentAtLoc(loc.getLeft()) != null) 
				if (t.getComponentAtLoc(loc.getRight()) != null) 
					return false;
		
		else 
			if (t.getComponentAtLoc(loc.getRight()) != null) 
				if (t.getComponentAtLoc(loc.getLeft()) != null) 
					return false;
		
		
		return true;
	}
	

}