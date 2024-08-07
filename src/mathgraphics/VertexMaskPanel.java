package mathgraphics;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * This class exists to make adding multiple vertex controls easier, instead of making the ChaosPolyOptions bloated.
 * @author John
 *
 */
/**
 * @author John
 *
 */
public class VertexMaskPanel extends JPanel { //Can I extend LEDGrid? Do I want to?

	/**
	 * 
	 */
	private static final long serialVersionUID = -1302085671128912513L;
	
	private LEDGrid vertexPanel;
	private List<JRadioButton> vertexButtons;
	private DrawPatterns dp;
//	private int numSides;
	
	public VertexMaskPanel(int numSides, String title) {
		vertexPanel = new LEDGrid(new Dimension(300,300));
		vertexPanel.setPreferredSize(new Dimension(300,300));
		vertexPanel.setShowIncrement(false);
		vertexPanel.setTitleToDraw(title);
		vertexPanel.setDrawTitle(true);
		vertexPanel.setLayout(null);
		vertexPanel.setAlignmentY(BOTTOM_ALIGNMENT);
		dp = new DrawPatterns(vertexPanel, new Options());
				
//		this.numSides = numSides;
		Coordinates[] vertex = new Coordinates[numSides];
		
			//		*************** Math for a regular pentagon ******************
			//Adjusting the rotational offset of the polygon so it's symmetrical along the vertical axis
		{
			double i;
			if (numSides % 2 != 0) {
				i = -Math.PI/(2*numSides);
			}//Even sided polygons are already symmetrical, so there's no need to rotate them.
			else {
				i = 0;
			}//Calculate vertex locations
			for(int k = 0; k < vertex.length; k++) {
				vertex[k] = new Coordinates((int)Math.rint(((2f * numSides / 5)*vertexPanel.getHorizontalLEDs()/numSides)*Math.cos(i))+vertexPanel.getHorizontalLEDs()/(2), 
						(int)Math.rint(((2f * numSides / 5)*vertexPanel.getVerticalLEDs()/numSides)*Math.sin(i))+vertexPanel.getVerticalLEDs()/(2));
				i += 2*Math.PI/numSides;
			}
			for (int k = 0; k <= (numSides-1); ++k) {
				dp.addLine(vertex[k], vertex[Math.floorMod(k+1, numSides)]);
			}
		}
		vertexButtons = new ArrayList<>();
		for (int i = 0; i < numSides; i++) {
			vertexButtons.add(new JRadioButton());
		}
		
		int k = 0;
		for (JRadioButton b : vertexButtons) {
			vertexPanel.add(b);
			b.setBounds(vertex[k].x-10, vertex[k].y-10, 20, 20);
			b.setOpaque(false);
			b.setSelected(true);
			k++;
		}
		dp.addCircle(20, vertex[vertex.length-1].x, vertex[vertex.length-1].y);
		
		add(vertexPanel);
	}
	
	/**
	 * <h2>public int getMask</h2>
	 * <p>
	 * Setting up the bitmask to be used for the vertex restriction<br />
	 * <br />
	 * Cycles through all Radio Buttons in order, it shifts the mask left, and then
	 * adds 1
	 * </p>
	 * <p style="padding-left: 60px;">
	 * 0 0 0 0 0 Radio Button number 1 is not selected&nbsp;<br />
	 * 0 0 0 0 1 &lt;&lt; button 2 is <br />
	 * 0 0 0 1 1 &lt;&lt; button 3 is <br />
	 * 0 0 1 1 1 &lt;&lt; button 4 is <br />
	 * 0 1 1 1 1 &lt;&lt; button 5 is <br />
	 * And this gives us the resulting mask: 01111
	 * </p>
	 * <p>
	 * Which will be interpreted by the drawing program as "do not select the same
	 * vertex twice in a row"<br />
	 * To not select any adjacent vertices the mask would be 10110<br />
	 * <br />
	 * And the mask can grow for as many sides there are
	 * </p>
	 * @return the mask
	 */
	public int getMask() {
		int vertexMask = 0;							
		for (JRadioButton b : vertexButtons) {		
			vertexMask = vertexMask << 1;			
			if(b.isSelected()) 	vertexMask++;		
		}
		return vertexMask;
	}
	public void setRestrictions(VertexRestrictions restrictions) {
		
	}
}
