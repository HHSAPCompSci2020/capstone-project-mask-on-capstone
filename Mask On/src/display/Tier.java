package display;

import java.awt.Color;
import java.util.ArrayList;

import processing.core.PApplet;

public abstract class Tier extends Display {
	private int infectedPeople;
	private int totalPeople;
	static Location[][] grid;
	
	public Tier(double x, double y, double width, double height, int strokeWeight, Color strokeColor, Color fillColor, int totalPeople) {
		super(x, y, width, height, strokeWeight, strokeColor, fillColor);
		// TODO Auto-generated constructor stub
		infectedPeople = 0;
		this.totalPeople = totalPeople;
	}
	public int getInfected() {
		return infectedPeople;
	}
	public int getTotal() {
		return totalPeople;
	}
	public 
}