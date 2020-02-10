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

@Deprecated
public class ChaosPentOptions extends OptionPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2462036980524333807L;
	JTextField iField;
	JComboBox<String> styleBox;
	private static final String[] styleChoices = {
			"Pick a Style",
			"Style 1",
			"Style 2",
			"Style 3",
			"Style 4",
			"Style 5"};
	
	public ChaosPentOptions() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		styleBox = new JComboBox<String>(styleChoices);
		styleBox.setSelectedIndex(0);
		
		JLabel iterations = new JLabel("Number of Iterations");
		iterations.setAlignmentY(CENTER_ALIGNMENT);
		iField = new JTextField();
		iField.setText("1000000");
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
		add(styleBox);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(iterations);
		add(iField);
		setVisible(true);
	}

	@Override
	public int[] getArgs() {
		try {

			int[] args = {	styleBox.getSelectedIndex(),
					Integer.parseInt(iField.getText())};
			return args;

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Only Numbers Please");
			return null;
		}
	}

	@Override
	public String toString() {
		return "Chaos Pentagon";
	}

	@Override
	public VertexRestrictions[] getRestrictions() {
		return null;
	}

}
