package gamecomponents.places;

import java.util.ArrayList;
import display.Location;
import display.Tier;
import processing.core.PApplet;

/**
 * 
 * @author EmilyTumacder
 *
 */
public class PublicPlace extends Place {

	public PublicPlace(ArrayList<Location> locs) {
		super(locs);
		// TODO Auto-generated constructor stub
	}
	
	public Hospital convertIntoHospital() {
		//need to remove it from the board in the future
		return new Hospital(this.getLocations());
	}
	
	public VaccineClinic convertIntoVaccineClinic() {
		//need to remove it from the board in the future
		return new VaccineClinic(this.getLocations());
	}
	
	public void draw(PApplet marker, Tier t) {
		int x = getLocations().get(0).getCol();
		int y = getLocations().get(0).getRow();
		marker.image(marker.loadImage("images/publicBuilding.png"), t.getX()+ 40*x,  t.getY() + 40*y, t.getWidth()*2/15, t.getHeight()*2/15);
	}
	
}
