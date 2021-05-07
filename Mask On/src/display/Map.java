package display;

import processing.core.PApplet;

/**
 * The Map class is a Display which represents the map of California and boxes which are both interactive. 
 * @author roshnibright
 */
public class Map extends Display {
	
	private char color;
	
	/**
	 * 
	 * @param x top left X coordinate
	 * @param y top left Y coordinate
	 * @param width map width
	 * @param height map height
	 */
	public Map(double x, double y, double width, double height) {
		super(x, y, width, height);
		//w for blank
		color = 'w';
	}

	/**
	 * Draws the map of California using images and the rectangles which serve as buttons
	 * marker the PApplet on which the Map is drawn
	 */
	public void draw(PApplet marker) {
		marker.pushStyle();
		if (color == 'w') {
			marker.image(marker.loadImage("images/map.png"), getX(), getY(), getWidth(), getHeight());
		}
		else if (color == 'y') {
			marker.image(marker.loadImage("images/yellowmap.png"), getX(), getY(), getWidth(), getHeight());
		}
		else if (color == 'o') {
			marker.image(marker.loadImage("images/orangemap.png"), getX(), getY(), getWidth(), getHeight());
		}
		else if (color == 'r') {
			marker.image(marker.loadImage("images/redmap.png"), getX(), getY(), getWidth(), getHeight());
		}
		else if (color == 'p') {
			marker.image(marker.loadImage("images/purplemap.png"), getX(), getY(), getWidth(), getHeight());
		}
		
		//circles and rectangles on map
		marker.fill(255, 255, 0);
		marker.circle(getX() + getWidth()/4, getY() + getHeight()/6.5F, 12);
		marker.rect(getX() + getWidth()/2, getY(), getWidth()/4 - 5, 30);
		marker.fill(0);
		marker.text('Y', getX() + getWidth()/2 + 16, getY() + 22);
		
		marker.fill(255, 127.5F, 0);
		marker.circle(getX() + 3 * getWidth()/8, getY() + 5.8F * getHeight()/11, 12);
		marker.rect(getX() + 3 * getWidth()/4, getY(), getWidth()/4 - 5, 30);
		marker.fill(0);
		marker.text('O', getX() + getWidth()/2 + 65, getY() + 22);

		marker.fill(255, 0, 0);
		marker.circle(getX() + getWidth()/2, getY() + 5 * getHeight()/9, 12);
		marker.rect(getX() + getWidth()/2, getY() + 35, getWidth()/4 - 5, 30);
		marker.fill(0);
		marker.text('R', getX() + getWidth()/2 + 16, getY() + 57);
		
		marker.fill(200, 50, 200);
		marker.circle(getX() + 4 * getWidth()/7, getY() + 3.2F * getHeight()/5, 12);
		marker.rect(getX() + 3 * getWidth()/4, getY() + 35, getWidth()/4 - 5, 30);
		marker.fill(0);
		marker.text('P', getX() + getWidth()/2 + 65, getY() + 57);
		
		marker.popStyle();
	}
	
	/**
	 * Changes the color of the Map based on coordinates
	 * @param x the x-coordinate of the location that the user clicked
	 * @param y the y-coordinate of the location that the user clicked
	 * @return whether or not the map is changed
	 */
	public boolean changeMap(int x, int y) {
		
		boolean changed = false;
		//yellow
		if ((Math.pow((x - (getX() + getWidth()/4)), 2) + Math.pow(((getY() + getHeight()/6.5F) - y), 2) < 36)
				|| Display.insideRect(x, y, getX() + getWidth()/2, getY(), getWidth()/4 - 5, 30)) {
			if (color == 'y') {
				color = 'w';
			}
			else {
				color = 'y';
			}
			changed = true; 
		}
		//orange
		if ((Math.pow((x - (getX() + 3 * getWidth()/8)), 2) + Math.pow((y - (getY() + 5.8F * getHeight()/11)), 2) < 36)
				|| Display.insideRect(x, y, getX() + 3 * getWidth()/4, getY(), getWidth()/4 - 5, 30)) {
			if (color == 'o') {
				color = 'w';
			}
			else {
				color = 'o';
			}
			changed = true; 
		}
		//red
		if ((Math.pow((x - (getX() + getWidth()/2)), 2) + Math.pow((y - (getY() + 5 * getHeight()/9)), 2) < 36)
				|| Display.insideRect(x, y, getX() + getWidth()/2, getY() + 35, getWidth()/4 - 5, 30)) {
			if (color == 'r') {
				color = 'w';
			}
			else {
				color = 'r';
			}
			changed = true; 
		}
		//purple
		if ((Math.pow((x - (getX() + 4 * getWidth()/7)), 2) + Math.pow((y - (getY() + 3.2F * getHeight()/5)), 2) < 36)
				|| Display.insideRect(x, y, getX() + 3 * getWidth()/4, getY() + 35, getWidth()/4 - 5, 30)) {
			if (color == 'p') {
				color = 'w';
			}
			else {
				color = 'p';
			}
			changed = true; 
		}
		return changed;
	}
	
	/**
	 * 
	 * @return a character which represents the selected Color
	 */
	public char getColor() {
		return color;
	}
	
}