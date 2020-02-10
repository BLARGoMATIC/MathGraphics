package mathGraphics;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TreeOptions extends OptionPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5617933258020164841L;

	JTextField sizeField, xField, yField, rotation, branch;
	
	public TreeOptions() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JLabel sizeLabel = new JLabel("Length of First Branch");
		sizeLabel.setAlignmentX(CENTER_ALIGNMENT);
		sizeField = new JTextField();
		sizeField.setText("75");
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
		JLabel xLabel = new JLabel("Starting X coordinate");
		xLabel.setAlignmentX(CENTER_ALIGNMENT);
		xField = new JTextField();
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
		JLabel yLabel = new JLabel("Starting Y coordinate");
		yLabel.setAlignmentX(CENTER_ALIGNMENT);
		yField = new JTextField();
		yField.setToolTipText("250 is center");
		yField.setText("400");
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
		JLabel rotLabel = new JLabel("Rotation in Degrees");
		rotLabel.setAlignmentX(CENTER_ALIGNMENT);
		rotation = new JTextField();
		rotation.setText("270");
		rotation.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				rotation.selectAll();
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				//nothing
			}
			
		});
		JLabel branchLabel = new JLabel("Branch Spread in degrees");
		branchLabel.setAlignmentX(CENTER_ALIGNMENT);
		branch = new JTextField();
		branch.setText("36"); //36 is the standard position, and looks the nicest
		branch.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				branch.selectAll();
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				//nothing
			}
			
		});
		
		add(sizeLabel);
		add(sizeField);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(xLabel);
		add(xField);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(yLabel);
		add(yField);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(rotLabel);
		add(rotation);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(branchLabel);
		add(branch);
		setVisible(true);
	}
	@Override
	public int[] getArgs() {
		try {
			
			int[] args = {	Integer.parseInt(xField.getText()),
							Integer.parseInt(yField.getText()),
							Integer.parseInt(sizeField.getText()),
							Integer.parseInt(rotation.getText()),
							Integer.parseInt(branch.getText())};
			return args;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Only Numbers Please");
			return null;
		}
	}
	@Override
	public String toString() {
		return "Tree Fractal";
	}
	@Override
	public VertexRestrictions[] getRestrictions() {
		return null;
	}

}
