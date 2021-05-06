package gamecomponents.people;

import java.util.ArrayList;
import display.GameComponent;
import display.Location;
import display.Tier;
import processing.core.PApplet;

public class Person extends GameComponent {
	
	private Location loc;
	private boolean infected;
	private boolean masked;
	private boolean vaccinated;
	private char direction;
	
	public Person(Location loc, boolean isInfected, char direction) {
		this.loc = loc;
		this.infected = isInfected;
		this.direction = direction;
		masked = false;
		vaccinated = false;
	}
	
	public void draw(PApplet marker, Tier t) {
		if (loc != null) {
			if (infected) {
				marker.image(marker.loadImage("images/infected.png"), t.getX() + 40 * loc.getCol(), t.getY() + 40 * loc.getRow(), 40, 40);
			}
			else if (masked) {
				marker.image(marker.loadImage("images/uninfectedMasked.png"), t.getX() + 40 * loc.getCol(), t.getY() + 40 * loc.getRow(), 40, 40);
			}
			else {
				marker.image(marker.loadImage("images/uninfectedUnmasked.png"), t.getX() + 40 * loc.getCol(), t.getY() + 40 * loc.getRow(), 40, 40);
			}
		}
	}
	
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
		
		if (direction == 'u') {
			if (t.getComponentAtLoc(loc.getTop()) != null) {
				if (t.getComponentAtLoc(loc.getBottom()) != null) {
					return false;
				}
				direction = 'd';
				return true;
			}
			return true;
		}
		else if (direction == 'd') {
			if (t.getComponentAtLoc(loc.getBottom()) != null) {
				if (t.getComponentAtLoc(loc.getTop()) != null) {
					return false;
				}
				direction = 'u';
				return true;
			}
			return true;
		}
		else if (direction == 'l') {
			if (t.getComponentAtLoc(loc.getLeft()) != null) {
				if (t.getComponentAtLoc(loc.getRight()) != null) {
					return false;
				}
				direction = 'r';
				return true;
			}
			return true;
		}
		else {
			if (t.getComponentAtLoc(loc.getRight()) != null) {
				if (t.getComponentAtLoc(loc.getLeft()) != null) {
					return false;
				}
				direction = 'l';
				return true;
			}
			return true;
		}
		
	}
	
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
		else {
			loc.setCol(loc.getCol() + 1);
		}
	}
	
	public Location getLocation() {
		return loc;
	}
	
	public boolean isInfected() {
		return infected;
	}
	
	public boolean isMasked() {
		return masked;
	}
	
	public boolean isVaccinated() {
		return vaccinated;
	}
	public char getDirection() {
		return this.direction;
	}
	
	public void takeMask() {
		masked = true;
	}
	
	public void getVaccinated() {
		vaccinated = true;
	}
	
	public void contractVirus() {
		infected = true;
	}
	
	public void latchToPlayer() {
		loc = null;
	}
	
//	public int getStopwatch() {
//		return stopwatch;
//	}
//	
//	public void setStopwatch(int i) {
//		stopwatch = i;
//	}
	public boolean isNull() {
		if(this.equals(null)) return true;
		else return false;
	}
	
}