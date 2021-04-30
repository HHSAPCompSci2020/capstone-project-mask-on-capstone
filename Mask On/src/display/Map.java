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
	}
	
	public void changeColor(char c) {
		color = c;
	}
	
}