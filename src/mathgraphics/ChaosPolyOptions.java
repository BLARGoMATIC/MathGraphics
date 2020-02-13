package mathgraphics;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChaosPolyOptions extends OptionPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2462036980524333807L;
	
	private JTextField iterationsField;
	private JTextField sidesField;
	private VertexRestrictionsPanel v1Panel;
	private VertexRestrictionsPanel v2Panel;
	
	public ChaosPolyOptions() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		JPanel sidesPanel = new JPanel();
		JLabel sidesLabel = new JLabel("# of Sides");
		sidesPanel.setLayout(new BoxLayout(sidesPanel, BoxLayout.LINE_AXIS));
		sidesLabel.setAlignmentY(CENTER_ALIGNMENT);
		sidesField = new JTextField();
		sidesField.setAlignmentX(RIGHT_ALIGNMENT);
		sidesField.setPreferredSize(new Dimension(30,20));
		sidesField.setMaximumSize(new Dimension(30, 20));
		sidesField.setText("5");
		sidesPanel.add(sidesLabel);
		Dimension minSize = new Dimension(20, 20);
		Dimension prefSize = new Dimension(20, 20);
		Dimension maxSize = new Dimension(20, 20);
		sidesPanel.add(new Box.Filler(minSize, prefSize, maxSize));
		sidesPanel.add(Box.createHorizontalGlue());
		sidesPanel.add(sidesField);
		sidesPanel.add(Box.createRigidArea(new Dimension(10,0)));
		sidesField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				sidesField.selectAll();
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				//nothing
			}
		});
		JPanel iterationsPanel = new JPanel();
		JLabel iterationsLabel = new JLabel("# of Iterations");
		iterationsPanel.setLayout(new BoxLayout(iterationsPanel, BoxLayout.LINE_AXIS));
		iterationsLabel.setAlignmentY(CENTER_ALIGNMENT);
		iterationsField = new JTextField();
		iterationsField.setAlignmentX(RIGHT_ALIGNMENT);
		iterationsField.setPreferredSize(new Dimension(80,20));
		iterationsField.setMaximumSize(new Dimension(150, 20));
		iterationsField.setText("1000000");
		iterationsPanel.add(iterationsLabel);
		minSize = new Dimension(20, 20);
		prefSize = new Dimension(20, 20);
		maxSize = new Dimension(20, 20);
		iterationsPanel.add(new Box.Filler(minSize, prefSize, maxSize));
		iterationsPanel.add(Box.createHorizontalGlue());
		iterationsPanel.add(iterationsField);
		iterationsPanel.add(Box.createRigidArea(new Dimension(10,0)));
		iterationsField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				iterationsField.selectAll();
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				//nothing
			}
		});
		v1Panel = new VertexRestrictionsPanel("V\u2081");//v1 options
		v2Panel = new VertexRestrictionsPanel("V\u2082");//v2 options
		
		add(sidesPanel);
		add(iterationsPanel);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(v1Panel);
		add(v2Panel);
		setVisible(true);
	}
	
	public int[] getArgs() {
		return new int[] {
				Integer.parseInt(iterationsField.getText()),
				Integer.parseInt(sidesField.getText())};
	}
	public VertexRestrictions[] getRestrictions() {
		return new VertexRestrictions[] {v1Panel.getRestrictions(), v2Panel.getRestrictions()};
	}

	@Override
	public String toString() {
		return "Chaos Polygon";
	}

	@Override
	public Options getOptions() {
		Options options = super.getOptions();
		options.args = new int[] {
				Integer.parseInt(sidesField.getText()),
				Integer.parseInt(iterationsField.getText())};
		options.restrictions = new VertexRestrictions[] {v1Panel.getRestrictions(), v2Panel.getRestrictions()};
		return options;
	}

	@Override
	public void setOptions(Options options) {
		try {
			sidesField.setText(Integer.toString(options.args[0]));
			iterationsField.setText(Integer.toString(options.args[1]));
			v1Panel.setRestrictions(options.restrictions[0]);
			v2Panel.setRestrictions(options.restrictions[1]);
		} catch (NullPointerException e){
			JOptionPane.showMessageDialog(null, "That preset is incompatible with this design.");
		}
	}

}