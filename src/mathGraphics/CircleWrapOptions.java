package mathGraphics;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CircleWrapOptions extends OptionPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1728404424435183577L;
	
	JTextField sizeField;
	JComboBox<String> colorBox1;
	JComboBox<String> colorBox2;
	JCheckBox showIncrement;
	JLabel sizeLabel;
	
	public CircleWrapOptions() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		sizeLabel = new JLabel("Radius of Largest Circle:");
		sizeLabel.setAlignmentX(CENTER_ALIGNMENT);
		sizeField = new JTextField();
		sizeField.setText("1");
		sizeField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				sizeField.selectAll();
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				//nothing
			}
			
		});
		
		colorBox1 = new JComboBox<String>(COLOR_STRINGS);
		colorBox1.setSelectedIndex(0);
		
		colorBox2 = new JComboBox<String>(COLOR_STRINGS);
		colorBox2.setSelectedIndex(0);
		
		showIncrement = new JCheckBox("Show Increment?");
		showIncrement.setAlignmentX(CENTER_ALIGNMENT);
		
		add(sizeLabel);
		add(sizeField);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(colorBox1);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(colorBox2);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(showIncrement);
		setVisible(true);
		
	}//END Default Constructor
	
	@Override
	public int[] getArgs() {
		
		try {
			int showInc;
			if(showIncrement.isSelected()) showInc = 1;
			else showInc = 0;
			
			int[] args = {	Integer.parseInt(sizeField.getText()), 
							colorBox1.getSelectedIndex(), 
							colorBox2.getSelectedIndex(), 
							showInc};
			return args;
		} catch (NumberFormatException e) {
			
			JOptionPane.showMessageDialog(null, "Only Numbers Please");
			return null;
		}
		
	}
	@Override
	public String toString() {
		return "Circle Wrap Animation";
	}

}
