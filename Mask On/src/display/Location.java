package display;

import java.util.ArrayList;

public class Location {
	private int row;
	private int col;
	
	public Location(int r, int c) {
		row = r;
		col = c;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setRow(int r) {
		row = r;
	}
	
	public void setCol(int c) {
		col = c;
	}
	
	public ArrayList<Location> getAdjacentLocations() {
		return null;
	}
	
	public Location getTop() {
		return null;
	}
	
	public Location getBottom() {
		return null;
	}
	
	public Location getLeft() {
		return null;
	}
	
	public Location getRight() {
		return null;
	}
}