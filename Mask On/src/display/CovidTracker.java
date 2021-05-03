package display;

import java.awt.Color;

import processing.core.PApplet;

public class CovidTracker extends Display{
	private int covidCount;
	private int total;
	public CovidTracker(double x, double y, double width, double height) {
		super(x, y, width, height);
		covidCount = 0;
		this.total = 0;
	}
	public void draw(PApplet marker) {
		marker.noStroke();
		marker.rect(getX(), getY(), getWidth(), getHeight());
		marker.fill(255,0,0);
		marker.rect(getX(), getY(), getWidth()*covidCount/total, getHeight());
		marker.fill(255);
		marker.text("Covid Count: " + covidCount + "/" + total, getX(), getY()-10);
		marker.stroke(0);
	}
	public void getTier(Tier t) {
		total = t.getTotal();
		covidCount = t.getInfected();
	}
}