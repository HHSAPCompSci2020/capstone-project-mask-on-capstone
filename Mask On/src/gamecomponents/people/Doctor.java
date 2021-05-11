package gamecomponents.people;

import display.Location;
import display.Tier;
import processing.core.PApplet;
/**
 * The Doctor class represents a Person that can not be infected.
 * @author Felicia Zhang
 *
 */
public class Doctor extends Person {

	public Doctor(Location loc, char direction) {
		super(loc, false, direction);
//		takeMask();
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
	
}