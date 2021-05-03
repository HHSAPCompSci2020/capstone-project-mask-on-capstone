package display;

import java.awt.Color;
import processing.core.PApplet;

public abstract class Tier extends Display {
	private int infectedPeople;
	private int totalPeople;
	public Tier(double x, double y, double width, double height, int strokeWeight, Color strokeColor, Color fillColor) {
		super(x, y, width, height, strokeWeight, strokeColor, fillColor);
		// TODO Auto-generated constructor stub
	}
	public int getInfected() {
		return infectedPeople;
	}
	public int getTotal() {
		return totalPeople;
	}
}