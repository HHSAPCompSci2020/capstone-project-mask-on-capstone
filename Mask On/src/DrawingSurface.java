import java.awt.event.KeyEvent;

import display.CovidTracker;
import display.Map;
import display.Menu;
import display.Tier;
import processing.core.PApplet;
import tiers.YellowTier;

import java.awt.Color;

public class DrawingSurface extends PApplet {
	
	private Menu menu;
	private Map map;
	private CovidTracker tracker;
	private Tier tier;
	
	public DrawingSurface() {
		menu = new Menu(900, 650/15, 650/15, 650/15, 0, new Color(0), new Color(255, 255, 255, 220));
		map = new Map(700, 3 * 650/20, 200, (1102/900) * 200);
		tracker = new CovidTracker(675, 19 * 650/20, 240, (1102/900) * 20);
		tier = new Tier(50, 50, 600, 600, 1, new Color(0), new Color(255, 255, 255));
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
				
		/*int n = 40;
		int x = 15;
		for(int i=0; i<x; i++) {
			for (int j=0; j<x; j++) {
				square(x+n*i,x+n*j,n);
			}
		}
		image(loadImage("images/HazmatMan.png"),x,x, n, n);
		image(loadImage("images/doctor.png"),x+n,x+n, n, n);
		image(loadImage("images/uninfectedMasked.png"),x+2*n,x+2*n, n, n);
		image(loadImage("images/uninfectedUnmasked.png"),x+3*n,x+3*n, n, n);
		image(loadImage("images/infected.png"),x+4*n,x+4*n, n, n);
		image(loadImage("images/researcher.png"),x+5*n,x+5*n, n, n);*/
		
		//map
		map.draw(this);
		
		//tier
		if (map.getColor() != 'w') {
			tier.draw(this);
		}
		
		//menu
		//last because if opened it should appear above others
		menu.draw(this);
		tracker.draw(this);
	}
	
	public void keyPressed() {
		tracker.update(tier);
	}
	
	public void mousePressed() {
		if (mouseX > menu.getX() && mouseY > menu.getY()
				&& mouseX < menu.getX() + menu.getWidth() && mouseY < menu.getY() + menu.getHeight()) {
			menu.openClose();
		}
		if (!menu.state()) {
			boolean changed = map.changeMap(mouseX, mouseY);
			if (changed) {
				if (map.getColor() == 'y') {
					//tier = new YellowTier();
				}
				if (map.getColor() == 'o') {
					//tier = new OrangeTier();
				}
				if (map.getColor() == 'r') {
					//tier = new RedTier();
				}
				if (map.getColor() == 'p') {
					//tier = new PurpleTier;
				}
			}
		}
	}
}