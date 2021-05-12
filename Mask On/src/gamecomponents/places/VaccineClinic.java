package gamecomponents.places;

import java.util.ArrayList;
import display.Location;
import display.Tier;
import gamecomponents.people.Doctor;
import gamecomponents.people.Person;
import gamecomponents.people.Player;
import gamecomponents.people.Researcher;
import processing.core.PApplet;
import tiers.PurpleTier;
/**
 * The VaccineClinic represents a Place that vaccinates people. It can hold a maximum of 5 patients at a time and can have 1 Researcher.
 * @author Felicia Zhang
 *
 */

public class VaccineClinic extends Place {
	private ArrayList<Person> patients;
	private ArrayList<Double> times;
	private double startTime;
	private Researcher researcher;
	private boolean isOpen;
	private boolean isDisabled;
	/**
	 * Creates a VaccineClinic at certain locations
	 * @param locs the ArrayList of Location objects the VaccineClinic occupies
	 */
	public VaccineClinic(ArrayList<Location> locs) {
		super(locs);
		patients = new ArrayList<Person>();
		times = new ArrayList<Double>();
		startTime = (double)(System.currentTimeMillis());
		isOpen = true;
		researcher = null;
		isDisabled = false;
	}
	/**
	 * Draws the VaccineClinic in the given Tier, the VaccineClinic shows that number of researches it currently has if it is not open
	 * if it is open, the VaccineClinic displays the word open
	 * @param marker the PApplet surface on which the VaccineClinic is being drawn
	 * @param t the Tier in which the Hospital is inside
	 * @pre this method runs with the conditions previously set on the given PApplet
	 */
	public void draw(PApplet marker, Tier t) {
		marker.pushStyle();
		marker.fill(200);
		/*
		for (Location l : getLocations()) {
			marker.stroke(120);
			marker.square(t.getX() + 40 * l.getCol(), t.getY() + 40 * l.getRow(), 40);
		}
		*/
		marker.fill(0);
		int x = getLocations().get(0).getCol();
		int y = getLocations().get(0).getRow();
		marker.image(marker.loadImage("images/vaccine.png"), t.getX()+ 40*x,  t.getY() + 40*y, t.getWidth()*2/15, t.getHeight()*2/15);
		if (!isDisabled) {
			if (t instanceof PurpleTier && researcher == null) {
				isOpen = false;
			}
			if ((double)(System.currentTimeMillis() - startTime)/1000 >= 15) {
				isOpen = true;
			}
			else {
				isOpen = false;
			}
			marker.textSize(8);
			if (isOpen) {
				marker.text("Patients:\n " + patients.size(), t.getX()+ 40*(x+0.2f), t.getY() + 40*(y+1.4f));
			}
			else {
				marker.text("CLOSED", t.getX()+ 40*(x+0.2f), t.getY() + 40*(y+1.4f));
			}
			removePatient(t);
		}
		marker.popStyle();
	}
	/**
	 * Admits a patient to the VaccineClinic, a Person that is not a Doctor, Player, or Researcher can only be admitted if the clinic is not at its full capacity of 5 people. 
	 * Only 1 Researcher can be admitted to a clinic.
	 * @param p the Person that wants to be admitted to the VaccineClinic
	 * @return whether or not the patient was admitted to the VaccineClinic
	 */
	public boolean addPerson(Person p) {
		if (p instanceof Researcher && researcher == null) {
			researcher = (Researcher) p;
			startTime = (double)System.currentTimeMillis();
			return true;
		}
		else if (patients.size() < 5 && isOpen && !(p instanceof Doctor) && !(p instanceof Player)) {
			patients.add(p);
			times.add((double)(System.currentTimeMillis()));
			return true;
		}
		return false;
	}
	/**
	 * Removes a patient a patient that has stayed at the clinic for at least 15 seconds
	 * @param t The Tier that the VaccineClinic is in
	 */
	public void removePatient(Tier t) {
		double currentTime = (double)(System.currentTimeMillis());
		for (int i = 0; i<patients.size(); i++) {
			if ((currentTime - times.get(i))/1000 >= 15) {
				times.remove(i);
				ArrayList<Location> clinicLocs = new ArrayList<Location>();
				for (int a=0; a<this.getLocations().size(); a++){
					clinicLocs.addAll(this.getLocations().get(a).getAdjacentLocations(t));
				}
				for (int b=0; b<clinicLocs.size();b++) {
					if (clinicLocs.get(b).isOutOfBounds(t) || t.getComponentAtLoc(clinicLocs.get(b)) != null) {
						clinicLocs.remove(b);
						b--;
					}
					
				}		
				Location loc = clinicLocs.get(0); 
				Person p = patients.get(i);
				p.getVaccinated();
				patients.get(i).setLocation(loc);
				t.addPersonToGrid(p);
				patients.remove(i);
				}
			}
		}
	/**
	 * 
	 * @param b sets the disabled status of the VaccineClinic
	 */
	public void setDisabled (boolean b) {
		isDisabled = b;
	}
}

