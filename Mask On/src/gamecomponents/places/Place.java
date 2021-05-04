package gamecomponents.places;

import display.GameComponent;
import java.util.ArrayList;
import display.Location;
import processing.core.PApplet;

public class Place extends GameComponent {
	private ArrayList<Location> locs = new ArrayList<Location>();
	
	public void draw(PApplet marker) {
		marker.pushStyle();
		marker.fill(120);
		for (Location l : locs) {
			marker.square(l.getCol(), l.getRow(), 40);
		}
		marker.popStyle();
	}
	
}
