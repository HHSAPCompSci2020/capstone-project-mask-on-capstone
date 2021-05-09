package gamecomponents.places;

import java.util.ArrayList;

import display.Location;
import display.Tier;
import processing.core.PApplet;

public class Factory extends Place {
	private double startProduction;
	private boolean isOpen;
	public Factory(ArrayList<Location> locs) {
		super(locs);
		startProduction = System.currentTimeMillis();
	}
	public void draw(PApplet marker, Tier t) {
		double elapsedTime = (System.currentTimeMillis() - startProduction)/1000;
		marker.pushStyle();
		for (Location l : getLocations()) {
			marker.stroke(120);
			marker.square(t.getX() + 40 * l.getCol(), t.getY() + 40 * l.getRow(), 40);
		}
		marker.fill(255);
		marker.textSize(11);
		int x = getLocations().get(0).getCol();
		int y = getLocations().get(0).getRow();
		marker.image(marker.loadImage("images/factory.png"), t.getX()+ 40*x,  t.getY() + 40*y, t.getWidth()*2/15, t.getHeight()*2/15);
		if (elapsedTime >= 30) {
			marker.text("OPEN", t.getX()+ 40*(x+1), t.getY() + 40*(y+1));
			isOpen = true;
		}
		else {
			marker.text("" + (30 - (int)elapsedTime) + "s left", t.getX()+ 40*(x+0.8f), t.getY() + 40*(y+1));
		}
		marker.popStyle();
	}
	public int retrieveMasks() {
		if (isOpen) {
			startProduction = (double)(System.currentTimeMillis());
			isOpen = false;
			return 5;
		}
		return 0;
	}
	public boolean getStatus() {
		return isOpen;
	}
}
