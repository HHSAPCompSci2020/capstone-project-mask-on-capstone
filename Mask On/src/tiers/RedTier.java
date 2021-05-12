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
 * The RedTier class represents a Tier which is level 3. It has VaccineClinics. 
 * @author Felicia Zhang
 *
 */
public class RedTier extends Tier {
	
	/**
	 * Sets up a RedTier with the given values, predecided Places, and randomly-created people
	 * @param x the top left corner x value
	 * @param y the top left corner y value
	 * @param width tier width
	 * @param height tier height
	 * @param strokeWeight strokeweight of lines
	 * @param strokeColor strokecolor of lines
	 * @param fillColor fill color of shapes
	 * @param playerMode mode/accessories of the Player
	 */
	public RedTier(double x, double y, double width, double height, int strokeWeight, Color strokeColor, Color fillColor, char playerMode) {
		super(x, y, width, height, strokeWeight, strokeColor, fillColor);
		//public places
		ArrayList<Location> publicPlaceSquares1 = new ArrayList<Location>();
		for (int i = 2; i <= 3; i++) {
			for (int j = 12; j <= 13; j++) {
				publicPlaceSquares1.add(new Location(i, j));
			}
		}
		this.addPlaceToArrayList(new PublicPlace(publicPlaceSquares1));
		
		ArrayList<Location> publicPlaceSquares2 = new ArrayList<Location>();
		for (int i = 10; i <= 11; i++) {
			for (int j = 3; j <= 4; j++) {
				publicPlaceSquares2.add(new Location(i, j));
			}
		}
		this.addPlaceToArrayList(new PublicPlace(publicPlaceSquares2));
		
		//factory
		ArrayList<Location> factorySquares = new ArrayList<Location>();
		for (int i = 13; i <= 14; i++) {
			for (int j = 13; j <= 14; j++) {
				factorySquares.add(new Location(i, j));
			}
		}
		this.addPlaceToArrayList(new Factory(factorySquares));
		
		//Vaccine clinic
		ArrayList<Location> vaccineClinicSquares = new ArrayList<Location>();
		for (int i = 6; i <= 7; i++) {
			for (int j = 6; j <= 7; j++) {
				vaccineClinicSquares.add(new Location(i, j));
			}
		}
		this.addPlaceToArrayList(new VaccineClinic(vaccineClinicSquares));
		
		//private places
		ArrayList<Location> privateSquares = new ArrayList<Location>();
		for (int i = 0; i < 4; i++) {
			privateSquares.add(new Location(3, i));
			privateSquares.add(new Location(4, 13-i));
		}
		this.addPlaceToArrayList(new Place(privateSquares));
		
		//player
		this.addPlayer(new Player(new Location(1,1), false, 'r', playerMode));
		
		//people
		randomSpawn(5, 5, 2, 0);
	}
}