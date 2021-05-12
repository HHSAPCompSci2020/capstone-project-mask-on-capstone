package gamecomponents.places;

import java.util.ArrayList;
import display.Location;
import display.Tier;
import processing.core.PApplet;

/**
 * A type of Place, a public place can be converted into hospital in certain conditions
 * @author EmilyTumacder
 *
 */
public class PublicPlace extends Place {

	/**
	 * 
	 * @param locs an ArrayList of Locations that the PublicPlace occupies on the grid
	 */
	public PublicPlace(ArrayList<Location> locs) {
		super(locs);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Converts this PublicPlace into a hospital
	 * @param t the Tier in which the PublicPlace is
	 */
	public void convertIntoHospital(Tier t) {
		t.removeFromGrid(this);
		Hospital h=  new Hospital(this.getLocations());
		t.addPlaceToArrayList(h);
		t.addPlaceToGrid(h);
	}
	
	/**
	 * Draws the PublicPlace with the given PApplet in the given Tier
	 * @param marker the PApplet on which it is drawn
	 * @param t the Tier in which it is drawn
	 */
	public void draw(PApplet marker, Tier t) {
		int x = getLocations().get(0).getCol();
		int y = getLocations().get(0).getRow();
		marker.image(marker.loadImage("images/publicBuilding.png"), t.getX()+ 40*x,  t.getY() + 40*y, t.getWidth()*2/15, t.getHeight()*2/15);
	}
	
}
