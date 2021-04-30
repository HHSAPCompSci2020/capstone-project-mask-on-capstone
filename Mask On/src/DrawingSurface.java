import java.awt.event.KeyEvent;
import processing.core.PApplet;
import processing.core.PImage;
import java.awt.Color;

public class DrawingSurface extends PApplet {
	
	public DrawingSurface() {
		
	}
	
	public void setup() {
		
	}
	
	public void draw() {
		//background image, from unsplash (https://unsplash.com/photos/HRjdJddvPu8)
		image(loadImage("images/background.jpg"), 0, 0);
		pushStyle();
		noStroke();
		fill(0, 75);
		rect(width/20, height/20, 18 * width/20, 18 * height/20);
		popStyle();
		
		//title
		pushStyle();
		textAlign(CENTER);
		textSize(20);
		fill(255);
		text("Mask On!", 9 * width/20, 2 * height/30, 2 * width/20, 2 * height/20);
		popStyle();
	}
	
	public void keyPressed() {
		
	}
}