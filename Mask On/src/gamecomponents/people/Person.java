package gamecomponents.people;

import java.util.ArrayList;
import display.GameComponent;
import display.Location;
import display.Tier;
import processing.core.PApplet;

/**
 * This class represents a Person on the grid displayed in a Tier
 * @author roshnibright
 *
 */
public class Person extends GameComponent {
	
	private Location loc;
	private boolean infected;
	private boolean masked;
	private boolean vaccinated;
	private char direction;
	private int maskingStopwatch;
	
	/**
	 * Creates a Person with given information, automatically unmasked
	 * @param loc Location at which the Person starts at
	 * @param isInfected whether the Person starts out infected or not
	 * @param direction which direction the Person will start moving in
	 */
	public Person(Location loc, boolean isInfected, char direction) {
		this.loc = loc;
		this.infected = isInfected;
		this.direction = direction;
		masked = false;
		vaccinated = false;
		maskingStopwatch = 0;
	}
	
	/**
	 * Draws the Person in the given Tier with the given PApplet
	 * @param marker PApplet on which the Person is drawn
	 * @param t Tier in which the Person is drawn
	 * @pre this method runs with the conditions previously set on the given PApplet
	 */
	public void draw(PApplet marker, Tier t) {
		if (loc != null) {
			if (infected) {
				marker.image(marker.loadImage("images/infected.png"), t.getX() + 40 * loc.getCol(), t.getY() + 40 * loc.getRow(), 40, 40);
			}
			else if (vaccinated) {
				marker.image(marker.loadImage("images/vaccinated.png"), t.getX() + 40 * loc.getCol(), t.getY() + 40 * loc.getRow(), 40, 40);
			}
			else if (masked) {
				marker.image(marker.loadImage("images/uninfectedMasked.png"), t.getX() + 40 * loc.getCol(), t.getY() + 40 * loc.getRow(), 40, 40);
				maskingStopwatch++;
				if (maskingStopwatch % 150 == 0) {
					masked = false;
				}
			}
			else {
				marker.image(marker.loadImage("images/uninfectedUnmasked.png"), t.getX() + 40 * loc.getCol(), t.getY() + 40 * loc.getRow(), 40, 40);
			}
		}
		
		
	}
	
	/**
	 * Takes in the neighboring people and infects them if Person is infected
	 * @param t Tier in which the Person is inside
	 * @return the number of people the person infected
	 */
	public int processPeople(Tier t) {
		int numberInfected = 0;
		if (loc == null) return 0;
		
		ArrayList<Location> adjacent = loc.getAdjacentLocations(t);
		if (infected) {
			
			for (Location l : adjacent) {
				GameComponent adjacentComponent = t.getComponentAtLoc(l);
				if (adjacentComponent instanceof Person && !(adjacentComponent instanceof Player)
						&& !((Person) adjacentComponent).isMasked()
						&& !((Person) adjacentComponent).isVaccinated()
						&& !((Person) adjacentComponent).isInfected()) {
					((Person) adjacentComponent).contractVirus();
					numberInfected++;
				}
			}
		}
		return numberInfected;
	}

	
	public boolean canMove(Tier t) {
		if (loc == null) return false;
		Location loc;
		if (direction == 'u') loc = new Location(this.getLocation().getRow()-1, this.getLocation().getCol());
		else if (direction == 'd') loc = new Location(this.getLocation().getRow()+1, this.getLocation().getCol());
		else if (direction == 'l') loc = new Location(this.getLocation().getRow(), this.getLocation().getCol()-1);
		else loc = new Location(this.getLocation().getRow(), this.getLocation().getCol()+1);
		
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
	/**
	 * Moves the Person based on its given direction and surroundings
	 */
	public void move() {
		if (direction == 'u') {
			loc.setRow(loc.getRow() - 1);
		}
		else if (direction == 'd') {
			loc.setRow(loc.getRow() + 1);
		}
		else if (direction == 'l') {
			loc.setCol(loc.getCol() - 1);
		}
		else if (direction == 'r'){
			loc.setCol(loc.getCol() + 1);
		}
	}
	

	public void setLocation(Location loc) {
		this.loc = loc;
	}

	/**
	 * 
	 * @return the current Location of the Person
	 */
	public Location getLocation() {

		if(this.loc !=null)
			return loc;
		else
			return null;
	}
	
	/**
	 * 
	 * @return whether the Person is infected or not
	 */
	public boolean isInfected() {
		return infected;
	}
	
	/**
	 * 
	 * @return whether the Person is masked or not
	 */
	public boolean isMasked() {
		return masked;
	}
	
	/**
	 * 
	 * @return whether the Person is vaccinated or not
	 */
	public boolean isVaccinated() {
		return vaccinated;
	}
	
	/**
	 * 
	 * @return the direction the Person is currently supposed to travel in if it can move
	 */
	public char getDirection() {
		return this.direction;
	}
	
	/**
	 * Gives the Person a mask
	 */
	public void takeMask() {
		masked = true;
	}
	
	/**
	 * Gets the Person vaccinated
	 */
	public void getVaccinated() {
		vaccinated = true;
	}
	
	/**
	 * Makes the Person infected
	 */
	public void contractVirus() {
		infected = true;
	}
	
	/**
	 * Has the Person be carried by the Player
	 */
	public void latchToPlayer(Tier t) {
		t.removeFromGrid(this);
		loc = null;
	}
	public void setDirection(char direction) {
		this.direction = direction;
	}
	
	/**
	 * 
	 * @return whether the Person object is null or not
	 */
	public boolean isNull() {
		if(this.equals(null)) return true;
		else return false;
	}
	public void cure(Tier t) {
		t.reduceInfected();
		infected = false;
	}
	
}