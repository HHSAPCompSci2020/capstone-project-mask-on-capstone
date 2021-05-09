package gamecomponents.places;

import java.util.ArrayList;

import display.Location;
import display.Tier;
import gamecomponents.people.Person;
import processing.core.PApplet;

public class Hospital extends Place {
	private ArrayList<Person> patients;
	private ArrayList<Double> times;
	
	public Hospital(ArrayList<Location> locs) {
		super(locs);
		patients = new ArrayList<Person>();
		times = new ArrayList<Double>();
	}
	public void draw(PApplet marker, Tier t) {
		marker.pushStyle();
		marker.fill(120);
		for (Location l : getLocations()) {
			marker.stroke(120);
			marker.square(t.getX() + 40 * l.getCol(), t.getY() + 40 * l.getRow(), 40);
		}
		marker.fill(255);
		marker.textSize(12);
		int x = getLocations().get(0).getCol();
		int y = getLocations().get(0).getRow();
		marker.text("Patients:", t.getX()+ t.getWidth()*11/105, t.getY() + t.getHeight()/30);
		marker.text(patients.size(), t.getX()+ t.getWidth()*2/15, t.getY()+ t.getHeight()/15);
		marker.image(marker.loadImage("images/hospital.png"), t.getX()+ 40*x,  t.getY() + 40*y, t.getWidth()*2/15, t.getHeight()*2/15);
		marker.popStyle();
	}
	public boolean addPatient(Person p) {
		if (patients.size()<5) {
			patients.add(p);
			p.getVaccinated();
			times.add((double)(System.currentTimeMillis()));
			return true;
		}
		return false;
	}
	public Person removePatient() {
		double currentTime = (double)(System.currentTimeMillis());
		for (int i = 0; i<patients.size(); i++) {
			if ((currentTime - times.get(i))/1000 >= 30) {
				times.remove(i);
				return patients.remove(i);
			}
		}
		return null;
	}
}

