package tiers;

import java.awt.Color;
import java.util.ArrayList;

import display.Location;
import display.Tier;
import gamecomponents.people.Player;
import gamecomponents.places.Factory;
import gamecomponents.places.Place;
import gamecomponents.places.PublicPlace;
import gamecomponents.places.VaccineClinic;

/**
 * Represents the fourth level Tier, or the Purple Tier. It has VaccineClinics that need to
 * be reopened with the help of Researchers.
 * @author Emily Tumacder
 *
 */
public class PurpleTier extends Tier {
	
	/**
	 * Sets up a PurpleTier with the given values, predecided Places, and randomly-created people
	 * @param x the top left corner x value
	 * @param y the top left corner y value
	 * @param width tier width
	 * @param height tier height
	 * @param strokeWeight strokeweight of lines
	 * @param strokeColor strokecolor of lines
	 * @param fillColor fill color of shapes
	 * @param playerMode mode/accessories of the Player
	 */
	public PurpleTier(double x, double y, double width, double height, int strokeWeight, Color strokeColor, Color fillColor, char playerMode) {
		super(x, y, width, height, strokeWeight, strokeColor, fillColor);		
		
		this.addPlayer(new Player(new Location(7, 5), false, 'u', playerMode));
	
		ArrayList<Location> ppLocs1 = new ArrayList<Location>();
		for (int i = 5; i <= 6; i++) {
			for (int j = 5; j <= 6; j++) {
				ppLocs1.add(new Location(i, j));
			}
		}
		this.addPlaceToArrayList(new PublicPlace(ppLocs1));
	
		ArrayList<Location> ppLocs2 = new ArrayList<Location>();
		for (int i = 11; i <= 12; i++) {
			for (int j = 11; j <= 12; j++) {
				ppLocs2.add(new Location(i, j));
			}
		}
		this.addPlaceToArrayList(new PublicPlace(ppLocs2));
		
		ArrayList<Location> factory1 = new ArrayList<Location>();
		for (int i = 2; i <= 3; i++) {
			for (int j = 12; j <= 13; j++) {
				factory1.add(new Location(i, j));
			}
		}
		this.addPlaceToArrayList(new Factory(factory1));
		
		ArrayList<Location> factorySquares = new ArrayList<Location>();
		for (int i = 13; i <= 14; i++) {
			for (int j = 13; j <= 14; j++) {
				factorySquares.add(new Location(i, j));
			}
		}
		this.addPlaceToArrayList(new Factory(factorySquares));
		
		ArrayList<Location> vaccine1 = new ArrayList<Location>();
		for (int i = 12; i <= 13; i++) {
			for (int j = 1; j <= 2; j++) {
				vaccine1.add(new Location(i, j));
			}
		}
		this.addPlaceToArrayList(new VaccineClinic(vaccine1));
		
		ArrayList<Location> vaccine2 = new ArrayList<Location>();
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 2; j++) {
				vaccine2.add(new Location(i, j));
			}
		}
		this.addPlaceToArrayList(new VaccineClinic(vaccine2));
		
		ArrayList<Location> privateSquares = new ArrayList<Location>();
		for (int i = 4; i < 7; i++) {
			privateSquares.add(new Location(i, 3));
		}
		for (int i = 10; i < 15; i++) {
			privateSquares.add(new Location(9, i));
		}
		this.addPlaceToArrayList(new Place(privateSquares));
		
		
		randomSpawn(4, 5, 2, 2);
	}

}