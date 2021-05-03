import java.awt.event.KeyEvent;
import display.Map;
import display.Menu;
import processing.core.PApplet;
import java.awt.Color;

public class DrawingSurface extends PApplet {
	
	private Menu menu;
	private Map map;
	
	public DrawingSurface() {
		menu = new Menu(900, 650/15, 650/15, 650/15, 0, new Color(0), new Color(255, 255, 255));
		map = new Map(700, 3 * 650/20, 200, (1102/900) * 200);
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
		map.draw(this);
		
		//menu
		//last because if opened it should appear above others
		menu.draw(this);
	}
	
	public void keyPressed() {
		
	}
	
	public void mousePressed() {
		if (mouseX > menu.getX() && mouseY > menu.getY()
				&& mouseX < menu.getX() + menu.getWidth() && mouseY < menu.getY() + menu.getHeight()) {
			menu.openClose();
		}
		if (!menu.state()) {
			map.changeMap(mouseX, mouseY);
		}
	}
}