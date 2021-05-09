package tiers;

import java.awt.Color;
import java.util.ArrayList;
import display.Location;
import gamecomponents.places.*;

public class OrangeTier extends YellowTier {
	
	public OrangeTier(double x, double y, double width, double height, int strokeWeight, Color strokeColor, Color fillColor) {
		super(x, y, width, height, strokeWeight, strokeColor, fillColor);
		// TODO Auto-generated constructor stub
		
		//public places
		ArrayList<Location> p1 = new ArrayList<Location>();
		p1.add(new Location(0, 8));
		p1.add(new Location(0, 9));
		p1.add(new Location(0, 10));
		p1.add(new Location(1, 8));
		p1.add(new Location(1, 9));
		p1.add(new Location(1, 10));
		this.addPlaceToArrayList(new Place(p1));
	}
}