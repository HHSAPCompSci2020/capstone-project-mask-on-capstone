package display;

import processing.core.PApplet;
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
	public Inventory(double x, double y, double width, double height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * Draws the Inventory
	 * @param marker the PApplet on which the displayed element is drawn
	 */
	public void draw(PApplet marker) {
		marker.noStroke();
		marker.rect(getX(), getY(), getWidth(), getHeight());
		marker.fill(255,0,0);
	
		marker.fill(255);

		marker.stroke(0);
		
	}
	
}