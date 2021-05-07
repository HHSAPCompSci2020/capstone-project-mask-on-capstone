

import display.Location;
import display.Map;
import display.Menu;
import display.Tier;
import gamecomponents.people.Player;
import processing.core.PApplet;
import java.awt.Color;
import java.awt.event.KeyEvent;


/**
 * The DrawingSurface class draws the components of program on the window and updates them based on user actions
 *
 */
public class DrawingSurface extends PApplet {
	
	private Menu menu;
	private Map map;
	private Tier tier;

	/**
	 * Creates a DrawingSurface, which consists of a menu, map and tiers. 
	 */
	public DrawingSurface() {
		menu = new Menu(900, 650/15, 650/15, 650/15, 0, new Color(0), new Color(255, 255, 255, 220));
		map = new Map(700, 3 * 650/20, 200, (1102/900) * 200);
		tier = new Tier(60, 100, 600, 600, 1, new Color(0), new Color(255, 255, 255));

	}
	
	/**
	 * Sets up the program
	 */
	public void setup() {
		
	}
	
	/**
	 * Draws the components of the program
	 * @pre this method runs with the conditions previously set on the given PApplet
	 */
	public void draw() {
		//background image, from unsplash (https://unsplash.com/photos/HRjdJddvPu8)
		scale(width/1000F, height/750F);
		image(loadImage("images/HomeScreen.jpg"), 0, 0);
		pushStyle();
		noStroke();
		fill(0, 75);
		rect(1000/20, 750/20, 18 * 1000/20, 18 * 750/20);
		popStyle();
		
		//title
		pushStyle();
		textAlign(CENTER);
		textSize(0.02F * 1000);
		fill(255);
		text("Mask On!", 8 * 1000/20, 2 * 750/30, 4 * 1000/20, 3 * 750/20);
		popStyle();
		
		//map
		map.draw(this);
		
		//tier
		if (map.getColor() != 'w') {
			tier.draw(this);
		}
				
		//menu
		//last because if opened it should appear above others
		menu.draw(this);
	}
	
	/**
	 * Updates the menu and map based on the user clicking on certain keys
	 */
	public void keyPressed() {
		if (keyCode == KeyEvent.VK_W){
			if (tier.getPlayer().canMove(tier.getPlayer().getLocation().getTop(tier), tier)) {
				//tier.getPlayer().setDirection('u');
				tier.movePlayer(tier.getPlayer().getLocation().getTop(tier), tier.getPlayer());
			}
		}
		if (keyCode == KeyEvent.VK_A){
			if (tier.getPlayer().canMove(tier.getPlayer().getLocation().getLeft(tier), tier)) {
				//tier.getPlayer().setDirection('u');
				tier.movePlayer(tier.getPlayer().getLocation().getLeft(tier), tier.getPlayer());
			}
		}
		if (keyCode == KeyEvent.VK_S){
			if (tier.getPlayer().canMove(tier.getPlayer().getLocation().getBottom(tier), tier)) {
				//tier.getPlayer().setDirection('u');
				tier.movePlayer(tier.getPlayer().getLocation().getBottom(tier), tier.getPlayer());
			}
		}
		if (keyCode == KeyEvent.VK_D){
			if (tier.getPlayer().canMove(tier.getPlayer().getLocation().getRight(tier), tier)) {
				//tier.getPlayer().setDirection('u');
				tier.movePlayer(tier.getPlayer().getLocation().getRight(tier), tier.getPlayer());
			}
		}
	}
	
	/**
	 * Updates the menu and map based on the user clicking on their mouse
	 */
	public void mousePressed() {
		//DELETE LATER 
			System.out.println("(x,y) = " + mouseX + "," + mouseY);
			
		mouseX *= 1000F/width; mouseY *= 750F/height;
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
	
	public void mouseDragged() {
			
	}

}