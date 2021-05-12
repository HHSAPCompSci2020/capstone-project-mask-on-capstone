package display;

import gamecomponents.people.Doctor;
import gamecomponents.people.Person;
import gamecomponents.people.Player;
import gamecomponents.people.Researcher;
import processing.core.PApplet;
import processing.core.PImage;
/**
 * The Inventory class is a Display that shows what the player has
 * @author emtinside
 */
public class Inventory extends Display{

	/**
	 * 
	 * @param x x-coordinate of the start point
	 * @param y y-coordinate of the start point
	 * @param width width of the Inventory
	 * @param height height of the Inventory
	 */
	private int maskCount;
	private Person yourPerson;

	public Inventory( double x, double y, double width, double height) {
		super(x, y, width, height);
		maskCount = 0;
	}

	/**
	 * Draws the Inventory
	 * @param marker the PApplet on which the displayed element is drawn
	 * @pre this method runs with the conditions previously set on the given PApplet
	 */
	public void draw(PApplet marker) {
		marker.noStroke();
		marker.rect(getX(), getY(), getWidth(), getHeight());
		marker.fill(255);
		marker.stroke(0);

		marker.pushStyle();
			marker.fill(0);
			marker.textSize(18);
			marker.text("** INVENTORY ********", this.getX()+10, this.getY()+30);	
			
			marker.fill(255);
			marker.stroke(0);
			marker.rect(this.getX()+10, this.getY()+40, this.getWidth()-25, this.getHeight()/4);
			marker.rect(this.getX()+10, this.getY()+50 + this.getHeight()/4, this.getWidth()-25, this.getHeight()/4);
			PImage m = marker.loadImage("images/mask.png");
			m.resize(35,0);

			marker.image(m, this.getX()+ 10, this.getY()+40);
			marker.fill(0);
			marker.text("x" + maskCount, this.getX()+ 50, this.getY()+60);
		

		if (yourPerson != null) {
			marker.textSize(12);
			marker.fill(0);
			if (yourPerson.isInfected()) {
				PImage y = marker.loadImage("images/infected.png");
				y.resize(30,0);
				marker.image(y, this.getX() +10, this.getY()+50 + this.getHeight()/4);
				marker.text("(infected)", this.getX() +50, this.getY()+50 + this.getHeight()/4+20);
			}
			else if (yourPerson instanceof Researcher) {
				PImage y = marker.loadImage("images/researcher.png");
				y.resize(30,0);
				marker.image(y, this.getX() +10, this.getY()+50 + this.getHeight()/4);
				marker.text("(researcher)", this.getX() +50, this.getY()+50 + this.getHeight()/4+20);
			}
			else if (yourPerson instanceof Doctor) {
				PImage y = marker.loadImage("images/doctor.png");
				y.resize(30,0);
				marker.image(y, this.getX() +10, this.getY()+50 + this.getHeight()/4);
				marker.text("(doctor)", this.getX() +50, this.getY()+50 + this.getHeight()/4+20);
			}
			else if (!yourPerson.isVaccinated() && !yourPerson.isMasked()) {
				PImage y = marker.loadImage("images/uninfectedUnmasked.png");
				y.resize(30,0);
				marker.image(y, this.getX() +10, this.getY()+50 + this.getHeight()/4);
				marker.text("(unvaccinated)", this.getX() +50, this.getY()+50 + this.getHeight()/4+20);
			}
			else if (!yourPerson.isVaccinated() && yourPerson.isMasked()) {
				PImage y = marker.loadImage("images/uninfectedMasked.png");
				y.resize(30,0);
				marker.image(y, this.getX() +10, this.getY()+50 + this.getHeight()/4);
				marker.text("(unvaccinated)", this.getX() +50, this.getY()+50 + this.getHeight()/4+20);
			}
			else if (yourPerson.isVaccinated()) { //just in case there's errors in the future
				PImage y = marker.loadImage("images/vaccinated.png");
				y.resize(30,0);
				marker.image(y, this.getX() +10, this.getY()+50 + this.getHeight()/4);
				marker.text("(vaccinated)", this.getX() +50, this.getY()+50 + this.getHeight()/4+20);
			}
			
		}
		marker.popStyle();
		
	}
	
	/**
	 * updates the inventory variables S
	 * @param p Player referenced
	 * @param t Tier referenced
	 */
	public void update(Player p, Tier t) {
		int[] inventory = p.getInventory();
		maskCount = inventory[0];
		yourPerson = p.getYourPerson();

	}
	
}