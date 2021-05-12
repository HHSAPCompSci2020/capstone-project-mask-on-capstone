package gamecomponents.places;

import java.util.ArrayList;

import display.Location;
import display.Tier;
import gamecomponents.people.Doctor;
import gamecomponents.people.Person;
import gamecomponents.people.Player;
import gamecomponents.people.Researcher;
import processing.core.PApplet;
/**
 * The Hospital class represents a Place that cures the infected people and can hold 5 patients at a time. It can have at most 1 Doctor. 
 * @author Felicia Zhang
 *
 */
public class Hospital extends Place {
	private ArrayList<Person> patients;
	private ArrayList<Double> times;
	private Doctor doctor;
	private boolean isDisabled;
	/**
	 * Creates a Hospital at certain locations.
	 * @param locs the ArrayList of Location objects the Hospital occupies
	 */
	public Hospital(ArrayList<Location> locs) {
		super(locs);
		patients = new ArrayList<Person>();
		times = new ArrayList<Double>();
		doctor = null;
		isDisabled = false;
	}
	/**
	 * Draws the Hospital in the given Tier, the Hospital shows that number of patients it currently has. The Hospital also removes patients who have stayed for at least 15 seconds.
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
		if (!isDisabled) {
			marker.text("Patients: " + patients.size(), t.getX()+ 40*(x+0.2f), t.getY() + 40*(y+1.2f));
			removePatient(t);
		}
		marker.popStyle();
	}
	/**
	 * Admits a person that is not a Researcher or Player to the Hospital if the Hospital is not at its maximum capacity of 5 people.
	 * Only 1 Doctor may be admitted to a Hospital. 
	 * @param p the Person that wants to be admitted to the Hospital
	 * @return whether or not the patient was admitted to the Hospital
	 */
	public boolean addPatient(Person p) {
		if (p instanceof Doctor && doctor == null) {
			doctor = (Doctor) p;
			return true;
		}
		else if (patients.size()<5 && !(p instanceof Researcher) && !(p instanceof Player)) {
			patients.add(p);
			times.add((double)(System.currentTimeMillis()));
			return true;
		}
		return false;
	}
	private void removePatient(Tier t) {
		double currentTime = (double)(System.currentTimeMillis());
		for (int i = 0; i<patients.size(); i++) {
			if ((currentTime - times.get(i))/1000 >= 15) {
				times.remove(i);
				ArrayList<Location> hosLocs = new ArrayList<Location>();
				for (int a=0; a<this.getLocations().size(); a++){
					hosLocs.addAll(this.getLocations().get(a).getAdjacentLocations(t));
				}
				for (int b=0; b<hosLocs.size();b++) {
					if (hosLocs.get(b).isOutOfBounds(t) || t.getComponentAtLoc(hosLocs.get(b)) != null) {
						hosLocs.remove(b);
						b--;
					}
				}
				Location loc = hosLocs.get(0); 
				Person p = patients.get(i);
				p.cure(t);
				patients.get(i).setLocation(loc);
				t.addPersonToGrid(p);
				patients.remove(i);
				}
			}
		}
	/**
	 * Sets the disabled status of the Hospital
	 * @param b the new status of the Hospital, true means the Hospital is now disabled
	 */
	public void setDisabled (boolean b) {
		isDisabled = b;
	}
}

