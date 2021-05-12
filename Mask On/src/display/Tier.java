package display;

import java.awt.Color;
import java.util.ArrayList;
import gamecomponents.people.*;
import gamecomponents.places.*;
import processing.core.PApplet;
import processing.core.PConstants;
import tiers.OrangeTier;
import tiers.PurpleTier;
import tiers.RedTier;
import tiers.YellowTier;

/**
 * This class represents the overall structure of a Tier, or level, in the Mask On! game
 * @author emtinside
 *
 */
public abstract class Tier extends Display {
	private int infectedPeople;
	private GameComponent[][] grid; //not accessible by other Tier objects, 
									//nor mutable without use of mutator methods
	private boolean over;
	private Player player;
	private CovidTracker tracker;
	private ArrayList<Person> people;
	private ArrayList<Place> places;
	private int stopwatch;
	private Inventory inventory;
	private TimerDisplay timer;
	private TaskBar taskBar;
	
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
		stopwatch = 0;
		
		people = new ArrayList<Person>();
		places = new ArrayList<Place>();
		over = false;
		tracker = new CovidTracker(675, 18 * 650/20, 240, (1102/900) * 20);
		inventory = new Inventory(675, 290,  240, 120);
		timer = new TimerDisplay(675, 19 * 660/20, 125, (1102/900) * 50);
		taskBar = new TaskBar(675, 430,  240, 120);
	}
	
	//Currently just hardcoding things into it for testing
	/**
	 * Draw the tier on the surface
	 * @param marker the PApplet surface you're drawing on
	 * @pre this method runs with the conditions previously set on the given PApplet
	 */
	public void draw(PApplet marker) {
		
		over = tracker.update(this);
		tracker.draw(marker);
		inventory.draw(marker);
		inventory.update(player, this);
		taskBar.update(this);
		taskBar.draw(marker);
		if (!over) {
			timer.updateTime();
		}
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
		
		for (Person p : people) {
			p.draw(marker, this);
		}
		
		for (Place p : places) {
			p.draw(marker, this);
		}

		stopwatch++;
		
		if (!over) {
			if (stopwatch % 20 == 0) {
				for (Person p : people) {
					movePerson(p);
				}
			}
		}
		
		if (over) {
				marker.pushStyle();
				
				if (this instanceof YellowTier) {
					marker.fill(255, 220, 0, 175);
				}
				else if (this instanceof OrangeTier) {
					marker.fill(255, 127.5F, 0, 175);
				}
				else if (this instanceof RedTier) {
					marker.fill(255, 0, 0, 175);
				}
				else if (this instanceof PurpleTier) {
					marker.fill(255, 0, 255, 175);
				}
				else marker.fill(0,0,0,175);
				
				marker.rect(getX(),getY(),getWidth(),getHeight());
				marker.fill(255);
				marker.rect(1000/4+10, 750/2-10, 200,100);
				marker.fill(0);
				marker.textSize(30);
				marker.textAlign(PConstants.CENTER, PConstants.CENTER);
				marker.text("VICTORY", 1000/4 + 10, 750/2-10, 200, 50);
				
				//http://cliparts.co/yellow-star-clip-art
				if (getScore() == 1) {
					marker.image(marker.loadImage("images/filledstar.png"), 295, 415, 40, 40);
					marker.image(marker.loadImage("images/unfilledstar.png"), 340, 415, 40, 40);
					marker.image(marker.loadImage("images/unfilledstar.png"), 385, 415, 40, 40);
				}
				else if (getScore() == 2) {
					marker.image(marker.loadImage("images/filledstar.png"), 295, 415, 40, 40);
					marker.image(marker.loadImage("images/filledstar.png"), 340, 415, 40, 40);
					marker.image(marker.loadImage("images/unfilledstar.png"), 385, 415, 40, 40);
				}
				else {
					marker.image(marker.loadImage("images/filledstar.png"), 295, 415, 40, 40);
					marker.image(marker.loadImage("images/filledstar.png"), 340, 415, 40, 40);
					marker.image(marker.loadImage("images/filledstar.png"), 385, 415, 40, 40);
				}
				
				marker.popStyle();
		}
		
	}
	
	//MUTATOR METHODS
	/**
	 * Add a person GameComponent into the grid at a specified location in the Person's contructor;
	 * @param p an object of type Person 
	 */
	public void addPersonToGrid(Person p) {
		Location loc = p.getLocation();
		if (loc.getRow() >= grid.length || loc.getRow() < 0 || loc.getCol() >= grid.length || loc.getCol() < 0)
			System.out.println("You're out of bounds buddy");
		
		else if (grid[loc.getRow()][loc.getCol()] == null) { // if empty
			grid[loc.getRow()][loc.getCol()] = p;
		}
		else {
			System.out.println("This space is occupied");
		}
	}
	
	public void addPersonToArrayList(Person p) {
		if (p.isInfected()) infectedPeople++;
		people.add(p);
		this.addPersonToGrid(p);
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
			}
			else
				System.out.println("This space is occupied");
		
		}
	}
	
	public void addPlaceToArrayList(Place p) {
		places.add(p);
		this.addPlaceToGrid(p);
	}

	
	/**
	 * Move a Person from its original location to a new location
	 * @param p the Person object you are moving
	 */
	public void movePerson(Person p) {
		infectedPeople += p.processPeople(this);
		
		if (p.canMove(this) && p.getLocation() != null){
			grid[p.getLocation().getRow()][p.getLocation().getCol()] = null;
			p.move();
			grid[p.getLocation().getRow()][p.getLocation().getCol()] = p;
			
		}
		
		//just in case it doesn't infect the first time
		infectedPeople += p.processPeople(this);
		
	}
	
	/**
	 * Move a Person from its original location to a new location
	 * @param p the Person object you are moving
	 */
	public void movePlayer(Location loc, Player p) {
		
		if (p.canMove(loc, this) && p.getLocation() != null){
			grid[p.getLocation().getRow()][p.getLocation().getCol()] = null;
			p.setLocation(loc);
			grid[p.getLocation().getRow()][p.getLocation().getCol()] = p;
			
		}
		
	}
	
	/**
	 * Remove a person from the grid only so that you cannot see them, will still count towards the total population
	 * @param p Person
	 */
	public void removeFromGrid(Person p) {
		grid[p.getLocation().getRow()][p.getLocation().getCol()] = null;
		p.setLocation(null);
	}
	
	/**
	 * Remove a place from the grid permanently
	 * @param p Place
	 */
	public void removeFromGrid(Place p) {
		ArrayList<Location> locs = p.getLocations();
		for(int i=0; i<locs.size(); i++) {
			grid[locs.get(i).getRow()][locs.get(i).getCol()] = null;
			places.remove(p);
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
		if (loc != null) {
		if ((loc.getRow() < 0 || loc.getRow() >= grid.length || loc.getCol() < 0 || loc.getCol() >= grid[0].length)) {
			return new GameComponent();
		}
		return grid[loc.getRow()][loc.getCol()];
		}
		return null;
		
	}
	/**
	 * Get the status of the game, over or still playing
	 * @return boolean isOver
	 */
	public boolean getGameStatus() {
		return over;
	}
	
	/**
	 * 
	 * @return the number of infected people
	 */
	public int getInfected() {
		return infectedPeople;
	}
	
	public ArrayList<Person> getPeople() {
		return people;
	}
	
	
	public void addPlayer(Player p) {
		if (player == null) player = p;
		this.addPersonToGrid(p);
	}
	
	public ArrayList<Place> getPlaces() {
		return places;
	}
	

	/**
	 * 
	 * @return the total number of people
	 */
	public int getNumPeople() {
		return people.size();
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
	public int getNumPlaces() {
		return places.size();
	}

	/**
	 * 
	 * @return the total number of Hospitals
	 */
	public int getHospitals() {
		int totalHospitals=0;
		for (Place p: places) {
			if (p instanceof Hospital) {
				totalHospitals++;
			}
		}
		return totalHospitals;
	}
	
	/**
	 * 
	 * @return the total number of Doctors
	 */
	public int getDoctors() {
		int totalDoctors=0;
		for (Person p: people) {
			if (p instanceof Doctor) {
				totalDoctors++;
			}
		}
		return totalDoctors;
	}
	
	/**
	 * 
	 * @return the total number of Factories
	 */
	public int getFactories() {
		int totalFactories=0;
		for (Place p: places) {
			if (p instanceof Factory) {
					totalFactories++;
			}
		}
		return totalFactories;
	}
	
	/**
	 * 
	 * @return the total number of Researchers
	 */
	public int getResearchers() {
		int totalResearchers=0;
		for (Person p: people) {
			if (p instanceof Researcher) {
				totalResearchers++;
			}
		}
		return totalResearchers;
	}
	
	/**
	 * 
	 * @return the total number of PublicPlaces
	 */
	public int getPublicPlaces() {
		int totalPublicPlaces=0;
		for (Place p: places) {
			if (p instanceof PublicPlace) {
				totalPublicPlaces++;
			}
		}
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
	
	public void reduceInfected() {
		infectedPeople--;
	}
	
	public TimerDisplay getTimerDisplay() {
		return timer;
	}
	
	public abstract int getScore();
	
	public void randomSpawn(int normalPeople, int infected, int doctors, int researchers) {
		for (int i = 0; i < normalPeople; i++) {
			addPersonToArrayList(new Person(randomEmptyLocation(), false, randomDirection()));
		}
		for (int i = 0; i < infected; i++) {
			addPersonToArrayList(new Person(randomEmptyLocation(), true, randomDirection()));
		}
		for (int i = 0; i < doctors; i++) {
			addPersonToArrayList(new Doctor(randomEmptyLocation(), randomDirection()));
		}
		for (int i = 0; i < researchers; i++) {
			addPersonToArrayList(new Researcher(randomEmptyLocation(), randomDirection()));
		}
	}
	
	private Location randomEmptyLocation() {
		ArrayList<Location> emptyLocs = new ArrayList<Location>();
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (grid[r][c] == null) emptyLocs.add(new Location(r, c));
			}
		}
		int random = (int) (Math.random() * emptyLocs.size());
		return emptyLocs.get(random);
	}
	
	private char randomDirection() {
		int random = (int) (Math.random() * 4);
		
		if (random == 0) {
			return 'u';
		}
		else if (random == 1) {
			return 'd';
		}
		else if (random == 2) {
			return 'l';
		}
		else {
			return 'r';
		}
	}
	
	
}