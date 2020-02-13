package mathgraphics;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author John
 *	Almost Identical Options to the Tree Fractal: x, y, size, Rotation. Just needs slightly different Handling in DrawFrame.class
 */
public class SquareOptions extends OptionPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1153495885199616853L;
	JTextField sizeField, xField, yField, rotation;
	
	public SquareOptions() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JLabel sizeLabel = new JLabel("Size of First Square");
		sizeLabel.setAlignmentX(CENTER_ALIGNMENT);
		sizeField = new JTextField();
		sizeField.setText("150");
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
		JLabel rotLabel = new JLabel("Rotation in Degrees");
		rotLabel.setAlignmentX(CENTER_ALIGNMENT);
		rotation = new JTextField();
		rotation.setText("0");
		rotation.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				yField.selectAll();
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
		setVisible(true);
	}

	public int[] getArgs() {
		try {

			int[] args = {	Integer.parseInt(xField.getText()),
							Integer.parseInt(yField.getText()),
							Integer.parseInt(sizeField.getText()),
							Integer.parseInt(rotation.getText())};
			return args;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Only Numbers Please");
			return null;
		}
	}
	@Override
	public String toString() {
		return "Square Fractal";
	}

	public VertexRestrictions[] getRestrictions() {
		return null;
	}

	@Override
	public void setOptions(Options options) {
		// TODO Auto-generated method stub
		
	}

}
