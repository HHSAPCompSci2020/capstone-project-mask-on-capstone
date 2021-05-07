package gamecomponents.places;

import display.GameComponent;
import java.util.ArrayList;
import display.Location;
import display.Tier;
import processing.core.PApplet;

/**
 * This class represents a Place on the grid displayed in a Tier
 * @author roshnibright
 *
 */
public class Place extends GameComponent {
	private ArrayList<Location> locs = new ArrayList<Location>();
	
	/**
	 * 
	 * @param locs the ArrayList of Location objects the Place occupies
	 */
	public Place(ArrayList<Location> locs) {
		this.locs = locs;
	}
	
	/**
	 * 
	 * @param marker the PApplet surface on which the Place is being drawn
	 * @param t the Tier in which the Place is inside
	 */
	public void draw(PApplet marker, Tier t) {
		marker.pushStyle();
		marker.fill(120);
		for (Location l : locs) {
			marker.square(t.getX() + 40 * l.getCol(), t.getY() + 40 * l.getRow(), 40);
		}
		marker.popStyle();
	}
	
	/**
	 * 
	 * @return the ArrayList of Location objects that the Place occupies
	 */
	public ArrayList<Location> getLocations() {
		return locs;
	}
	
}
