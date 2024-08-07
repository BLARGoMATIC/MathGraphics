package mathgraphics;

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
	private int horizontalLEDs;
	private int verticalLEDs;  // Grid size
	private boolean showIncrement = true;
	private int increment = 0;
	private boolean isComplete = false;
	private String titleToDraw = "blank";
	private boolean drawTitle = false;
	
	protected Mark[][] leds;  // An array of arrays of Color. AKA a 2-dimensional field of colors or "LEDs"
    public LEDGrid(Dimension dimension) {
    	// The LED Grid requires at least one LED in each direction.
    	if( dimension.width < 1 ) { 
    		this.horizontalLEDs = 1;
    	}
    	else horizontalLEDs = dimension.width;
    	if( dimension.height < 1) {
    		verticalLEDs = 1;
    	}
    	else verticalLEDs   = dimension.height;
    	// Color object creation patters for an array of arrays.
    	leds = new Mark[horizontalLEDs][verticalLEDs];
    	int i, j;
    	for( i = 0; i < horizontalLEDs; i++ ) {
    		for( j = 0; j < verticalLEDs; j++ ) {
    			leds[i][j] = new Mark(Color.BLACK);
    		}
    	}
    	setMinimumSize(dimension);
    }
    public void clear() {
    	int i, j;
    	for( i = 0; i < horizontalLEDs; i++ ) {
    		for( j = 0; j < verticalLEDs; j++ ) {
    			leds[i][j] = new Mark(Color.BLACK);
    		}
    	}
    }
    public int getHorizontalLEDs() {
		return horizontalLEDs;
	}
	public void setHorizontalLEDs(int horizontalLEDs) {
		this.horizontalLEDs = horizontalLEDs;
	}
	public int getVerticalLEDs() {
		return verticalLEDs;
	}
	public void setVerticalLEDs(int verticalLEDs) {
		this.verticalLEDs = verticalLEDs;
	}
    /**
	 * @return the showIncrement
	 */
	public boolean showIncrement() {
		return showIncrement;
	}
	/**
	 * @param showIncrement Set true if you want increment 'i' to be shown in the drawing.
	 */
	public void setShowIncrement(boolean showIncrement) {
		this.showIncrement = showIncrement;
	}
    public String getIncrement(){
    	return this.increment + "%";
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
    public void setIsComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
    public void drawComplete(Graphics g) {
    	this.setShowIncrement(false);
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, 10, 20);
    	g.setColor(Color.WHITE);
    	g.drawString("Done",5,15);
    }
    public void setDrawTitle(boolean b) {
    	this.drawTitle = b;
    }
    public void setTitleToDraw(String title) {
    	this.titleToDraw = title;
    }
    private void drawTitle(Graphics g) {
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, 10, 20);
    	g.setColor(Color.WHITE);
    	g.drawString(titleToDraw,5,15);
    }
    @Override
    public void paintComponent(Graphics g)
    {
    	int w = getWidth() /  horizontalLEDs;    	
    	int h = getHeight() / verticalLEDs;
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
    	if(isComplete) drawComplete(g);
    	if(drawTitle) drawTitle(g);
    }
}