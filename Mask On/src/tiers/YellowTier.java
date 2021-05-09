package tiers;

import java.awt.Color;
import java.util.ArrayList;
import display.*;
import gamecomponents.people.*;
import gamecomponents.places.*;

public class YellowTier extends Tier {
	
	public YellowTier(double x, double y, double width, double height, int strokeWeight, Color strokeColor, Color fillColor) {
		super(x, y, width, height, strokeWeight, strokeColor, fillColor);
		// TODO Auto-generated constructor stub
		
		this.addPersonToArrayList(new Person(new Location(5,3), false, 'u'));
		this.addPersonToArrayList(new Person(new Location(1,3), true, 'l'));
		this.addPlayer(new Player(new Location(5, 5), false, 'r'));
		
		ArrayList<Location> hospitalSquares = new ArrayList<Location>();
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 1; j++) {
				hospitalSquares.add(new Location(i, j));
			}
		}
		this.addPlaceToArrayList(new Hospital(hospitalSquares));
		
		ArrayList<Location> factorySquares = new ArrayList<Location>();
		for (int i = 13; i <= 14; i++) {
			for (int j = 13; j <= 14; j++) {
				factorySquares.add(new Location(i, j));
			}
		}
		this.addPlaceToArrayList(new Factory(factorySquares));
	}

}