package display;

import processing.core.PApplet;
import tiers.*;

/**
 * The TaskBar class represents a Display that gives the user recommended tasks to complete in each Tier.
 * @author Felicia Zhang
 *
 */
public class TaskBar extends Display{
	
	private Tier t;
	
	/**
	 * 
	 * @param x the x-coordinate of the upper left corner of the TaskBar
	 * @param y the y-coordinate of the upper left corner of the TaskBar
	 * @param width the width of the TaskBar
	 * @param height the height of the TaskBar
	 */
	public TaskBar (double x, double y, double width, double height) {
		super(x, y, width, height);
		t = null;
	}
	
	/**
	 * Draws the TaskBar
	 * @param marker the PApplet on which the TaskBar is drawn
	 * @pre this method runs with the conditions previously set on the given PApplet
	 */
	public void draw(PApplet marker) {
		marker.pushStyle();
		marker.noStroke();
		marker.rect(getX(), getY(), getWidth(), getHeight());
		marker.fill(223, 240, 255);
		marker.rect(getX(), getY(), getWidth(), getHeight()/5);
		marker.rect(getX(), getY(), getWidth()/6, getHeight());
		marker.fill(0); 
		marker.textSize(15);
		marker.text("TASK BAR: ", getX() + getWidth()/4, getY() + getHeight()/6);
		marker.stroke(150);
		marker.line(getX() + getWidth()/6, getY(), getX() + getWidth()/6, getY() + getHeight());
		marker.line(getX(), getY() + getHeight()*2/5, getX() + getWidth(), getY() + getHeight()*2/5);
		marker.line(getX(), getY() + getHeight()*3/5, getX() + getWidth(), getY() + getHeight()*3/5);
		marker.line(getX(), getY() + getHeight()*4/5, getX() + getWidth(), getY() + getHeight()*4/5);
		marker.line(getX(), getY() + getHeight()/5, getX() + getWidth(), getY() + getHeight()/5);
		marker.textSize(12);
		if (t instanceof YellowTier) {
			marker.text("1.     Mask people", getX() + getWidth()/11, getY() + getHeight()*5/14);
		}
		else if (t instanceof OrangeTier) {
			marker.text("1.     Build a Hospital", getX() + getWidth()/11, getY() + getHeight()*5/14);
			marker.text("2.     Mask people", getX() + getWidth()/11, getY() + getHeight()*5/9);
		}
		else if (t instanceof RedTier) {
			marker.text("1.     Build a Hospital", getX() + getWidth()/11, getY() + getHeight()*5/14);
			marker.text("2.     Vaccinate people", getX() + getWidth()/11, getY() + getHeight()*5/9);
			marker.text("3.     Mask people", getX() + getWidth()/11, getY() + getHeight()*3/4);
		}
		else if (t instanceof PurpleTier) {
			marker.text("1.     Build a Hospital", getX() + getWidth()/11, getY() + getHeight()*5/14);
			marker.text("2.     Open the Vaccine clinic", getX() + getWidth()/11, getY() + getHeight()*5/9);
			marker.text("3.     Vaccinate people", getX() + getWidth()/11, getY() + getHeight()*3/4);
			marker.text("4.     Mask people", getX() + getWidth()/11, getY() + getHeight()*15/16);
		}
		marker.popStyle();
	}
	
	/**
	 * Updates the Tier of the TaskBar
	 * @param t the current Tier
	 */
	public void update(Tier t) {
		this.t = t;
	}
}
