package mathGraphics;

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
	public int width, numVerticalLEDs;  // Grid size
	public boolean showIncrement = false;
	private int increment;
	Color leds[][];  // An array of arrays of Color. AKA a 2-dimensional field of colors or "LEDs"
    public LEDGrid(Dimension dimension) {
    	// The LED Grid requires at least one LED in each direction.
    	if( dimension.width < 1 ) { 
    		width = 1;
    	}
    	else width = dimension.width;
    	if( dimension.height < 1) {
    		numVerticalLEDs = 1;
    	}
    	else numVerticalLEDs   = dimension.height;
    	// Color object creation patters for an array of arrays.
    	leds = new Color[width][numVerticalLEDs];
    	int i, j;
    	for( i = 0; i < width; i++ ) {
    		for( j = 0; j < numVerticalLEDs; j++ ) {
    			leds[i][j] = new Color(0, 0, 0);
    		}
    	}
    	setMinimumSize(dimension);
    }
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
    	int w = getWidth() /  width;    	
    	int h = getHeight() / numVerticalLEDs;
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
    }
}