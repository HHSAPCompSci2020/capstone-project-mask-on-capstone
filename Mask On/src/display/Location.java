package display;

import java.util.ArrayList;
/**
 * Represents the location of a person in the Tier
 * @author roshnibright
 */
public class Location {
	private int row;
	private int col;
	/**
	 * Creates a Location represented by rows and columns
	 * @param r the row of the Location
	 * @param c the column of the Location
	 */
	public Location(int r, int c) {
		row = r;
		col = c;
	}
	/**
	 * 
	 * @return the row of a Location
	 */
	public int getRow() {
		return row;
	}
	/**
	 * 
	 * @return the column of a Location
	 */
	public int getCol() {
		return col;
	}
	/**
	 * 
	 * @param r row 
	 */
	public void setRow(int r) {
		row = r;
	}
	/**
	 * 
	 * @param c column
	 */
	public void setCol(int c) {
		col = c;
	}
	/**
	 * 
	 * @param tier the Tier that the current Location is in
	 * @return ArrayList(Location) represents all adjacent locations to the current Location
	 */
	public ArrayList<Location> getAdjacentLocations(Tier tier) {

		ArrayList<Location> adjacent = new ArrayList<Location>();
		
		addToArrayList(getTop(tier), adjacent, tier);
		addToArrayList(getLeft(tier), adjacent, tier);
		addToArrayList(getBottom(tier), adjacent, tier);
		addToArrayList(getRight(tier), adjacent, tier);
		addToArrayList(getTopLeft(tier), adjacent, tier);
		addToArrayList(getTopRight(tier), adjacent, tier);
		addToArrayList(getBottomLeft(tier), adjacent, tier);
		addToArrayList(getBottomRight(tier), adjacent, tier);
			
		return adjacent;
		
	}
	//NEED TO CHECK FOR OUT OF BOUNDS LATER
	/**
	 * 
	 * @return the adjacent Location above this Location
	 */
	public Location getTop(Tier t) {
		if (!(new Location(row-1,col).isOutOfBounds(t)))
			return new Location(row-1, col);
		
		return null;
	}
	/**
	 * 
	 * @return the adjacent Location below of this Location
	 */
	public Location getBottom(Tier t) {
		if (!(new Location(row+1,col).isOutOfBounds(t)))
			return new Location(row+1,col);
		
		return null;
	}
	/**
	 * 
	 * @return the adjacent Location to the left of this Location
	 */
	public Location getLeft(Tier t) {
		if (!(new Location(row,col-1).isOutOfBounds(t)))
			return new Location(row,col-1);
		
		return null;
	}
	/**
	 * 
	 * @return the adjacent Location to the right of this Location
	 */
	public Location getRight(Tier t) {
		if (!(new Location(row,col+1).isOutOfBounds(t)))
			return new Location(row,col+1);
		
		return null;
	}
	/**
	 * 
	 * @return the adjacent Location to the top left of this Location
	 */
	public Location getTopLeft(Tier t) {
		if (!(new Location(row-1,col-1).isOutOfBounds(t)))
			return new Location(row-1,col-1);
		
		return null;
	}
	/**
	 * 
	 * @return the adjacent Location to the top right of this Location
	 */
	public Location getTopRight(Tier t) {
		if (!(new Location(row-1,col+1).isOutOfBounds(t)))
			return new Location(row-1,col+1);
		
		return null;
	}
	/**
	 * 
	 * @return the adjacent Location to the bottom left of this Location
	 */
	public Location getBottomLeft(Tier t) {
		if (!(new Location(row+1,col-1).isOutOfBounds(t)))
			return new Location(row+1,col-1);
		
		return null;
	}
	/**
	 * 
	 * @return the adjacent Location to the bottom right of this Location
	 */
	public Location getBottomRight(Tier t) {
		if (!(new Location(row+1,col+1).isOutOfBounds(t)))
			return new Location(row+1,col+1);
		
		return null;
	}
	public boolean isOutOfBounds(Tier t) {
		if (this.row >= t.getGrid().length || this.row < 0 || this.col >= t.getGrid()[0].length || this.col< 0)
			return true;
		
			return false;
	}
	/**
	 * Adds a Location to an ArrayList
	 * @param l the Location that needs to be added to the ArrayList
	 * @param arr the ArrayList to add the Location to 
	 * @param tier the Tier that the Location is in
	 */
	private void addToArrayList(Location l, ArrayList<Location> arr, Tier tier) {
		if(!(l == null))
			if (l.getCol() >= 0 && l.getCol() < tier.getGrid()[0].length 
				&& l.getRow() >= 0 && l.getRow() < tier.getGrid().length)
					arr.add(l);
	}
	
}