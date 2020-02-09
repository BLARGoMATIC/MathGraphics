package mathGraphics;

// A mathGraphics of LEDs for a simple display.
// @author Brian Stafford

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * @author John
 *  LEDGrid is a grid of tiny rectangles each taking up a single pixel, giving me a virtual TV screen.
 */
@SuppressWarnings("serial")
public class LEDGrid extends JPanel {
	//// Member Data
	//
	public int numHorizontalLEDs, numVerticalLEDs;  // Grid size
	public boolean showIncrement = false;
	private int increment;
	Color leds[][];  // An array of arrays of Color.
	                 // Intended to be int values for Red, Green, and Blue.
					 // 0 is black, 255 is the maximum brightness.
	
	//// Ctors
	//
	// Set size of Grid in terms of LEDs.
	//
    public LEDGrid(int _numHorizontalLEDs, int _numVerticalLEDs) {
    	// The mathGraphics requires at least one LED in each direction.
    	if( _numHorizontalLEDs < 1 ) { 
    		numHorizontalLEDs = 1;
    	}
    	else numHorizontalLEDs = _numHorizontalLEDs;
    	if( _numVerticalLEDs < 1) {
    		numVerticalLEDs = 1;
    	}
    	else numVerticalLEDs   = _numVerticalLEDs;
    	
    	// Color object creation patters for an array of arrays.
    	leds = new Color[numHorizontalLEDs][numVerticalLEDs];
    	int i, j;
    	for( i = 0; i < numHorizontalLEDs; i++ ) {
    		for( j = 0; j < numVerticalLEDs; j++ ) {
    			leds[i][j] = new Color(0, 0, 0);
    		}
    	}
    	setPreferredSize(new Dimension(500,500));
    } // END  ctor LEDGrid(horizontal size, vertical size)
    
    /**
	 * @return the showIncrement
	 */
	public boolean isShowIncrement() {
		return showIncrement;
	}

	/**
	 * @param showIncrement Set true if you want increment 'i' to be shown in the drawing.
	 */
	public void setShowIncrement(boolean showIncrement) {
		this.showIncrement = showIncrement;
	}

	//// Methods
    
    public String getIncrement(){
    	String increment = "i = " + this.increment;
    	return increment;
    }
    
    /**
     * @param i Increment for whatever Loop you're drawing
     */
    public void setIncrement(int i) {
    	increment = i;
    }
    
    public void drawIncrement(Graphics g) {
    	g.setColor(Color.WHITE);
    	g.drawString(getIncrement(),5,15);
    }
    @Override
    public void paintComponent(Graphics g)
    {
    	super.paintComponent(g);

    	int w = getWidth() /  numHorizontalLEDs;    	
    	int h = getHeight() / numVerticalLEDs;
//    	int i, j;
//    	
//    	for( i = 0; i < numHorizontalLEDs; i++ ) {
//    		for( j = 0; j < numVerticalLEDs; j++ ) {
//    			g.setColor(leds[i][j]);
//    			g.fillRect(i * w, j * h, w, h);
//    		}
//    	}
    	int i = 0;
    	for( Color[] led1 : leds) {
    		int j = 0;
    		for( Color led2 : led1) {
    			g.setColor(led2);
    			g.fillRect(i * w, j * h, w, h);
    			j++;
    		}
    		i++;
    	}
    	if(showIncrement) drawIncrement(g);
    } // END  paintComponent()
} // END  class LEDGrid