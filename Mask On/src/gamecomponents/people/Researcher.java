package gamecomponents.people;

import java.util.ArrayList;
import display.Location;
import display.Tier;
import processing.core.PApplet;

/**
 * A Researcher is an invincible person, who can open up vaccine clinics
 * @author EmilyTumacder
 *
 */
public class Researcher extends Person {
	
	private ArrayList<Location> movable;

	/**
	 * 
	 * @param loc the Location of the Researcher
	 * @param direction the direction the Researcher initially moves in
	 */
	public Researcher(Location loc, char direction) {
		super(loc, false, direction);
		takeMask();
		getVaccinated();
		movable = new ArrayList<Location>();
	}
	
	/**
	 * Draws the Researcher on the given PApplet in the given Tier
	 */
	public void draw(PApplet marker, Tier t) {
		if (getLocation() != null) {
			marker.image(marker.loadImage("images/researcher.png"), t.getX() + 40 * getLocation().getCol(), t.getY() + 40 * getLocation().getRow(), 40, 40);
		}
	}
	
	public boolean canMove(Tier t) {
		if (getLocation() == null) return false;
		ArrayList<Location> adjacent = getLocation().getAdjacentLocations(t);
		if (movable.size() > 0) {
			movable.clear();
		}
		for (Location l : adjacent) {
			if (t.getComponentAtLoc(l) == null) {
				movable.add(l);
			}
		}
		for (Location l : adjacent) {
			if (t.getComponentAtLoc(l) == null) {
				return true;
			}
		}
		return false;
	}
	
	public void move() {
		if (movable.size() > 0 && getLocation() != null) {
			int random = (int) (Math.random() * movable.size());
			getLocation().setRow(movable.get(random).getRow());
			getLocation().setCol(movable.get(random).getCol());
		}
	}
	
	
}