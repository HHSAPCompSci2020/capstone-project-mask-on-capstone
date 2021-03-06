package tiers;

import java.awt.Color;
import java.util.ArrayList;
import display.*;
import gamecomponents.people.*;
import gamecomponents.places.*;

/**
 * Represents the second level Tier, or the Orange Tier. It has PublicPlaces that can be converted
 * to Hospitals with Doctors.
 * @author roshnibright
 *
 */
public class OrangeTier extends Tier {
	
	/**
	 * Sets up an OrangeTier with the given values, predecided Places, and randomly-created people
	 * @param x the top left corner x value
	 * @param y the top left corner y value
	 * @param width tier width
	 * @param height tier height
	 * @param strokeWeight strokeweight of lines
	 * @param strokeColor strokecolor of lines
	 * @param fillColor fill color of shapes
	 * @param playerMode mode/accessories of the Player
	 */
	public OrangeTier(double x, double y, double width, double height, int strokeWeight, Color strokeColor, Color fillColor, char playerMode) {
		super(x, y, width, height, strokeWeight, strokeColor, fillColor);
		
		//public places
		ArrayList<Location> publicPlaceSquares1 = new ArrayList<Location>();
		for (int i = 0; i <= 1; i++) {
			for (int j = 9; j <= 10; j++) {
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
		
		//private places
		ArrayList<Location> privateSquares = new ArrayList<Location>();
		for (int i = 0; i < 4; i++) {
			privateSquares.add(new Location(4, i));
		}
		this.addPlaceToArrayList(new Place(privateSquares));
		
		//player
		this.addPlayer(new Player(new Location(7, 8), false, 'r', playerMode));
		
		//people
		randomSpawn(7, 3, 1, 0);
	}
}