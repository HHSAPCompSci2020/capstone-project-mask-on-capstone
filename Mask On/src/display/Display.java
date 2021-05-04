package display;

import processing.core.PApplet;
import java.awt.Color;

/**
 * 
 * @author roshnibright
 *
 */
public abstract class Display {
	private float x;
	private float y;
	private float width;
	private float height;
	private int strokeWeight;
	private Color strokeColor;
	private Color fillColor;
	
	/**
	 * 
	 * @param x x-coordinate of the start point
	 * @param y y-coordinate of the start point
	 * @param width width of the displayed element
	 * @param height height of the displayed element
	 */
	public Display(double x, double y, double width, double height) {
		this.x = (float) x;
		this.y = (float) y;
		this.width = (float) width;
		this.height = (float) height;
		strokeColor = new Color(0, 0, 0);
		strokeWeight = 1;
		fillColor = new Color(255, 255, 255);
	}
	
	/**
	 * 
	 * @param x x-coordinate of the start point
	 * @param y y-coordinate of the start point
	 * @param width width of the displayed element
	 * @param height height of the displayed element
	 * @param strokeWeight weight of the stroke to draw the displayed element
	 * @param strokeColor color of the stroke to draw the displayed element
	 * @param fillColor inner color of the displayed element
	 */
	public Display(double x, double y, double width, double height, int strokeWeight, Color strokeColor, Color fillColor) {
		this.x = (float) x;
		this.y = (float) y;
		this.width = (float) width;
		this.height = (float) height;
		this.strokeColor = strokeColor;
		this.strokeWeight = strokeWeight;
		this.fillColor = fillColor;
	}
	
	/**
	 * 
	 * @param clickX the x-coordinate of the location where clicked
	 * @param clickY the y-coordinate of the location where clicked
	 * @param x x-coordinate of the start of the rectangle
	 * @param y y-coordinate of the start of the rectangle
	 * @param width width of the rectangle
	 * @param height height of the rectangle
	 * @return whether the clicked coordinate is inside the given dimensions for a rectangle
	 */
	public static boolean insideRect(float clickX, float clickY, float x, float y, float width, float height) {
		if (clickX > x && clickY > y
				&& clickX < x + width && clickY < y + height) {
			return true;
		}
		return false;
	}
	
	/**
	 * Draws the displayed element
	 * @param marker the PApplet on which the displayed element is drawn
	 */
	public abstract void draw(PApplet marker);
	
	/**
	 * 
	 * @param x x-coordinate of start point
	 */
	public void setX(double x) {
		this.x = (float) x;
	}
	
	/**
	 * 
	 * @param y y-coordinate of start point
	 */
	public void setY(double y) {
		this.y = (float) y;
	}
	
	/**
	 * 
	 * @return x-coordinate of start point
	 */
	public float getX() {
		return x;
	}
	
	/**
	 * 
	 * @return y-coordinate of start point
	 */
	public float getY() {
		return y;
	}
	
	/**
	 * 
	 * @param width width of display
	 */
	public void setWidth(double width) {
		this.width = (float) width;
	}
	
	/**
	 * 
	 * @param height height of display
	 */
	public void setHeight(double height) {
		this.height = (float) height;
	}
	
	/**
	 * 
	 * @return width of display
	 */
	public float getWidth() {
		return width;
	}
	
	/**
	 * 
	 * @return height of display
	 */
	public float getHeight() {
		return height;
	}
	
	/**
	 * 
	 * @param color rgb int color of stroke to draw Shape
	 * @param weight weight of stroke to draw Shape
	 * @param fill fill color of Shape
	 */
	public void setStrokeAndFill(Color color, int weight, Color fill) {
		strokeColor = color;
		strokeWeight = weight;
		fillColor = fill;
	}
	
	/**
	 * 
	 * @return stroke color
	 */
	public Color getStrokeColor() {
		return strokeColor;
	}
	
	/**
	 * 
	 * @return stroke weight
	 */
	public int getStrokeWeight() {
		return strokeWeight;
	}
	
	/**
	 * 
	 * @return fill color
	 */
	public Color getFillColor() {
		return fillColor;
	}
}