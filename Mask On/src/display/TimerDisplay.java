package display;

import java.awt.Color;

import processing.core.PApplet;
/**
 * Represents how much time the user has spent on a Tier
 * @author Felicia Zhang
 */
public class TimerDisplay extends Display{
	private long startTime;
	private long elapsedTime;
	public TimerDisplay(double x, double y, double width, double height, int strokeWeight, Color strokeColor, Color fillColor) {
		super (x, y, width, height);
		startTime = System.currentTimeMillis();
	}
	public void updateTime() {
		elapsedTime = (System.currentTimeMillis() - startTime)/1000;
	}
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