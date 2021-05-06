package gamecomponents.places;

import display.GameComponent;
import java.util.ArrayList;
import display.Location;
import display.Tier;
import processing.core.PApplet;

public class Place extends GameComponent {
	private ArrayList<Location> locs = new ArrayList<Location>();
	
	public Place(ArrayList<Location> locs) {
		this.locs = locs;
	}
	
	public void draw(PApplet marker, Tier t) {
		marker.pushStyle();
		marker.fill(120);
		for (Location l : locs) {
			marker.square(t.getX() + 40 * l.getCol(), t.getY() + 40 * l.getRow(), 40);
		}
		marker.popStyle();
	}
	
	public ArrayList<Location> getLocations() {
		return locs;
	}
	
}
