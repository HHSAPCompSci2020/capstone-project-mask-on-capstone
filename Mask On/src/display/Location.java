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
	//NEED TO CHECK FOR OUT OF BOUNDS LATER
	public Location getTop() {
		return new Location(row-1, col);
	}
	
	public Location getBottom() {
		return new Location(row+1,col);
	}
	
	public Location getLeft() {
		return new Location(row,col-1);
	}
	
	public Location getRight() {
		return new Location(row,col+1);
	}
}