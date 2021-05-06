package display;

import gamecomponents.people.Player;
import processing.core.PApplet;
import processing.core.PImage;
/**
 * The Inventory class is a Display that shows what the player has
 *
 */
public class Inventory extends Display{

	/**
	 * 
	 * @param x x-coordinate of the start point
	 * @param y y-coordinate of the start point
	 * @param width width of the Inventory
	 * @param height height of the Inventory
	 */
	private int maskCount, infectedCount, doctorCount, researcherCount;
	private int[] inventory;

	public Inventory(double x, double y, double width, double height) {
		super(x, y, width, height);
		maskCount = 0;
		doctorCount =0;
		researcherCount =0;
		infectedCount =0;
		
		inventory = new int[4]; //0= infected, 1= doctor, 2= researcher
	
	}

	/**
	 * Draws the Inventory
	 * @param marker the PApplet on which the displayed element is drawn
	 */
	public void draw(PApplet marker) {
		marker.noStroke();
		marker.rect(getX(), getY(), getWidth(), getHeight());
		marker.fill(255);
		marker.stroke(0);

		marker.pushStyle();
			marker.fill(0);
			marker.text("** INVENTORY ********", this.getX()+10, this.getY()+40);	
			marker.text("x"+maskCount+" masks", this.getX() +80, this.getY() +80);
				PImage m = marker.loadImage("images/mask.png");
				m.resize(35,0);
				marker.image(m, this.getX() +10, this.getY() + 60);
			marker.text("x"+ infectedCount+" infected", this.getX() +80, this.getY() + 120);
				PImage i = marker.loadImage("images/infected.png");
				i.resize(35,0);
				marker.image(i, this.getX() +10, this.getY() + 100);
			marker.text("x"+ doctorCount+" doctor", this.getX() +80, this.getY() + 160);
				PImage d = marker.loadImage("images/doctor.png");
				d.resize(35,0);
				marker.image(d, this.getX() +10, this.getY() + 140);
			marker.text("x"+ researcherCount+" researcher", this.getX() +80, this.getY() + 200);	
				PImage r = marker.loadImage("images/researcher.png");
				r.resize(35,0);
				marker.image(r, this.getX() +10, this.getY() + 180);
		marker.popStyle();
		
	}
	
	public void update(Player p, Tier t) {
		inventory = p.getInventory();
		maskCount = inventory[0];
		infectedCount = inventory[1];
		doctorCount = inventory[2];
		researcherCount = inventory[3];
	}
	
}