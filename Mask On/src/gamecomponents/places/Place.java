package gamecomponents.places;

import display.GameComponent;
import java.util.ArrayList;
import display.Location;
import display.Tier;
import processing.core.PApplet;
import processing.core.PImage;

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
	 * Draws the Place in the given Tier
	 * @param marker the PApplet surface on which the Place is being drawn
	 * @param t the Tier in which the Place is inside
	 * @pre this method runs with the conditions previously set on the given PApplet
	 */
	public void draw(PApplet marker, Tier t) {
		marker.pushStyle();
		marker.fill(120);
		PImage house = marker.loadImage("images/place.png");
		house.resize(40, 0);
		for (Location l : locs) {
	//		marker.square(t.getX() + 40 * l.getCol(), t.getY() + 40 * l.getRow(), 40);
			
			marker.image(house, t.getX() + 40 * l.getCol(),t.getY() + 40 * l.getRow());
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
