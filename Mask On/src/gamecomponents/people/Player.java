package gamecomponents.people;

import display.Location;
import display.Tier;
import processing.core.PApplet;

public class Player extends Person {

	int[] inventory; //0 = mask, 1= infected, 2= doctor, 3= researcher
	boolean isInfected;
	boolean hasPPE;
	boolean hasPerson;
	
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
	public void grabPerson(Person p, Tier t) {
		if (p.isInfected()) inventory[1]++;
		if (p instanceof Doctor) inventory[2]++;
		if (p instanceof Researcher) inventory[3]++;
		
		t.removeFromGrid(p);	
	}
	public void dropPerson(Person p, Tier t) {
		if (p.isInfected()) inventory[1]--;
		if (p instanceof Doctor) inventory[2]--;
		if (p instanceof Researcher) inventory[3]--;
		
		p.setLocation(new Location(this.getLocation().getRow()+1, this.getLocation().getCol()));
		t.addPersonToGrid(p);
	}
	public void giveMask(Person p) {
		if (inventory[0] >0) inventory[0]--;
		if (!p.isInfected() || p.isVaccinated() && !p.isMasked()) {
			p.takeMask();
		}
	}
	public void update(Tier t) {
		
	}
	
	//player cannot contract the virus
	public void contractVirus() {
		
	}
	
	public int[] getInventory() {
		return inventory;
	}
	

	@Override
	public boolean canMove(Tier t) {
		Location loc = this.getLocation();
		char direction = this.getDirection();
	
		if (loc == null) return false;
		
				System.out.println(loc.getRow() + "," + loc.getCol());
				
		if (direction == 'u') 
			if (t.getComponentAtLoc(loc.getTop()) != null) 
				if (t.getComponentAtLoc(loc.getBottom()) != null) 
					return false;
		
		else if (direction == 'd') 
			if (t.getComponentAtLoc(loc.getBottom()) != null) 
				if (t.getComponentAtLoc(loc.getTop()) != null) 
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