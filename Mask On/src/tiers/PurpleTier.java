package tiers;

import java.awt.Color;
import java.util.ArrayList;

import display.Location;
import display.Tier;
import gamecomponents.people.Player;
import gamecomponents.places.Factory;
import gamecomponents.places.Hospital;
import gamecomponents.places.Place;

public class PurpleTier extends Tier {
	
	public PurpleTier(double x, double y, double width, double height, int strokeWeight, Color strokeColor, Color fillColor) {
		super(x, y, width, height, strokeWeight, strokeColor, fillColor);		
		
		this.addPlayer(new Player(new Location(7, 5), false, 'u'));
	
		ArrayList<Location> hosLocs1 = new ArrayList<Location>();
		for (int i = 5; i <= 6; i++) {
			for (int j = 5; j <= 6; j++) {
				hosLocs1.add(new Location(i, j));
			}
		}
		
		this.addPlaceToArrayList(new Hospital(hosLocs1));
		/*
		ArrayList<Location> factorySquares = new ArrayList<Location>();
		for (int i = 13; i <= 14; i++) {
			for (int j = 13; j <= 14; j++) {
				factorySquares.add(new Location(i, j));
			}
		}
		this.addPlaceToArrayList(new Factory(factorySquares));
		
		ArrayList<Location> privateSquares = new ArrayList<Location>();
		for (int i = 0; i < 4; i++) {
			privateSquares.add(new Location(7, i));
		}
		this.addPlaceToArrayList(new Place(privateSquares));
		*/
		randomSpawn(6, 4, 2, 2);
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

}