package gamecomponents.places;

import java.util.ArrayList;

import display.Location;
import display.Tier;
import processing.core.PApplet;
/**
 * The Factory class represents a Place that makes masks. It makes 5 masks in 30 seconds and is open when it is done making the masks.
 * @author Felicia Zhang
 *
 */
public class Factory extends Place {
	private double startProduction;
	private boolean isOpen;
	/**
	 * 
	 * @param locs the ArrayList of Location objects the Factory occupies
	 */
	public Factory(ArrayList<Location> locs) {
		super(locs);
		startProduction = System.currentTimeMillis();
		isOpen = true;
	}
	/**
	 * Draws the Factory in the given Tier, the Factory has a countdown from 30 seconds when it is making masks, and when it is done making masks, it is open
	 * @param marker the PApplet surface on which the Factory is being drawn
	 * @param t the Tier in which the Factory is inside
	 * @pre this method runs with the conditions previously set on the given PApplet
	 */
	public void draw(PApplet marker, Tier t) {
		double elapsedTime = (System.currentTimeMillis() - startProduction)/1000;
		marker.pushStyle();
		for (Location l : getLocations()) {
			marker.stroke(120);
			marker.square(t.getX() + 40 * l.getCol(), t.getY() + 40 * l.getRow(), 40);
		}
		marker.fill(255);
		marker.textSize(11);
		int x = getLocations().get(0).getCol();
		int y = getLocations().get(0).getRow();
		marker.image(marker.loadImage("images/factory.png"), t.getX()+ 40*x,  t.getY() + 40*y, t.getWidth()*2/15, t.getHeight()*2/15);
		if (elapsedTime >= 20 || isOpen) {
			marker.text("OPEN", t.getX()+ 40*(x+1), t.getY() + 40*(y+1));
			isOpen = true;
		}
		else {
			marker.text("" + (20 - (int)elapsedTime) + "s left", t.getX()+ 40*(x+0.8f), t.getY() + 40*(y+1));
		}
		marker.popStyle();
	}
	/**
	 * The player retrieves 5 masks if the Factory is open. If it is closed, 0 masks are retrieved. 
	 * @return the number of masks retrieved
	 */
	public int retrieveMasks() {
		if (isOpen) {
			startProduction = (double)(System.currentTimeMillis());
			isOpen = false;
			return 5;
		}
		return 0;
	}
	/**
	 * 
	 * @return the current status of the Factory
	 */
	public boolean getStatus() {
		return isOpen;
	}
}
