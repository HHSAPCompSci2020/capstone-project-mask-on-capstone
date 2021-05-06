package display;

import java.awt.Color;

import processing.core.PApplet;
/**
 * The TimerDisplay class is a Display that represents a stopwatch used to keep track of how much time the user spends on a Tier
 * @author Felicia Zhang
 */
public class TimerDisplay extends Display{
	private long startTime;
	private long elapsedTime;
	/**
	 * Creates a new TimerDisplay
	 * @param x x-coordinate of the start point
	 * @param y y-coordinate of the start point
	 * @param width width of the TimerDisplay
	 * @param height height of the TimerDisplay
	 */
	public TimerDisplay(double x, double y, double width, double height) {
		super (x, y, width, height);
		startTime = System.currentTimeMillis();
	}
	/**
	 * Calculates the elaspedTime using the current and start times
	 */
	public void updateTime() {
		elapsedTime = (System.currentTimeMillis() - startTime)/1000;
	}
	/**
	 * Draws the TimerDisplay
	 * @param marker the PApplet on which the TimerDisplay is drawn
	 */
	public void draw(PApplet marker) {
		marker.fill(255);
		marker.stroke(0);
		marker.strokeWeight(10);
		marker.rect(getX()+ getWidth()*3/5, getY(), getWidth(), getHeight());
		marker.fill(255);
		int min = (int)(elapsedTime/60);
		int secs = (int)(elapsedTime % 60);
		marker.text("TIME:", getX() + getWidth()/10, getY()+ getHeight()*3/5);
		marker.fill(0);
		marker.text(min + "m " + secs + "s", getX()+ getWidth()*4/5, getY()+ getHeight()*3/5);
		marker.strokeWeight(1);
		marker.fill(255);
	}
}