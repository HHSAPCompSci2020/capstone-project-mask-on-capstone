package display;
import java.awt.Color;

import processing.core.PApplet;

public class Menu extends Display {
	
	private boolean isOpen;

	public Menu(double x, double y, double width, double height) {
		super(x, y, width, height);
		isOpen = false;
	}
	
	public Menu(double x, double y, double width, double height, int strokeWeight, Color strokeColor, Color fillColor) {
		super(x, y, width, height, strokeWeight, strokeColor, fillColor);
		isOpen = false;
	}

	public void draw(PApplet marker) {
		marker.pushStyle();
		marker.fill(getFillColor().getRGB());
		marker.stroke(getStrokeColor().getRGB());
		marker.strokeWeight(getStrokeWeight());
		//box
		marker.rect(getX(), getY(), getWidth(), getHeight());
		//lines
		marker.rect(getX() + getWidth()/8, getY() + 2 * getHeight()/7, 3 * getWidth()/4, 1);
		marker.rect(getX() + getWidth()/8, getY() + getHeight()/2, 3 * getWidth()/4, 1);
		marker.rect(getX() + getWidth()/8, getY() + 5 * getHeight()/7, 3 * getWidth()/4, 1);
		
		if (isOpen) {
			marker.rect(marker.width/15, 3 * marker.height/20, 13 * marker.width/15, 3 * marker.height/4);
		}

		marker.popStyle();
	}
	
	public void openClose() {
		isOpen = !isOpen;
	}
	
	public void setWidth(double width) {
		super.setWidth(width);
		super.setHeight(width);
	}
	
}