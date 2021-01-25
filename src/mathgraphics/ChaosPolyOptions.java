package mathgraphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ChaosPolyOptions extends OptionPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2462036980524333807L;
	
	
	private JPanel presetPanel;
	private JLabel presetLabel;
	private JComboBox<Presets> presetBox;
	private JPanel sidesPanel;
	private JLabel sidesLabel;
	private JPanel iterationsPanel;
	private JLabel iterationsLabel;
	private JTextField iterationsField;
	private JTextField sidesField;
	private VertexRestrictionsPanel v1Panel;
	private VertexRestrictionsPanel v2Panel;
	private JPanel equalPanel;
	private JRadioButton andButton;
	private JRadioButton orButton;
	private ButtonGroup equalBGroup;
	private JPanel colorPanel;
	JPanel cLabelPanel;
	JPanel cBoxPanel;
	private JLabel coldLabel;
	private JLabel warmLabel;
	private JLabel hotLabel;
	private JComboBox<String> coldColorBox;
	private JComboBox<String> warmColorBox;
	private JComboBox<String> hotColorBox;
	
	public ChaosPolyOptions() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		//preset Panel
		
		
		presetPanel = new JPanel();
		presetLabel = new JLabel("Preset:");
		presetPanel.setLayout(new BoxLayout(presetPanel, BoxLayout.LINE_AXIS));
		presetLabel.setAlignmentX(LEFT_ALIGNMENT);
		presetBox = new JComboBox<>(Presets.values());
		presetBox.setPreferredSize(new Dimension(50,20));
		presetBox.setSelectedIndex(0);
		presetPanel.add(presetLabel);
		presetPanel.add(presetBox);
		presetBox.addActionListener(e -> {
			setOptions(((Presets)presetBox.getSelectedItem()).getOptions());
		});
		
		//numSides Panel
		sidesPanel = new JPanel();
		sidesLabel = new JLabel("# of Sides");
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
		sidesPanel.add(Box.createRigidArea(new Dimension(11,0)));
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
		
		//Iterations Panel
		iterationsPanel = new JPanel();
		iterationsLabel = new JLabel("# of Iterations");
		iterationsPanel.setLayout(new BoxLayout(iterationsPanel, BoxLayout.LINE_AXIS));
		iterationsLabel.setAlignmentY(CENTER_ALIGNMENT);
		iterationsField = new JTextField();
		iterationsField.setAlignmentX(RIGHT_ALIGNMENT);
		iterationsField.setPreferredSize(new Dimension(78,20));
		iterationsField.setMaximumSize(new Dimension(140, 20));
		iterationsField.setText("10000000");
		iterationsPanel.add(iterationsLabel);
//		minSize = new Dimension(20, 20);
//		prefSize = new Dimension(20, 20);
//		maxSize = new Dimension(20, 20);
//		iterationsPanel.add(new Box.Filler(minSize, prefSize, maxSize));
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
		
		//ColorBox Panel
		colorPanel = new JPanel();
		cLabelPanel = new JPanel();
		cBoxPanel = new JPanel();
		colorPanel.setLayout(new BoxLayout(colorPanel, BoxLayout.LINE_AXIS));
		cLabelPanel.setLayout(new BoxLayout(cLabelPanel, BoxLayout.PAGE_AXIS));
		cBoxPanel.setLayout(new BoxLayout(cBoxPanel, BoxLayout.PAGE_AXIS));
		coldColorBox = new JComboBox<>(COLOR_STRINGS);
		warmColorBox = new JComboBox<>(COLOR_STRINGS);
		hotColorBox = new JComboBox<>(COLOR_STRINGS);
		coldColorBox.setSelectedIndex(2);
		warmColorBox.setSelectedIndex(0);
		hotColorBox.setSelectedIndex(5);
		coldLabel = new JLabel("Cold Color");
		warmLabel = new JLabel("Warm Color");
		hotLabel = new JLabel("Hot Color");
		cLabelPanel.add(coldLabel);
		cLabelPanel.add(Box.createRigidArea(new Dimension(0,5)));
		cLabelPanel.add(warmLabel);
		cLabelPanel.add(Box.createRigidArea(new Dimension(0,5)));
		cLabelPanel.add(hotLabel);
		cBoxPanel.add(coldColorBox);
		cBoxPanel.add(warmColorBox);
		cBoxPanel.add(hotColorBox);
		colorPanel.add(cLabelPanel);
		colorPanel.add(Box.createRigidArea(new Dimension(50,0)));
		colorPanel.add(cBoxPanel);
		colorPanel.add(Box.createRigidArea(new Dimension(11,0)));
		
		//Vertex Restriction Panels
		v1Panel = new VertexRestrictionsPanel("V\u2081");//v1 options
		v2Panel = new VertexRestrictionsPanel("V\u2082");//v2 options
		
		equalPanel = new JPanel();
		equalPanel.setLayout(new BoxLayout(equalPanel, BoxLayout.LINE_AXIS));
		andButton = new JRadioButton("And");
		orButton = new JRadioButton("Or");
		orButton.setSelected(true);
		equalBGroup = new ButtonGroup();
		equalBGroup.add(andButton);
		equalBGroup.add(orButton);
		equalPanel.add(Box.createHorizontalGlue());
		equalPanel.add(andButton);
		equalPanel.add(Box.createRigidArea(new Dimension(5,0)));
		equalPanel.add(orButton);
		equalPanel.add(Box.createRigidArea(new Dimension(11,0)));
		
		add(presetPanel);
		add(sidesPanel);
		add(iterationsPanel);
		add(colorPanel);
		add(v1Panel);
		add(Box.createRigidArea(new Dimension(0,5)));
		add(equalPanel);
		add(v2Panel);
		setVisible(true);
	}
	
	@Deprecated
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
		options.equal = andButton.isSelected();
		options.colors = new Color[] { 			//While the color comboBoxes are type String, the COLOR[] field supplied by Options.class has identical index values
				COLORS[coldColorBox.getSelectedIndex()],
				COLORS[warmColorBox.getSelectedIndex()],
				COLORS[hotColorBox.getSelectedIndex()]
		};
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
			andButton.setSelected(options.equal);
			v1Panel.setRestrictions(options.restrictions[0]);
			v2Panel.setRestrictions(options.restrictions[1]);
		} catch (NullPointerException e){
			JOptionPane.showMessageDialog(null, "That preset is incompatible with this design.");
		}
	}

}