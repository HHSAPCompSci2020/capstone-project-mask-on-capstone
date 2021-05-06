package display;

import processing.core.PApplet;

public class Inventory extends Display{

	public Inventory(double x, double y, double width, double height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(PApplet marker) {
		marker.noStroke();
		marker.rect(getX(), getY(), getWidth(), getHeight());
		marker.fill(255,0,0);
	
		marker.fill(255);

		marker.stroke(0);
		
	}
	
}