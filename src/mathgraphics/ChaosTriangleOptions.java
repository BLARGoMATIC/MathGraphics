package mathgraphics;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ChaosTriangleOptions extends OptionPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7685755187905813097L;
	JTextField iField;
	
	@Deprecated
	public ChaosTriangleOptions() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JLabel iterations = new JLabel("Number of Iterations");
		iterations.setAlignmentY(CENTER_ALIGNMENT);
		iField = new JTextField();
		iField.setText("50000");
		iField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				iField.selectAll();
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				//nothing
			}
		});
		
		add(iterations);
		add(iField);
		setVisible(true);
	}

	public int[] getArgs() {
		try {
			
			int[] args = {Integer.parseInt(iField.getText())};
			return args;
			
		} catch (NumberFormatException e) {
			
			String entry = "\"" + iField.getText() + "\"" + " is not a number, try again.";
			JOptionPane.showMessageDialog(null, entry);
			return null;
		}
	}
	@Override
	public String toString() {
		return "Chaos Triangle";
	}

	public VertexRestrictions[] getRestrictions() {
		return null;
	}

	@Override
	public void setOptions(Options options) {
		// TODO Auto-generated method stub
		
	}

}
