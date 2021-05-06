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
		Location t = getTop();
		Location l = getLeft();
		Location d = getBottom();
		Location r = getRight();
		ArrayList<Location> adjacent = new ArrayList<Location>();
		
		if (t.getCol() >= 0 && t.getCol() < tier.getGrid()[0].length 
				&& t.getRow() >= 0 && t.getRow() < tier.getGrid().length)
			adjacent.add(t);
		if (l.getCol() >= 0 && l.getCol() < tier.getGrid()[0].length 
				&& l.getRow() >= 0 && l.getRow() < tier.getGrid().length)
			adjacent.add(l);
		if (d.getCol() >= 0 && d.getCol() < tier.getGrid()[0].length 
				&& d.getRow() >= 0 && d.getRow() < tier.getGrid().length)
			adjacent.add(d);
		if (r.getCol() >= 0 && r.getCol() < tier.getGrid()[0].length 
				&& r.getRow() >= 0 && r.getRow() < tier.getGrid().length)
			adjacent.add(r);
			
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
		System.out.println("left " + row + "," + (col-1));
		return new Location(row,col-1);
	}
	
	public Location getRight() {
		return new Location(row,col+1);
	}
}