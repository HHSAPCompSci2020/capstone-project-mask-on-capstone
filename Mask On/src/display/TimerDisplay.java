package display;

import java.awt.Color;

import processing.core.PApplet;
import processing.core.PFont;
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
	 * @pre this method runs with the conditions previously set on the given PApplet
	 */
	public void draw(PApplet marker) {
		
		marker.pushStyle();
		marker.fill(255);
		marker.stroke(0);
		marker.strokeWeight(10);
		marker.rect(getX()+ getWidth()*5/7, getY(), getWidth(), getHeight());
		marker.fill(255);
		String min, secs;
		if ((int)(elapsedTime/60)>=10) {
			min = "" + (int)(elapsedTime/60);
		}
		else {
			min = "0" + (int)(elapsedTime/60);
		}
		if ((int)(elapsedTime % 60)>= 10) {
			secs = "" + (int)(elapsedTime % 60);
		}
		else {
			secs = "0" + (int)(elapsedTime % 60);
		}
		marker.text("TIME:", getX() + getWidth()/10, getY()+ getHeight()*5/7);
		marker.fill(0);
		PFont timerFont = marker.createFont("fonts/digital-7.ttf", getHeight()*5/7);
		marker.textFont(timerFont);
		marker.text(min + " : " + secs, getX()+ getWidth()*6/7, getY()+ getHeight()*5/7);
		marker.popStyle();
	}
}