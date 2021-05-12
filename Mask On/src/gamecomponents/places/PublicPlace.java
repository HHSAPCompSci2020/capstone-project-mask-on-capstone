package gamecomponents.places;

import java.util.ArrayList;
import display.Location;
import display.Tier;
import processing.core.PApplet;

/**
 * A type of place, A public place can be converted into hospital in certain conditions
 * @author EmilyTumacder
 *
 */
public class PublicPlace extends Place {

	public PublicPlace(ArrayList<Location> locs) {
		super(locs);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Convert this place into a hospital
	 * @param t
	 */
	public void convertIntoHospital(Tier t) {
		t.removeFromGrid(this);
		Hospital h=  new Hospital(this.getLocations());
		t.addPlaceToArrayList(h);
		t.addPlaceToGrid(h);
	}
	
	public void draw(PApplet marker, Tier t) {
		int x = getLocations().get(0).getCol();
		int y = getLocations().get(0).getRow();
		marker.image(marker.loadImage("images/publicBuilding.png"), t.getX()+ 40*x,  t.getY() + 40*y, t.getWidth()*2/15, t.getHeight()*2/15);
	}
	
}
