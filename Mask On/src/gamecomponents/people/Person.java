package gamecomponents.people;

import java.util.ArrayList;
import display.GameComponent;
import display.Location;
import display.Tier;
import processing.core.PApplet;

public class Person extends GameComponent {
	
	private Location loc;
	private boolean isInfected;
	private boolean masked;
	private char direction;
	private int stopwatch;
	
	public Person(Location loc, boolean isInfected, char direction) {
		this.loc = loc;
		this.isInfected = isInfected;
		this.direction = direction;
		stopwatch = 0;
		masked = false;
	}
	
	public void draw(PApplet marker, Tier t) {
		if (loc != null) {
			if (isInfected) {
				marker.image(marker.loadImage("images/infected.png"), loc.getCol(), loc.getRow(), 40, 40);
			}
			else if (masked) {
				marker.image(marker.loadImage("images/uninfectedMasked.png"), loc.getCol(), loc.getRow(), 40, 40);
			}
			else {
				marker.image(marker.loadImage("images/uninfectedUnmasked.png"), loc.getCol(), loc.getRow(), 40, 40);
			}
		}
		stopwatch++;
		if (stopwatch % 90 == 0 && canMove(t)) {
			processPeople(t);
			move();
		}
	}
	
	public void processPeople(Tier t) {
		if (loc == null) return;
		
		ArrayList<Location> adjacent = loc.getAdjacentLocations();
		if (isInfected) {
			for (Location l : adjacent) {
				GameComponent adjacentComponent = t.getComponentAtLoc(l);
				if (adjacentComponent instanceof Person && !((Person) adjacentComponent).isMasked()) {
					((Person) adjacentComponent).contractVirus();
				}
			}
		}
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
	
	public boolean isMasked() {
		return masked;
	}
	
	public void takeMask() {
		masked = true;
	}
	
	public void contractVirus() {
		isInfected = true;
	}
	
	public void latchToPlayer() {
		loc = null;
	}
	
}