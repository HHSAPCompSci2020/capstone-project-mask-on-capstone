package display;

import java.awt.Color;
import java.util.ArrayList;

import gamecomponents.people.*;
import gamecomponents.places.*;
import processing.core.PApplet;

/**
 * This class represents the overall structure of a Tier, or level, in the Mask On! game
 * @author emtinside
 *
 */
public class Tier extends Display {
	private int infectedPeople;
	private int totalDoctors, totalResearchers, totalPeople;
	private int totalPlaces, totalHospitals, totalPublicPlaces, totalFactories;
	private GameComponent[][] grid; //not accessible by other Tier objects, 
									//nor mutable without use of mutator methods
	private boolean isOver;
	private Player player;
	private CovidTracker tracker;
	private Person person, person2; //TESTING DELETE LATER
	private Place place; //TESTING DELETE LATER
	private int stopwatch;
	private Inventory inventory;
	private TimerDisplay timer;
	
	/**
	 * Set up a tier with the given values, similar to Display
	 * @param x the top left corner x value
	 * @param y the top left corner y value
	 * @param width tier width
	 * @param height tier height
	 * @param strokeWeight strokeweight of lines
	 * @param strokeColor strokecolor of lines
	 * @param fillColor fill color of shapes
	 */
	public Tier(double x, double y, double width, double height, int strokeWeight, Color strokeColor, Color fillColor) {
		super(x, y, width, height, strokeWeight, strokeColor, fillColor);
	
		grid = new GameComponent[15][15];
		//default 
		infectedPeople = 0;
		totalPeople = 0;
		totalHospitals = 0;
		totalPublicPlaces = 0;
		totalFactories = 0;
		totalDoctors = 0;
		totalResearchers = 0;
		stopwatch = 0;
		
		player = new Player(new Location(1,2), false, 'r');
		isOver = false;
		tracker = new CovidTracker(675, 18 * 650/20, 240, (1102/900) * 20);
		person = new Person(new Location(0,6), false, 'l');
		person2 = new Person(new Location(1,3), true, 'r');
		ArrayList<Location> placeSquares = new ArrayList<Location>();
		placeSquares.add(new Location(0, 0));
		place = new Place(placeSquares);
		inventory = new Inventory(675, 290,  240, 240);
		timer = new TimerDisplay(675, 19 * 660/20, 125, (1102/900) * 50);
		this.addPersonToGrid(person);
		this.addPersonToGrid(person2);
		this.addPlaceToGrid(place);
		this.addPersonToGrid(player);
	}
	
	//Currently just hardcoding things into it for testing
	/**
	 * Draw the tier on the surface
	 * @param marker the PApplet surface you're drawing on
	 */
	public void draw(PApplet marker) {
		
		tracker.update(this);
		tracker.draw(marker);
		inventory.draw(marker);
		inventory.update(player, this);
		timer.updateTime();
		timer.draw(marker);
		
		
		//GRID
		int n = 40; // size of each square
		int x = 15; // how many squares
		for(int i=0; i<15; i++) {
			for (int j=0; j<x; j++) {
				marker.square(this.getX()+n*i,this.getY()+n*j,n);
			}
		}
		
		player.draw(marker, this);
		person.draw(marker, this);
		person2.draw(marker, this);
		place.draw(marker, this);
		stopwatch++;
		
		if (stopwatch % 10 == 0) {
			this.movePerson(person);
			this.movePerson(person2);
		}
		
	}
	
	//MUTATOR METHODS
	/**
	 * Add a person GameComponent into the grid at a specified location
	 * @param p an object of type Person 
	 */
	public void addPersonToGrid(Person p) {
		Location loc = p.getLocation();
		if (loc.getRow() >= grid.length || loc.getRow() < 0 || loc.getCol() >= grid.length || loc.getCol() < 0)
			System.out.println("You're out of bounds buddy");
		else if (grid[loc.getRow()][loc.getCol()] == null) { // if empty
			grid[loc.getRow()][loc.getCol()] = p;
			
			if (!(p instanceof Player)) totalPeople++;
			
			if (p.isInfected()) infectedPeople++;
			if(p instanceof Doctor) totalDoctors++;
			else if(p instanceof Researcher) totalResearchers++;
	
		}
		else
			System.out.println("This space is occupied");
		
	}
	/**
	 * Add a place GameComponent into the grid at a specified location
	 * @param p an object of type Place
	 */
	public void addPlaceToGrid(Place p) {
		ArrayList<Location> locs = p.getLocations();
		for (int i = 0; i < locs.size(); i++) {
			if (grid[locs.get(i).getRow()][locs.get(i).getCol()] == null) { // if empty
				grid[locs.get(i).getRow()][locs.get(i).getCol()] = p;
				
				totalPlaces++;
				
				if(p instanceof Hospital) totalHospitals++;
				else if(p instanceof PublicPlace) totalPublicPlaces++;
				else if(p instanceof Factory) totalFactories++;
			}
			else
				System.out.println("This space is occupied");
		}
	}
	
	/**
	 * Move a Person from its original location to a new location
	 * @param p the Person object you are moving
	 */
	public void movePerson(Person p) {
		infectedPeople += p.processPeople(this);
		
		if (p.canMove(this)){
			grid[p.getLocation().getRow()][p.getLocation().getCol()] = null;
			p.move();
			grid[p.getLocation().getRow()][p.getLocation().getCol()] = p;
			
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
		//so that nothing moves to out-of-bounds locations
		if (loc.getRow() < 0 || loc.getRow() >= grid.length || loc.getCol() < 0 || loc.getCol() >= grid[0].length) {
			return new GameComponent();
		}
		return grid[loc.getRow()][loc.getCol()];
	}
	/**
	 * Get the status of the game, over or still playing
	 * @return boolean isOver
	 */
	public boolean getGameStatus() {
		return isOver;
	}
	
	/**
	 * 
	 * @return the number of infected people
	 */
	public int getInfected() {
		return infectedPeople;
	}

	/**
	 * 
	 * @return the total number of people
	 */
	public int getPeople() {
		return totalPeople;
	}
	
	/**
	 * 
	 * @return the Player object in control of the game
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * 
	 * @return the total number of Places
	 */
	public int getPlaces() {
		return totalPlaces;
	}

	/**
	 * 
	 * @return the total number of Hospitals
	 */
	public int getHospitals() {
		return totalHospitals;
	}
	
	/**
	 * 
	 * @return the total number of Doctors
	 */
	public int getDoctors() {
		return totalDoctors;
	}
	
	/**
	 * 
	 * @return the total number of Factories
	 */
	public int getFactories() {
		return totalFactories;
	}
	
	/**
	 * 
	 * @return the total number of Researchers
	 */
	public int getResearchers() {
		return totalResearchers;
	}
	
	/**
	 * 
	 * @return the total number of PublicPlaces
	 */
	public int getPublicPlaces() {
		return totalPublicPlaces;
	}
	
	/**
	 * 
	 * @return the total number of times the draw() method has been called
	 */
	public int getStopwatch() {
		return stopwatch;
	}
	
	/**
	 * 
	 * @param i the number to set the supposed previous number of draw() calls to
	 */
	public void setStopwatch(int i) {
		stopwatch = i;
	}
	
	
	
}