import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
/**
 * The Main class represents the start of entire program
 * @author Emily Tumacder, Felicia Zhang, roshnibright
 */
public class Main {
	/**
	 * Creates the window of the program and runs the program
	 * @param args default
	 */
	public static void main(String args[]) {

		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		window.setSize(1000, 750);
		window.setLocationRelativeTo(null);
		window.setMinimumSize(new Dimension(1000, 750));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setTitle("Mask On!");
		window.setVisible(true);
		
	}

}