package gamecomponents.people;

import display.Location;
import display.Tier;
import processing.core.PApplet;

public class Doctor extends Person {

	public Doctor(Location loc, char direction) {
		super(loc, false, direction);
		takeMask();
		getVaccinated();
		// TODO Auto-generated constructor stub
	}
	
	public void draw(PApplet marker, Tier t) {
		if (getLocation() != null) {
			marker.image(marker.loadImage("images/doctor.png"), t.getX() + 40 * getLocation().getCol(), t.getY() + 40 * getLocation().getRow(), 40, 40);
		}
	}
	
}