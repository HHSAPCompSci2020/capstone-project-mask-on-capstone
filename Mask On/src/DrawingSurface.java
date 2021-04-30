import java.awt.event.KeyEvent;
import display.Menu;
import processing.core.PApplet;
import java.awt.Color;

public class DrawingSurface extends PApplet {
	
	private Menu menu;
	
	public DrawingSurface() {
		menu = new Menu(200, 200, 200, 200, 0, new Color(0), new Color(255, 255, 255));
	}
	
	public void setup() {
		
	}
	
	public void draw() {
		//background image, from unsplash (https://unsplash.com/photos/HRjdJddvPu8)
		image(loadImage("images/HomeScreen.jpg"), 0, 0);
		pushStyle();
		noStroke();
		fill(0, 75);
		rect(width/20, height/20, 18 * width/20, 18 * height/20);
		popStyle();
		
		//title
		pushStyle();
		textAlign(CENTER);
		textSize(0.02F * width);
		fill(255);
		text("Mask On!", 8 * width/20, 2 * height/30, 4 * width/20, 3 * height/20);
		popStyle();
		
		//map
		
		
		//menu
		//last because if opened it should appear above others
		menu.setX(9 * width/10);
		menu.setY(1 * height/15);
		menu.setWidth(height/15);
		menu.draw(this);
	}
	
	public void keyPressed() {
		
	}
	
	public void mousePressed() {
		if (mouseX > menu.getX() && mouseY > menu.getY()
				&& mouseX < menu.getX() + menu.getWidth() && mouseY < menu.getY() + menu.getHeight()) {
			menu.openClose();
		}
	}
}