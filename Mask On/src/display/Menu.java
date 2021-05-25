package display;

import java.awt.Color;
import processing.core.PApplet;
import processing.core.PConstants;

/**
 * The Menu class is a Display that represents the options that the user has regarding the program
 * @author roshnibright
 */
public class Menu extends Display {
	
	private boolean isOpen;
	private char tab;
	private String general;
	private String yellow;
	private String orange;
	private String red;
	private String purple;
	private char playerMode;
	
	/**
	 * 
	 * @param x x-coordinate of the start point
	 * @param y y-coordinate of the start point
	 * @param width width of the Menu
	 * @param height height of the Menu
	 * @param strokeWeight weight of the stroke to draw the Menu
	 * @param strokeColor color of the stroke to draw the Menu
	 * @param fillColor inner color of the Menu
	 */
	public Menu(double x, double y, double width, double height, int strokeWeight, Color strokeColor, Color fillColor) {
		super(x, y, width, height, strokeWeight, strokeColor, fillColor);
		isOpen = true;
		general = "Click on the other tabs to see further rules and images for each tier \n"
				+ "1) OBJECTIVE: Bring the Covid count to 0 in as little time as possible\n" + 
				"	2) KEY BINDS: \"WASD\" to move player, 'Q' to drop a person in your inventory, 'E' to mask people on the board\n" + 
				"	3) PLAYER: Run into people to pick them up. You can hold one person at a time. By running into specific buildings, you can drop people into the building. \n" + 
				"	4) MASKS: Collectables objects you can obtain by running into the factory. You obtain 5 masks every time you visit the factory, which has a cooldown. When masking people, the people will eventually discard their masks. \n" + 
				"	5) HOSPITAL: You can drop infected (red) people off at the hospital by running into it. The people will stay in the hospital until they are cured. \n" + 
				"	6) PRIVATE RESIDENCES: No function, other than being an obstacle.\n" + 
				"	7) COVID COUNT: The bar will increase and decrease based on the Covid count on the board. Try to make the tracker reach 0 (completely white). \n" + 
				"	8) TASK BAR: See what recommended tasks you should complete in order to finish the level.\n" + 
				"	9) INVENTORY: View what you currently have. \n" + 
				"	10) MAP: Click on the circles OR rectangles to visit a county in California, whose respective color relates to their Covid case count (tiers). \n";
		yellow = "Refer to general rules \n"
				+ "Movement Note: The uninfected people move either vertically or horizontally. Infected people move at twice the speed, and when above, below, to "
				+ "the left, or to the right of you, they move away from you.";
		orange = "1) PUBLIC PLACES: Run into these buildings while holding a doctor to convert it into a hospital. \n" + 
				"2) DOCTOR: Run into them to pick them up. Doctors are immune to Covid, and are needed to convert public buildings into hospitals. \n"
				+ "Movement Note: Doctors move along a diagonal on the grid, unlike normal people.";
		red = "1) VACCINE CLINICS: Run into these buildings while holding an uninfected, unvaccinated person to vaccinate them. They will leave the clinic immune to Covid. \n" + 
				"2) VACCINATED PEOPLE: Run into them to pick them up. \n"
				+ "Functionality Note: When regular people run into an open vaccine clinic, they get masked, as the clinic hands out free masks when open.";
		purple = "There’s a new variant of Covid in town! We now need to employ researchers at our vaccine clinics to create a new vaccine. \n" + 
				"1) VACCINE CLINICS: Run into these closed buildings while holding a researcher to employ them. The clinic will open up after the researchers create the vaccine. \n" + 
				"2) RESEARCHER: Run into them to pick them up. Researchers are immune to Covid, and are needed to open up vaccine clinics. \n"
				+ "Movement Note: Researchers move to a random adjacent location, unlike regular people and doctors.";
		tab = 'g';
		playerMode = 'n';
	}
	
	/**
	 * Draws the Menu with the given PApplet
	 * @param marker the PApplet on which the Menu is drawn
	 * @pre this method runs with the conditions previously set on the given PApplet
	 */
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
			
			//instructions box
			marker.fill(getFillColor().getRGB());
			marker.stroke(getStrokeColor().getRGB());
			marker.strokeWeight(getStrokeWeight());
			marker.rect(1000/15, 3 * 750/20, 13 * 1000/15, 3 * 750/4);
			
			//tabs
			marker.strokeWeight(1);
			marker.rect(80, 150, 540, 420);
			marker.rect(100, 120, 100, 30);
			marker.fill(255, 220, 0);
			marker.rect(200, 120, 100, 30);
			marker.fill(255, 127.5F, 0);
			marker.rect(300, 120, 100, 30);
			marker.fill(255, 0, 0);
			marker.rect(400, 120, 100, 30);
			marker.fill(200, 0, 200);
			marker.rect(500, 120, 100, 30);
			marker.fill(0);
			marker.textAlign(PConstants.CENTER, PConstants.CENTER);
			marker.textSize(14);
			marker.text("General", 100, 120, 100, 30);
			marker.text("Yellow Tier", 200, 120, 100, 30);
			marker.text("Orange Tier", 300, 120, 100, 30);
			marker.text("Red Tier", 400, 120, 100, 30);
			marker.text("Purple Tier", 500, 120, 100, 30);
			showTab(marker);
			
			//player accessories
			marker.text("Pick your accessories!", 1000 * 2/3, 150, 200, 40);
			if (playerMode == 'n') {
				marker.image(marker.loadImage("images/bigplayer.png"), 1000 * 2/3, 190, 200, 200);
			}
			else if (playerMode == 'r') {
				marker.image(marker.loadImage("images/bigplayer.png"), 1000 * 2/3, 190, 200, 200);
				marker.image(marker.loadImage("images/bigmouse.png"), 1000 * 2/3, 190, 200, 200);
			}
			else {
				marker.image(marker.loadImage("images/bigplayer.png"), 1000 * 2/3, 190, 200, 200);
				marker.image(marker.loadImage("images/bigcowboy.png"), 1000 * 2/3, 190, 200, 200);
			}
			marker.fill(255, 220, 0);
			marker.rect(1000 * 2/3, 400, 200, 40);
			marker.fill(200);
			marker.rect(1000 * 2/3, 450, 200, 40);
			marker.fill(200, 100, 0);
			marker.rect(1000 * 2/3, 500, 200, 40);
			marker.fill(0);
			marker.text("NORMAL", 1000 * 2/3, 400, 200, 40);
			marker.text("RAT", 1000 * 2/3, 450, 200, 40);
			marker.text("COWBOY", 1000 * 2/3, 500, 200, 40);
			
			//start button that does the same thing as the close box
			marker.fill(255, 220, 0);
			marker.strokeWeight(1);
			marker.rect(430, 600, 140, 40);
			marker.fill(0);
			marker.text("START", 430, 600, 140, 40);
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
	
	/**
	 * Opens or closes the Menu depending on its current state
	 * @param x x-coordinate of the place where the user clicked
	 * @param y y-coordinate of the place where the user clicked
	 */
	public void openClose(int x, int y) {
		if (Display.insideRect(x, y, getX(), getY(), getWidth(), getHeight())
				|| Display.insideRect(x, y, 430, 600, 140, 40)) {
			isOpen = !isOpen;
		}
	}
	
	/**
	 * Changes the tab in the Menu's instructions based on where the user clicked
	 * @param x x-coordinate of the place where the user clicked
	 * @param y y-coordinate of the place where the user clicked
	 */
	public void changeTab(int x, int y) {
		if (Display.insideRect(x, y, 100, 120, 100, 30)) {
			tab = 'g';
		}
		if (Display.insideRect(x, y, 200, 120, 100, 30)) {
			tab = 'y';
		}
		if (Display.insideRect(x, y, 300, 120, 100, 30)) {
			tab = 'o';
		}
		if (Display.insideRect(x, y, 400, 120, 100, 30)) {
			tab = 'r';
		}
		if (Display.insideRect(x, y, 500, 120, 100, 30)) {
			tab = 'p';
		}
	}
	
	/**
	 * Changes the accessory of the Player based on where the user clicked
	 * @param x x-coordinate of the place where the user clicked
	 * @param y y-coordinate of the place where the user clicked
	 */
	public void changePlayer(int x, int y) {
		if (Display.insideRect(x, y, 1000 * 2/3, 400, 200, 40)) {
			playerMode = 'n';
		}
		if (Display.insideRect(x, y, 1000 * 2/3, 450, 200, 40)) {
			playerMode = 'r';
		}
		if (Display.insideRect(x, y, 1000 * 2/3, 500, 200, 40)) {
			playerMode = 'c';
		}
	}
	
	/**
	 * Shows the tab that should be displayed based on which tab the user clicked
	 * @param marker PApplet on which the tab is shown
	 */
	public void showTab(PApplet marker) {
		marker.pushStyle();
		marker.textAlign(PConstants.LEFT, PConstants.TOP);
		marker.textSize(12);
		if (tab == 'g') {
			marker.text(general, 90, 170, 520, 410);
		}
		else if (tab == 'y') {
			marker.text(yellow, 90, 155, 520, 410);
			
			marker.textAlign(PConstants.CENTER, PConstants.CENTER);
			marker.textSize(10);
			
			marker.image(marker.loadImage("images/hospital.png"), 235, 250, 30, 30);
			marker.text("hospital", 200, 280, 100, 20);
			
			marker.image(marker.loadImage("images/factory.png"), 335, 250, 30, 30);
			marker.text("factory", 300, 280, 100, 20);
			
			marker.image(marker.loadImage("images/place.png"), 435, 250, 30, 30);
			marker.text("private place", 400, 280, 100, 20);
			
			marker.image(marker.loadImage("images/uninfectedUnmasked.png"), 135, 320, 30, 30);
			marker.text("unmasked", 100, 350, 100, 20);
			
			marker.image(marker.loadImage("images/uninfectedMasked.png"), 235, 320, 30, 30);
			marker.text("masked", 200, 350, 100, 20);
			
			marker.image(marker.loadImage("images/infected.png"), 335, 320, 30, 30);
			marker.text("infected", 300, 350, 100, 20);
			
			marker.image(marker.loadImage("images/HazmatMan.png"), 435, 320, 30, 30);
			marker.text("you", 400, 350, 100, 20);
			
			marker.image(marker.loadImage("images/HazmatManMask.png"), 535, 320, 30, 30);
			marker.text("you + mask(s)", 500, 350, 100, 20);
		}
		else if (tab == 'o') {
			marker.text(orange, 90, 155, 520, 410);
			
			marker.textAlign(PConstants.CENTER, PConstants.CENTER);
			marker.textSize(10);
			
			marker.image(marker.loadImage("images/publicBuilding.png"), 235, 250, 30, 30);
			marker.text("public place", 200, 280, 100, 20);
			
			marker.image(marker.loadImage("images/doctor.png"), 435, 250, 30, 30);
			marker.text("doctor", 400, 280, 100, 20);
		}
		else if (tab == 'r') {
			marker.text(red, 90, 155, 520, 410);
			
			marker.textAlign(PConstants.CENTER, PConstants.CENTER);
			marker.textSize(10);
			
			marker.image(marker.loadImage("images/vaccine.png"), 235, 250, 30, 30);
			marker.text("vaccine clinic", 200, 280, 100, 20);
			
			marker.image(marker.loadImage("images/vaccinated.png"), 435, 250, 30, 30);
			marker.text("vaccinated", 400, 280, 100, 20);
		}
		else if (tab == 'p') {
			marker.text(purple, 90, 155, 520, 410);
			
			marker.textAlign(PConstants.CENTER, PConstants.CENTER);
			marker.textSize(10);
			
			marker.image(marker.loadImage("images/researcher.png"), 335, 300, 30, 30);
			marker.text("researcher", 300, 330, 100, 20);
		}
		else {
			
		}
		marker.popStyle();
	}
	
	/**
	 * 
	 * @return the state of the Menu
	 */
	public boolean state() {
		return isOpen;
	}
	
	/**
	 * @param width the width to set the dimensions of the Menu to
	 */
	public void setWidth(double width) {
		super.setWidth(width);
		super.setHeight(width);
	}
	
	/**
	 * 
	 * @return the accessory the player has
	 */
	public char getMode() {
		return playerMode;
	}
	
}