package display;

import processing.core.PApplet;
/**
 * Represents a tracker that keeps track of the number of Covid cases in each Tier
 * @author goldb
 *
 */
public class CovidTracker extends Display{
	private int covidCount;
	private int total;
	/**
	 * 
	 * @param x the x-coordinate of the upper left corner of the CovidTracker
	 * @param y the y-coordinate of the upper left corner of the CovidTracker
	 * @param width the width of the CovidTracker
	 * @param height the height of the CovidTracker
	 */
	public CovidTracker(double x, double y, double width, double height) {
		super(x, y, width, height);
		covidCount = 0;
		this.total = 0;
	}
	/**
	 * Draws the tracker, which is a horizontal bar in which the ratio of the red to the whole bar is proportional to the Covid count out of the total population
	 * @param marker the PApplet on which the CovidTracker is drawn
	 * @pre this method runs with the conditions previously set on the given PApplet
	 */
	public void draw(PApplet marker) {
		marker.noStroke();
		marker.rect(getX(), getY(), getWidth(), getHeight());
		marker.fill(255,0,0);
		marker.rect(getX(), getY(), getWidth()*covidCount/total, getHeight());
		marker.fill(255);
		marker.text("Covid Count: " + covidCount + "/" + total, getX(), getY()-10);
		marker.stroke(0);
	}
	/**
	 * Updates the Covid count and total number of people based on the Tier
	 * @param t the current Tier
	 */
	public void update(Tier t) {
		total = t.getPeople();
		covidCount = t.getInfected();
	}
}