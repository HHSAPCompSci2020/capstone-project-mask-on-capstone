package gamecomponents.places;

import java.util.ArrayList;

import display.Location;
import display.Tier;
import gamecomponents.people.Person;
import processing.core.PApplet;
/**
 * The Hospital class represents a Place that can hold 5 patients at a time. 
 * @author Felicia Zhang
 *
 */
public class Hospital extends Place {
	private ArrayList<Person> patients;
	private ArrayList<Double> times;
	/**
	 * 
	 * @param locs the ArrayList of Location objects the Hospital occupies
	 */
	public Hospital(ArrayList<Location> locs) {
		super(locs);
		patients = new ArrayList<Person>();
		times = new ArrayList<Double>();
	}
	/**
	 * Draws the Hospital in the given Tier, the Hospital shows that number of patients it currently has
	 * @param marker the PApplet surface on which the Hospital is being drawn
	 * @param t the Tier in which the Hospital is inside
	 * @pre this method runs with the conditions previously set on the given PApplet
	 */
	public void draw(PApplet marker, Tier t) {
		marker.pushStyle();
		for (Location l : getLocations()) {
			marker.stroke(120);
			marker.square(t.getX() + 40 * l.getCol(), t.getY() + 40 * l.getRow(), 40);
		}
		marker.fill(0);
		marker.textSize(12);
		int x = getLocations().get(0).getCol();
		int y = getLocations().get(0).getRow();
		marker.image(marker.loadImage("images/hospital.png"), t.getX()+ 40*x,  t.getY() + 40*y, t.getWidth()*2/15, t.getHeight()*2/15);
		marker.text("Patients: " + patients.size(), t.getX()+ 40*(x+0.2f), t.getY() + 40*(y+1.2f));
		marker.popStyle();
		removePatient(t);
	}
	/**
	 * Admits a person to the Hospital if the Hospital is not full
	 * @param p the Person that wants to be admitted to the Hospital
	 * @return whether or not the patient was admitted to the Hospital
	 */
	public boolean addPatient(Person p) {
		if (patients.size()<5) {
			patients.add(p);
			times.add((double)(System.currentTimeMillis()));
			return true;
		}
		return false;
	}
	/**
	 * Removes a patient a patient that has stayed at the Hospital for at least 30 seconds
	 * @return the Person that was removed or if no one was removed, null is returned
	 */
	public void removePatient(Tier t) {
		double currentTime = (double)(System.currentTimeMillis());
		for (int i = 0; i<patients.size(); i++) {
			if ((currentTime - times.get(i))/1000 >= 5) {
				times.remove(i);
				
				/*
				 * 1. get what the hospital occupies (arraylist of locations)
				 * 2. find the adjacent locations to all the locations that hospital occupies (arraylist of locations)
				 * 3. Add all the locations at 2) into 1)
				 */
				
				ArrayList<Location> hosLocs = new ArrayList<Location>();
				for (int a=0; a<this.getLocations().size(); a++){
					hosLocs.addAll(this.getLocations().get(a).getAdjacentLocations(t));
				}
				//ArrayList<Location> validLocs = new ArrayList<Location>();
				for (int b=0; b<hosLocs.size();b++) {
					if (hosLocs.get(b).isOutOfBounds(t) || t.getComponentAtLoc(hosLocs.get(b)) != null) {
						hosLocs.remove(b);
						b--;
					}
					
				}
				
				Location loc = hosLocs.get(0); 
//System.out.println(loc.getRow() +" "+ loc.getCol());
				Person p = patients.get(i);
				p.cure(t);
			//	Location loc = getLocations().get(2).getBottom(t);
				patients.get(i).setLocation(loc);
					//System.out.println(p.getLocation().getRow() + " "+p.getLocation().getCol());
				t.addPersonToGrid(p);
			//	t.addPersonToArrayList(p);
				patients.remove(i);
//				System.out.println(t.getPeople());
				
				//return patients.remove(i);
				}
			}
		}
	
		//return null;

}

