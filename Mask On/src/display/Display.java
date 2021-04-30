package display;

import processing.core.PApplet;
import java.awt.Color;

public abstract class Display {
	private float x;
	private float y;
	private float width;
	private float height;
	private int strokeWeight;
	private Color strokeColor;
	private Color fillColor;
	
	public Display(double x, double y, double width, double height) {
		this.x = (float) x;
		this.y = (float) y;
		this.width = (float) width;
		this.height = (float) height;
		strokeColor = new Color(0, 0, 0);
		strokeWeight = 1;
		fillColor = new Color(255, 255, 255);
	}
	
	public Display(double x, double y, double width, double height, int strokeWeight, Color strokeColor, Color fillColor) {
		this.x = (float) x;
		this.y = (float) y;
		this.width = (float) width;
		this.height = (float) height;
		this.strokeColor = strokeColor;
		this.strokeWeight = strokeWeight;
		this.fillColor = fillColor;
	}
	
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