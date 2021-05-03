package display;

import processing.core.PApplet;

public class Map extends Display {
	
	private char color;

	public Map(double x, double y, double width, double height) {
		super(x, y, width, height);
		//w for blank
		color = 'w';
	}

	@Override
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
		
		for (int i = 0; i < 4; i++) {
			drawBox(marker, i);
		}
		
		drawChar(marker, 0, 'Y');
		drawChar(marker, 1, 'O');
		drawChar(marker, 2, 'R');
		drawChar(marker, 3, 'P');
		
		marker.popStyle();
	}
	
	public void changeMap(int x, int y) {
		//yellow
		if (x > getX() && y > getY() + getHeight()
				&& x < getX() + getWidth()/4 - 10 && y < getY() + getHeight() + 30) {
			if (color == 'y') {
				color = 'w';
			}
			else {
				color = 'y';
			}
		}
		//orange
		if (x > getX() + getWidth()/4 && y > getY() + getHeight()
				&& x < getX() + getWidth()/4 + getWidth()/4 - 10 && y < getY() + getHeight() + 30) {
			if (color == 'o') {
				color = 'w';
			}
			else {
				color = 'o';
			}
		}
		//red
		if (x > getX() + 2 * getWidth()/4 && y > getY() + getHeight()
				&& x < getX() + 2 * getWidth()/4 + getWidth()/4 - 10 && y < getY() + getHeight() + 30) {
			if (color == 'r') {
				color = 'w';
			}
			else {
				color = 'r';
			}
		}
		//purple
		if (x > getX() + 3 * getWidth()/4 && y > getY() + getHeight()
				&& x < getX() + 3 * getWidth()/4 + getWidth()/4 - 10 && y < getY() + getHeight() + 30) {
			if (color == 'p') {
				color = 'w';
			}
			else {
				color = 'p';
			}
		}
	}
	
	private void drawBox(PApplet marker, int i) {
		if (i == 3) {
			marker.fill(255, 0, 255);
		}
		else {
			marker.fill(255, 255 - (127.5F * i), 0);
		}
		marker.rect(getX() + i * getWidth()/4, getY() + getHeight(), getWidth()/4 - 10, 30);
	}
	
	private void drawChar(PApplet marker, int i, char c) {
		marker.fill(0);
		marker.text(c, getX() + i * getWidth()/4 + (getWidth()/4 - 10)/3, getY() + getHeight() + 22);
	}
	
}