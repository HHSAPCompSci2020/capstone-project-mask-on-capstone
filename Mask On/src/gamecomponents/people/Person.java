package gamecomponents.people;

import java.util.ArrayList;
import display.GameComponent;
import display.Location;
import display.Tier;
import processing.core.PApplet;
import processing.core.PImage;

public class Person extends GameComponent {
	
	private Location loc;
	private PImage image;
	private boolean isInfected;
	private boolean masked;
	private char direction;
	
	public Person(PImage image, Location loc, boolean isInfected, char direction) {
		this.image = image;
		this.loc = loc;
		this.isInfected = isInfected;
		this.direction = direction;
		masked = false;
	}
	
	public void draw(PApplet marker) {
		if (loc != null) {
			marker.image(image, loc.getCol(), loc.getRow(), 40, 40);
		}
	}
	
	public void processPeople(Tier t) {
		ArrayList<Location> adjacent = loc.getAdjacentLocations();
		if (isInfected) {
			for (Location l : adjacent) {
				GameComponent adjacentComponent = t.getGrid()[l.getRow()][l.getCol()];
				if (adjacentComponent instanceof Person && !((Person) adjacentComponent).isMasked()) {
					((Person) adjacentComponent).contractVirus();
				}
			}
		}
	}
	
	public boolean canMove(Tier t) {
		return false;
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