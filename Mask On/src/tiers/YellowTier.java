package tiers;

import java.awt.Color;
import java.util.ArrayList;
import display.*;
import gamecomponents.people.*;
import gamecomponents.places.*;

/**
 * Represents the first level Tier, or the Yellow Tier. It doesn't have anything special.
 * @author roshnibright
 *
 */
public class YellowTier extends Tier {
	
	/**
	 * Sets up a YellowTier with the given values, predecided Places, and randomly-created people
	 * @param x the top left corner x value
	 * @param y the top left corner y value
	 * @param width tier width
	 * @param height tier height
	 * @param strokeWeight strokeweight of lines
	 * @param strokeColor strokecolor of lines
	 * @param fillColor fill color of shapes
	 * @param playerMode mode/accessories of the Player
	 */
	public YellowTier(double x, double y, double width, double height, int strokeWeight, Color strokeColor, Color fillColor, char playerMode) {
		super(x, y, width, height, strokeWeight, strokeColor, fillColor);		
		
		this.addPlayer(new Player(new Location(5, 5), false, 'r', playerMode));
	
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
		
		ArrayList<Location> privateSquares = new ArrayList<Location>();
		for (int i = 0; i < 4; i++) {
			privateSquares.add(new Location(7, i));
		}
		this.addPlaceToArrayList(new Place(privateSquares));
		
		randomSpawn(8, 2, 0, 0);
	}

}