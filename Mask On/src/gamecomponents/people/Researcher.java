package gamecomponents.people;

import display.Location;
import display.Tier;
import processing.core.PApplet;

public class Researcher extends Person {

	public Researcher(Location loc, char direction) {
		super(loc, false, direction);
//		takeMask();
		getVaccinated();
		// TODO Auto-generated constructor stub
	}
	
	public void draw(PApplet marker, Tier t) {
		if (getLocation() != null) {
			marker.image(marker.loadImage("images/researcher.png"), t.getX() + 40 * getLocation().getCol(), t.getY() + 40 * getLocation().getRow(), 40, 40);
		}
	}
	
}