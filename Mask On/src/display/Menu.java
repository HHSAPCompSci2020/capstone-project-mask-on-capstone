package display;
import java.awt.Color;

import processing.core.PApplet;

public class Menu extends Display {
	
	private boolean isOpen;
	
	public Menu(double x, double y, double width, double height, int strokeWeight, Color strokeColor, Color fillColor) {
		super(x, y, width, height, strokeWeight, strokeColor, fillColor);
		isOpen = true;
	}

	public void draw(PApplet marker) {
		marker.pushStyle();
		
		if (isOpen) {
			//close box
			marker.fill(255, 0, 0);
			marker.rect(getX(), getY(), getWidth(), getHeight());
			marker.stroke(255, 255, 255);
			marker.strokeWeight(5);
			marker.line(getX() + getWidth()/5, getY() + getHeight()/5, getX() + 4 * getWidth()/5, getY() + 4 * getHeight()/5);
			marker.line(getX() + 4 * getWidth()/5, getY() + getHeight()/5, getX() + getWidth()/5, getY() + 4 * getHeight()/5);
			
			//instructions
			marker.fill(getFillColor().getRGB());
			marker.stroke(getStrokeColor().getRGB());
			marker.strokeWeight(getStrokeWeight());
			marker.rect(1000/15, 3 * 750/20, 13 * 1000/15, 3 * 750/4);
			marker.fill(0);
			marker.text("Menu!", 1000/15, 3 * 750/20, 13 * 1000/15, 3 * 750/4);
		}
		else {
			marker.fill(getFillColor().getRGB());
			marker.stroke(getStrokeColor().getRGB());
			marker.strokeWeight(getStrokeWeight());
			
			//box
			marker.rect(getX(), getY(), getWidth(), getHeight());
			//lines
			marker.rect(getX() + getWidth()/8, getY() + 2 * getHeight()/7, 3 * getWidth()/4, 1);
			marker.rect(getX() + getWidth()/8, getY() + getHeight()/2, 3 * getWidth()/4, 1);
			marker.rect(getX() + getWidth()/8, getY() + 5 * getHeight()/7, 3 * getWidth()/4, 1);
		}

		marker.popStyle();
	}
	
	public void openClose() {
		isOpen = !isOpen;
	}
	
	public boolean state() {
		return isOpen;
	}
	
	public void setWidth(double width) {
		super.setWidth(width);
		super.setHeight(width);
	}
	
}