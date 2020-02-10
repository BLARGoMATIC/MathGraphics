package mathGraphics;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CircleFracOptions extends OptionPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2739156471732891173L;
	
	JLabel rLabel, xLabel, yLabel;
	JTextField radius, xField, yField;
	JComboBox<String> colorBox1, colorBox2;
	
	public CircleFracOptions() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		rLabel = new JLabel("Radius of First Circle");
		rLabel.setAlignmentX(CENTER_ALIGNMENT);
		radius = new JTextField();
		radius.setText("125");
		radius.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				xField.selectAll();
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				//nothing
			}
			
		});
		
		xLabel = new JLabel("Starting X coordinate");
		xField = new JTextField();
		xLabel.setAlignmentX(CENTER_ALIGNMENT);
		xField.setToolTipText("250 is center");
		xField.setText("250");
		xField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				xField.selectAll();
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				//nothing
			}
			
		});
		yLabel = new JLabel("Starting Y coordinate");
		yLabel.setAlignmentX(CENTER_ALIGNMENT);
		yField = new JTextField();
		yField.setToolTipText("250 is center");
		yField.setText("250");
		yField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				yField.selectAll();
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
		
		add(rLabel);
		add(radius);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(xLabel);
		add(xField);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(yLabel);
		add(yField);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(colorBox1);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(colorBox2);
		setVisible(true);
	}
	
	@Override
	public int[] getArgs() {
		try {

			int[] args = {	Integer.parseInt(radius.getText()),
							Integer.parseInt(xField.getText()),
							Integer.parseInt(yField.getText()),
							colorBox1.getSelectedIndex(), 
							colorBox2.getSelectedIndex()};
			return args;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Only Numbers Please");
			return null;
		}
	}
	@Override
	public String toString() {
		return "Circle Fractal";
	}

	@Override
	public VertexRestrictions[] getRestrictions() {
		return null;
	}

}
