package display;

import java.awt.Color;
import java.util.ArrayList;

import gamecomponents.people.*;
import gamecomponents.places.*;
import processing.core.PApplet;


public class Tier extends Display {
	private int infectedPeople;
	private int totalDoctors, totalResearchers, totalPeople;
	private int totalPlaces, totalHospitals, totalPublicPlaces, totalFactories;
	private GameComponent[][] grid; //not accessible by other Tier objects, 
									//nor mutable without use of mutator methods
	private boolean isOver;
	private Player player;
	private CovidTracker tracker;
	private Person person; //TESTING DELETE LATER
	
	public Tier(double x, double y, double width, double height, int strokeWeight, Color strokeColor, Color fillColor) {
		super(x, y, width, height, strokeWeight, strokeColor, fillColor);
	
		//default 
		infectedPeople = 0;
		totalPeople = 0;
		totalHospitals = 0;
		totalPublicPlaces = 0;
		totalFactories = 0;
		totalDoctors = 0;
		totalResearchers = 0;
		
		isOver = false;
		tracker = new CovidTracker(675, 19 * 650/20, 240, (1102/900) * 20);
		person = new Person(new Location(3,3), false, 'u');
	}
	
	//Currently just hardcoding things into it for testing
	public void draw(PApplet marker) {
		
		tracker.update(this);
		tracker.draw(marker);
		
		int n = 40; // size of each square
		int x = 15; // how many squares
		for(int i=0; i<15; i++) {
			for (int j=0; j<x; j++) {
				marker.square(this.getX()+n*i,this.getY()+n*j,n);
			}
		}
		
		person.draw(marker, this);
		
		
		
	}
	
	//MUTATOR METHODS
	/**
	 * Add a person GameComponent into the grid at a specified location
	 * @param p an object of type Person 
	 * @param loc a Location (x,y) of the person in the grid 
	 */
	public void addPersonToGrid(Person p, Location loc) {
		if (grid[loc.getRow()][loc.getCol()] == null) { // if empty
			grid[loc.getRow()][loc.getCol()] = p;
			
			totalPeople++;
			
			if(p instanceof Doctor) totalDoctors++;
			else if(p instanceof Researcher) totalResearchers++;
	
		}
		else
			System.out.println("This space is occupied");
		
	}
	/**
	 * Add a place GameComponent into the grid at a specified location
	 * @param p an object of type Place
	 * @param locs an array of Locations (x,y) that the place occupies 
	 */
	public void addPlaceToGrid(Place p, Location[] locs) {
		for (int i = 0; i < locs.length; i++) {
			if (grid[locs[i].getRow()][locs[i].getCol()] == null) { // if empty
				grid[locs[i].getRow()][locs[i].getCol()] = p;
				
				totalPlaces++;
				
				if(p instanceof Hospital) totalHospitals++;
				else if(p instanceof PublicPlace) totalPublicPlaces++;
				else if(p instanceof Factory) totalFactories++;
			}
			else
				System.out.println("This space is occupied");
		}
	}
	
	
	//	ACCESSOR METHODS
	public GameComponent[][] getGrid() {
		return grid;
	}
	/**
	 * Get the component at a specified location in the grid
	 * @param loc the Location in the grid
	 * @return GameComponent the object in the grid
	 */
	public GameComponent getComponentAtLoc(Location loc) {
		return grid[loc.getRow()][loc.getCol()];
	}
	/**
	 * Get the status of the game, over or still playing
	 * @return boolean isOver
	 */
	public boolean getGameStatus() {
		return isOver;
	}

	public int getInfected() {
		return infectedPeople;
	}

	public int getPeople() {
		return totalPeople;
	}

	public int getPlaces() {
		return totalPlaces;
	}

	public int getHospitals() {
		return totalHospitals;
	}
	
	public int getDoctors() {
		return totalDoctors;
	}
	
	public int getFactories() {
		return totalFactories;
	}
	
	public int getResearchers() {
		return totalResearchers;
	}
	
	public int getPublicPlaces() {
		return totalPublicPlaces;
	}
	
	
	
}