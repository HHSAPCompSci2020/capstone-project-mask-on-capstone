package gamecomponents.people;

import display.GameComponent;
import display.Location;
import processing.core.PApplet;
import processing.core.PImage;

public class Person extends GameComponent {
	
	private Location loc;
	private PImage image;
	private boolean isInfected;
	private boolean masked;
	
	public Person(PImage image, Location loc, boolean isInfected) {
		this.image = image;
		this.loc = loc;
		this.isInfected = isInfected;
		masked = false;
	}
	
	public void draw(PApplet marker) {
		marker.image(image, loc.getRow(), loc.getCol(), 40, 40);
	}
	
}