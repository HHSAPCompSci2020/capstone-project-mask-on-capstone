package display;

import java.awt.Color;
//import gamecomponents.people.Person;
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
	
	//MUTATOR METHODS
	/**
	 * Add a person GameComponent into the grid at a specified location
	 */
	public void addPersonToGrid() {
		
	}
	public void addPlaceToGrid() {
		
	}
	
	//ACCESSOR METHODS
	public int getInfected() {
		return infectedPeople;
	}
	public int getTotal() {
		return totalPeople;
	}
	public Location[][] getGrid() {
		return grid;
	}
	
	
	
}