package gamecomponents.people;

import display.Location;
import display.Tier;
import processing.core.PApplet;

/**
 * The Doctor class represents a Person that is immune to Covid and can be used to create Hospitals.
 * @author Felicia Zhang
 *
 */
public class Doctor extends Person {
	
	/**
	 * Creates a Doctor with given information, automatically vaccinated
	 * @param loc Location at which the Person starts at
	 * @param direction which direction the Person will start moving in
	 */
	public Doctor(Location loc, char direction) {
		super(loc, false, direction);
		getVaccinated();
	}
	
	/**
	 * Draws the Doctor in the given Tier with the given PApplet
	 * @param marker PApplet on which the Doctor is drawn
	 * @param t Tier in which the Doctor is drawn
	 * @pre this method runs with the conditions previously set on the given PApplet
	 */
	public void draw(PApplet marker, Tier t) {
		if (getLocation() != null) {
			marker.image(marker.loadImage("images/doctor.png"), t.getX() + 40 * getLocation().getCol(), t.getY() + 40 * getLocation().getRow(), 40, 40);
		}
	}
	
	/**
	 * Moves the Doctor diagonally
	 */
	public void move() {
		char direction = this.getDirection();
		Location loc = this.getLocation();
		
		if (direction == 'u') {
			this.setLocation(new Location(loc.getRow() - 1, loc.getCol()+1));	
		}
		else if (direction == 'd') {
			this.setLocation(new Location(loc.getRow() + 1, loc.getCol()-1));
		}
		else if (direction == 'l') {
			this.setLocation(new Location(loc.getRow() - 1, loc.getCol()-1));
		}
		else if (direction == 'r'){
			this.setLocation(new Location(loc.getRow() + 1, loc.getCol()+1));
		}
	}
	
	/**
	 * The doctor will check if it can move diagonally
	 * @param t the Tier in which the Doctor is
	 * @return whether the Doctor can move or not
	 */
	public boolean canMove(Tier t) {
		
		char direction = this.getDirection();
		if (this.getLocation() == null) return false;
		
		Location loc;
		if (direction == 'u') loc = new Location(this.getLocation().getRow()-1, this.getLocation().getCol()+1);
		else if (direction == 'd') loc = new Location(this.getLocation().getRow()+1, this.getLocation().getCol()-1);
		else if (direction == 'l') loc = new Location(this.getLocation().getRow()-1, this.getLocation().getCol()-1);
		else loc = new Location(this.getLocation().getRow()+1, this.getLocation().getCol()+1);
		
		//if (loc == null) return false;
		if (loc.isOutOfBounds(t)) {
			if (direction == 'u') direction = 'd';
			else if (direction == 'd') direction ='u';
			else if (direction == 'l') direction ='r';
			else if (direction == 'r') direction ='l';
			
			return false;
		}
		else if (t.getComponentAtLoc(loc) == null) return true;
		else {
			if (direction == 'u') direction = 'd';
			else if (direction == 'd') direction ='u';
			else if (direction == 'l') direction ='r';
			else if (direction == 'r') direction ='l';
			
			return false;
		}
		
	}
	
}