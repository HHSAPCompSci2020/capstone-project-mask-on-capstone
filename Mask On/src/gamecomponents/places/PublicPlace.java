package gamecomponents.places;

import java.util.ArrayList;

import display.Location;

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
	
}
