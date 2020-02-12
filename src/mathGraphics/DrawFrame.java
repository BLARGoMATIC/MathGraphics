package mathGraphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;

public class DrawFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7835202908244170085L;
	/**
	 * Integer identifier for pattern to draw: 
	 * 1 = Circle Wrap, 2 = Tree, 3 = Square Fractal, 4 = circle Fractal, 5 = Chaos Triangle, 6 = Chaos Pentagon
	 */
	int pattern;
	/**
	 * Integer Array of arguments for the selected pattern to draw. Should have already been check that all elements are indeed integers.
	 */
	int[] args;
	/**
	 * Array of VertexRestrictions, each represents a set a restrictions for choosing a vertex relative to past chosen vertices.
	 */
	VertexRestrictions[] restrictions;
	/**
	 * 
	 */
	private DrawPatterns dp;
	/**
	 * 
	 */
	private LEDGrid grid;
	
	/**
	 * @param pattern	Pattern to draw. 1 = Circle Wrap, 2 = Tree, 3 = Square Fractal, 4 = circle Fractal, 5 = Chaos Triangle, 6 = Chaos Pentagon
	 * @param args		Arguments for the selected pattern
	 */
	public DrawFrame(int pattern, int[] args, VertexRestrictions[] restrictions, String designName) {
		this.pattern = pattern;
		this.args = args;
		this.restrictions = restrictions;
		grid = new LEDGrid(800, 800);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle(designName);
		add(grid);
		setMinimumSize(new Dimension(800+16,800+39));
		pack();
//		setSize(500 + 16,  // Add side borders
//				500 + 39); // Add title bar and bottom  border     
		grid.setVisible(true);
		setVisible(true); //TODO Fiddle with placement of this.
		setAlwaysOnTop(true);  //Bring to the front, as .toFront() doesn't always work
		setAlwaysOnTop(false);
//		requestFocus();
//		addFocusListener(new FocusListener() { 
//			
//			@Override
//			public void focusLost(FocusEvent e) { // Closes the design window when focus is lost. This is done to avoid having a billion design windows in the background.
////				dispose();
//			}
//			
//			@Override
//			public void focusGained(FocusEvent e) { // Do nothing
//			}
//		});
		
		dp = new DrawPatterns(grid);
	}
	
	public void draw() {
		switch(pattern) {
		case 5: //Circle Wrap
			Color c1 = Color.RED;
			Color c2 = Color.BLUE;
			boolean showIncrement = false;
				 
				 if(args[1] == 1) c1 = Color.WHITE;
			else if(args[1] == 2) c1 = Color.BLACK;
			else if(args[1] == 3) c1 = Color.RED;
			else if(args[1] == 4) c1 = Color.GREEN;
			else if(args[1] == 5) c1 = Color.BLUE;
			else if(args[1] == 6) c1 = Color.MAGENTA;
			else if(args[1] == 7) c1 = Color.ORANGE;
			else if(args[1] == 8) c1 = Color.YELLOW;
			
				 if(args[2] == 1) c2 = Color.WHITE;
			else if(args[2] == 2) c2 = Color.BLACK;
			else if(args[2] == 3) c2 = Color.RED;
			else if(args[2] == 4) c2 = Color.GREEN;
			else if(args[2] == 5) c2 = Color.BLUE;
			else if(args[2] == 6) c2 = Color.MAGENTA;
			else if(args[2] == 7) c2 = Color.ORANGE;
			else if(args[2] == 8) c2 = Color.YELLOW;
				 
			if(args[3] == 0) showIncrement = false;
			else showIncrement = true;
			dp.circleAnimation(args[0], c1, c2, showIncrement);
			grid.repaint();
			break;
		case 2:	//Tree
			dp.tree(args[0], args[1], (double)args[2], Math.toRadians((double)args[3]), Math.toRadians((double)args[4]));
			break;
		case 3:	//Square Fractal
			dp.squareFractal(args[0], args[1], args[2], Math.toRadians((double)args[3]));
			break;
		case 4:	//Circle Fractal
			c1 = Color.BLUE;
			c2 = Color.RED;
				 
				 if(args[3] == 1) c1 = Color.WHITE;
			else if(args[3] == 2) c1 = Color.BLACK;
			else if(args[3] == 3) c1 = Color.RED;
			else if(args[3] == 4) c1 = Color.GREEN;
			else if(args[3] == 5) c1 = Color.BLUE;
			else if(args[3] == 6) c1 = Color.MAGENTA;
			else if(args[3] == 7) c1 = Color.ORANGE;
			else if(args[3] == 8) c1 = Color.YELLOW;
			
				 if(args[4] == 1) c2 = Color.WHITE;
			else if(args[4] == 2) c2 = Color.BLACK;
			else if(args[4] == 3) c2 = Color.RED;
			else if(args[4] == 4) c2 = Color.GREEN;
			else if(args[4] == 5) c2 = Color.BLUE;
			else if(args[4] == 6) c2 = Color.MAGENTA;
			else if(args[4] == 7) c2 = Color.ORANGE;
			else if(args[4] == 8) c2 = Color.YELLOW;
			
			dp.circleFractal((double)args[0], (double)args[1], (double)args[2], c1, c2);
			break;
		case 0: //Chaos Polygon
			dp.chaosPolygon(args[0], args[1], restrictions);
			break;
		default:
			break;
		}
	}

}
