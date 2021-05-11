package gamecomponents.people;

import java.util.ArrayList;
import display.Location;
import display.Tier;
import gamecomponents.places.Factory;
import gamecomponents.places.Hospital;
import gamecomponents.places.Place;
import gamecomponents.places.PublicPlace;
import gamecomponents.places.VaccineClinic;
import processing.core.PApplet;

/**
 * The Player class is a Person that is controlled by the user.
 */
public class Player extends Person {

	int[] inventory; //0 = mask, 1= infected, 2= doctor, 3= researcher, 4 = uninfected
	boolean isInfected;
	boolean hasPPE;
	boolean hasPerson;
	Person yourPerson;
	/**
	 * Creates a Player with given information
	 * @param loc Location at which the Player starts at
	 * @param isInfected whether the Player starts out infected or not
	 * @param direction which direction the Player will start moving in
	 */
	public Player(Location loc, boolean isInfected, char direction) {
		super(loc, isInfected, direction);
		inventory = new int[]{0,0,0,0,0};
		
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Draws the Player in the given Tier with the given PApplet
	 * @param marker PApplet on which the Player is drawn
	 * @param t Tier in which the Player is drawn
	 * @pre this method runs with the conditions previously set on the given PApplet
	 */
	public void draw(PApplet marker, Tier t) {
		if (this.getLocation() != null) {
			if(inventory[0] > 0) 
				marker.image(marker.loadImage("images/HazmatManMask.png"), t.getX() + 40 * this.getLocation().getCol(), t.getY() + 40 * this.getLocation().getRow(), 40, 40);
			else
				marker.image(marker.loadImage("images/HazmatMan.png"), t.getX() + 40 * this.getLocation().getCol(), t.getY() + 40 * this.getLocation().getRow(), 40, 40);
				
		}
	}
	/**
	 * Picks up a person from the Tier and updates the Inventory
	 * @param p the person that needs to put in the Inventory
	 * @param t the Tier in which the the person is in
	 */
	public void grabPerson(Person p, Tier t) {
			p.latchToPlayer(t);
			//TESTER if(p instanceof Person) inventory[0]++;
			yourPerson = p;
			if (p.isInfected()) {inventory[1] ++;}
			else if (p instanceof Doctor) {inventory[2]++;}
			else if (p instanceof Researcher) {inventory[3]++;}
		
	}
	/**
	 * Puts the person in a random adjacent spot
	 * @param p the person that needs to be placed
	 * @param t the Tier in which the the person is in
	 */
	public void dropPerson(Person p, Tier t) {
		
		if (yourPerson == null) return;
		
		ArrayList<Location> locAd = this.getLocation().getAdjacentLocations(t);
		ArrayList<Location> locs = new ArrayList<Location>();
		for (int i=0; i<locAd.size();i++) {
			if (t.getComponentAtLoc(locAd.get(i)) == null) {
				locs.add(locAd.get(i));
			}
		}
		
		Location loc = locs.get(returnRandom(locs.size()-1, 0));
		while (t.getComponentAtLoc(loc) != null) {
			locs.remove(loc);
			loc = locs.get(returnRandom(locs.size()-1, 0));
		}
			//System.out.println(loc.getRow() +" "+ loc.getCol());
		p.setLocation(loc);
		t.addPersonToGrid(p);
			//System.out.println(t.getComponentAtLoc(loc));
		
		if (p.isInfected()) {inventory[1]--;}
		if (p instanceof Doctor) {inventory[2]--;}
		if (p instanceof Researcher) {inventory[3]--;}
		
		yourPerson = null;
	}
	/**
	 * Gives a person a mask
	 * @param p the person that needs a mask
	 */
	public void giveMask(Tier t) {
		ArrayList<Location> locs = this.getLocation().getAdjacentLocations(t);
		
		ArrayList<Person> neighbors = new ArrayList<Person>();
		for (int i =0; i<locs.size(); i++) {
			if (t.getComponentAtLoc(locs.get(i)) instanceof Person) {
				Person p = (Person) t.getComponentAtLoc(locs.get(i));
				if (!p.isMasked() && !p.isInfected() && !(p instanceof Player))
					neighbors.add(p);
			}
		}
		int index = 0;
		while (inventory[0] > 0 && index < neighbors.size()) {
			neighbors.get(index).takeMask();
			inventory[0]--;
			index++;
		}
	}
	
	/**
	 * 
	 * @return the inventory
	 */
	public int[] getInventory() {
		return inventory;
	}
	
	/**
	 * Checks whether the Player can move
	 * @param t Tier in which the Player is inside
	 * @return whether or not the Player can move
	 */
	public boolean canMove(Location loc, Tier t) {
		if (loc == null) return false;
		if (loc.isOutOfBounds(t)) return false;
		if (t.getComponentAtLoc(loc) == null) return true;
		
		if (inventory[1] + inventory[2] + inventory[3] + inventory[4] <= 1) {
			if (t.getComponentAtLoc(loc) instanceof Person) {
				Person p = (Person) t.getComponentAtLoc(loc);
				if (yourPerson == null && (!p.isMasked()|| !p.isVaccinated()|| p.isInfected() || p instanceof Doctor || p instanceof Researcher)) {
					//		System.out.println("you've picked up a person");
					grabPerson(p, t);
					return true;
				}
			}
			if (t.getComponentAtLoc(loc) instanceof Place) {
				Place p = (Place) t.getComponentAtLoc(loc);
				if (p instanceof Hospital && yourPerson != null && yourPerson.isInfected()) {
					
						Hospital h = (Hospital)p;
						h.addPatient(yourPerson);
						yourPerson = null;
						/* TESTING
						Person person = new Person(null, false, 'r');
						this.dropPerson(person, t);
						*/
						inventory[1] --;
					
					return false;
				}
			
				else if (p instanceof PublicPlace) {
					if (inventory[2] >0) {
						inventory[2]--;
						PublicPlace place = (PublicPlace)p;
						place.convertIntoHospital();
					}
				}
				else if (p instanceof VaccineClinic) {
					if (inventory[3] >0) {
						inventory[3]--;
						PublicPlace place = (PublicPlace)p;
						place.convertIntoHospital();
					}
				}
				else if (p instanceof Factory) {
					if (((Factory) p).retrieveMasks() == 5) {
						inventory[0]+=5;
					}
				}
				else if (p instanceof VaccineClinic) {
					
				}
				return false;
			}
		}		
		return false;
		
	}

	
	@Override
	//player cannot contract the virus
	public void contractVirus() {
		
	}
	
	public Person getYourPerson() {
		return yourPerson;
	}
	
	private int returnRandom(int max, int min) {
		int range = (max-min);
		return (int) (Math.random()*range) +min;
	}
	


}