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
	
	public ArrayList<Location> getAdjacentLocations(Tier tier) {

		ArrayList<Location> adjacent = new ArrayList<Location>();
		
		addToArrayList(getTop(), adjacent, tier);
		addToArrayList(getLeft(), adjacent, tier);
		addToArrayList(getBottom(), adjacent, tier);
		addToArrayList(getRight(), adjacent, tier);
		addToArrayList(getTopLeft(), adjacent, tier);
		addToArrayList(getTopRight(), adjacent, tier);
		addToArrayList(getBottomLeft(), adjacent, tier);
		addToArrayList(getBottomRight(), adjacent, tier);
			
		return adjacent;
		
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
	
	public Location getTopLeft() {
		return new Location(row - 1, col - 1);
	}
	
	public Location getTopRight() {
		return new Location(row - 1, col + 1);
	}
	
	public Location getBottomLeft() {
		return new Location(row + 1, col - 1);
	}
	
	public Location getBottomRight() {
		return new Location(row + 1, col + 1);
	}
	
	private void addToArrayList(Location l, ArrayList<Location> arr, Tier tier) {
		if (l.getCol() >= 0 && l.getCol() < tier.getGrid()[0].length 
				&& l.getRow() >= 0 && l.getRow() < tier.getGrid().length)
			arr.add(l);
	}
}