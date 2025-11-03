package mathgraphics;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
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
public class VertexMaskPanel extends JPanel{ //Can I extend LEDGrid? Do I want to?

	/**
	 * 
	 */
	private static final long serialVersionUID = -1302085671128912513L;
	
	private LEDGrid vertexPanel;
	private List<JRadioButton> vertexButtons;
	private JPanel fieldPanel;
	private JLabel maskLabel;
	private JLabel binaryLabel;
	private JTextField maskField;
	private JTextField binaryField;
	private DrawPatterns dp;
//	private int numSides;
	
	public VertexMaskPanel(int numSides, String title) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		vertexPanel = new LEDGrid(new Dimension(300,300));
		vertexPanel.setPreferredSize(new Dimension(300,300));
		vertexPanel.setShowIncrement(false);
		vertexPanel.setTitleToDraw(title);
		vertexPanel.setDrawTitle(true);
		vertexPanel.setLayout(null);
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
			JRadioButton vertexButton = new JRadioButton();
			vertexButton.setName("" + i);
			vertexButton.addActionListener(a -> {
				updateMaskField();
//				System.out.println(((JRadioButton) (a.getSource())).getName());
			});
			vertexButtons.add(vertexButton);
		}
		
		int k = vertex.length - 1;
		int i = 0;
		for (JRadioButton b : vertexButtons) {
			vertexPanel.add(b);
			i = k % vertex.length;
			b.setBounds(vertex[i].x-10, vertex[i].y-10, 20, 20);
			b.setOpaque(false);
			b.setSelected(true);
			k++;
		}
		dp.addCircle(20, vertex[vertex.length-1].x, vertex[vertex.length-1].y);	//Drawing a circle around vertex 0
		
		
		fieldPanel = new JPanel();
		fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.LINE_AXIS));
		maskLabel = new JLabel("Mask: ");
		maskField = new JTextField();
		maskField.setPreferredSize(new Dimension(60,20));
		maskField.setMaximumSize(new Dimension(60, 20));
		maskField.setText(Integer.toString(getMask()));
		maskField.addActionListener(a -> {
			
			try {
				if(maskField.isFocusOwner() && !maskField.getText().isEmpty()) {
					setMask(Integer.parseInt(maskField.getText()));
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "That's not a number.");
			}	
		});
		maskField.addFocusListener(new FocusListener() {	
			@Override
			public void focusLost(FocusEvent e) {
				//nothing
			}
			@Override
			public void focusGained(FocusEvent e) {
				maskField.selectAll();
			}
		});

		binaryLabel = new JLabel("Mask in Binary: ");
		binaryField = new JTextField();
		binaryField.setPreferredSize(new Dimension(80,20));
		binaryField.setMaximumSize(new Dimension(80, 20));
		binaryField.setText(getMaskBinary());
		binaryField.addActionListener(a -> {
			try{
				if(binaryField.isFocusOwner() && !binaryField.getText().isEmpty()) {
					setMask(Integer.parseInt(binaryField.getText(), 2));
				}
			}	catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Ones and zeroes only bub.");
			}
		});
		
		fieldPanel.add(Box.createHorizontalGlue());
		fieldPanel.add(maskLabel);
		fieldPanel.add(maskField);
		fieldPanel.add(Box.createRigidArea(new Dimension(10,0)));
		fieldPanel.add(binaryLabel);
		fieldPanel.add(binaryField);
		fieldPanel.add(Box.createHorizontalGlue());
		
		
		add(vertexPanel);
		add(Box.createRigidArea(new Dimension(0,5)));
		add(fieldPanel);
		validate();
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
		char[] charMask = new char[vertexButtons.size()];
		int i = 0;
		for (JRadioButton b : vertexButtons) {			//They're backwards from what I want, as its easier to set the mask the other direction.
			charMask[i++] = b.isSelected() ? '1' : '0';	//I need leading and trailing zeros to also get reversed, converting to chars and just reversing the string seems to be the easiest way to do that.
		}
		
		vertexMask = Integer.parseInt(new StringBuilder(new String(charMask)).reverse().toString(), 2); //reverse!
		
		return vertexMask;
	}
	public String getMaskBinary() { //Just like getMask(), but this one gives a string instead for display purposes
		String binaryMask;
		char[] charMask = new char[vertexButtons.size()];
		int i = 0;
		for (JRadioButton b : vertexButtons) {			
			charMask[i++] = b.isSelected() ? '1' : '0';	
		}
		
		binaryMask = new StringBuilder(new String(charMask)).reverse().toString();
		return binaryMask;
	}
	public void setMask(int mask) {
		int i = 1;
		for(JRadioButton b : vertexButtons) {
			b.setSelected(((mask & i) > 0) ? true : false);
			i = i << 1;
		}
	}
	public void setAllButtons(boolean isSelected) {
		for(JRadioButton b : vertexButtons) {
			b.setSelected(isSelected);
		}
	}
	public void invertButtons() {
		for(JRadioButton b : vertexButtons) {
			b.setSelected((b.isSelected() ? false : true));
		}
	}
	public void updateMaskField() {
		maskField.setText(Integer.toString(getMask()));
		binaryField.setText(getMaskBinary());
	}
	
	public void setRestrictions(VertexRestrictions restrictions) {
		
	}
	private int reverse(int i) {	//keeping because I might want it later...
		return Integer.parseInt(new StringBuilder(Integer.toBinaryString(i)).reverse().toString());
	}
}
