package gamecomponents.places;

import java.util.ArrayList;
import display.Location;
import display.Tier;
import gamecomponents.people.Person;
import gamecomponents.people.Researcher;
import processing.core.PApplet;
/**
 * The VaccineClinic represents a Place that vaccinates people after the researches make the vaccine. It can hold a maximum of 5 patients at a time and opens after 3 researchers enter.
 * @author Felicia Zhang
 *
 */
public class VaccineClinic extends Place {
	private ArrayList<Person> patients;
	private ArrayList<Double> times;
	private int researcherCount;
	public VaccineClinic(ArrayList<Location> locs) {
		super(locs);
		patients = new ArrayList<Person>();
		times = new ArrayList<Double>();
		researcherCount = 0;
	}
	/**
	 * Draws the VaccineClinic in the given Tier, the VaccineClinic shows that number of researches it currently has if it is not open
	 * if it is open, the VaccineClinic displays the word open
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
		marker.image(marker.loadImage("images/vaccine.png"), t.getX()+ 40*x,  t.getY() + 40*y, t.getWidth()*2/15, t.getHeight()*2/15);
		if (researcherCount>=3) {
			marker.text("OPEN: " + patients.size(), t.getX()+ 40*(x+0.2f), t.getY() + 40*(y+1.2f));
		}
		else {
			marker.text("Researchers: " + researcherCount, t.getX()+ 40*(x+0.2f), t.getY() + 40*(y+1.2f));
		}
		marker.popStyle();
		removePatient(t);
	}
	/**
	 * Admits a person to the VaccineClinic, a Person that is not a Researcher can only be admitted if the clinic is open and not full
	 * @param p the Person that wants to be admitted to the VaccineClinic
	 * @return whether or not the patient was admitted to the VaccineClinic
	 */
	public boolean addPerson(Person p) {
		if (p instanceof Researcher) {
			researcherCount++;
			return true;
		}
		else if (patients.size() < 5 && researcherCount>=3) {
			patients.add(p);
			times.add((double)(System.currentTimeMillis()));
			return true;
		}
		return false;
	}
	/**
	 * Removes a patient a patient that has stayed at the VaccineClinic for at least 30 seconds
	 * @return the Person that was removed or if no one was removed, null is returned
	 */
	public void removePatient(Tier t) {
		double currentTime = (double)(System.currentTimeMillis());
		for (int i = 0; i<patients.size(); i++) {
			if ((currentTime - times.get(i))/1000 >= 30) {
				times.remove(i);
				Person p = patients.get(i);
				p.getVaccinated();
				Location loc = getLocations().get(2).getBottom(t);
				patients.get(i).setLocation(loc);
				System.out.println(p.getLocation().getRow() + " "+p.getLocation().getCol());
				t.addPersonToGrid(p);
				t.addPersonToArrayList(p);
				patients.remove(i);
			}
		}
	}
	public boolean returnStatus() {
		return researcherCount>=3;
	}
	
}
