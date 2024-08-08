package mathgraphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ChaosPolyNewOptions extends OptionPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7685755187905813097L;
	JTextField iterationsField;
	private JComboBox<String> sidesBox;
	String[] polygons = {
			"Triangle",
			"Square",
			"Pentagon",
			"Hexagon",
			"Septagon",
			"Octagon",
			"Nonagon",
			"Decagon"};	
	private JComboBox<Presets> presetBox;
	private JPanel vertexPanel;
	private VertexMaskPanel cVertexPanel;
	private VertexMaskPanel pVertexPanel;
	private JComboBox<String> equalBox;
	private JButton allButton;
	private JButton noneButton;
	private JPanel vertexMiddlePanel;
	private JPanel iterationsPanel;
	private JLabel iterationsLabel;
	private JPanel drawPolygonPanel;
	private JPanel middlePanel;
	private JCheckBox drawPolygonCheckbox;
	private JLabel drawPolygonLabel;
	private JPanel colorPanel;
	JPanel cLabelPanel;
	JPanel cBoxPanel;
	private JLabel coldLabel;
	private JLabel warmLabel;
	private JLabel hotLabel;
	private JComboBox<String> coldColorBox;
	private JComboBox<String> warmColorBox;
	private JComboBox<String> hotColorBox;
	int numSides;
	
	public ChaosPolyNewOptions() {
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		//Iterations Panel
		iterationsPanel = new JPanel();
		iterationsLabel = new JLabel("# of Iterations");
		iterationsPanel.setLayout(new BoxLayout(iterationsPanel, BoxLayout.LINE_AXIS));
		iterationsLabel.setAlignmentX(RIGHT_ALIGNMENT);
//		iterationsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		iterationsField = new JTextField();
		iterationsField.setAlignmentX(RIGHT_ALIGNMENT);
		iterationsField.setPreferredSize(new Dimension(100,20));
		iterationsField.setMaximumSize(new Dimension(160, 20));
		iterationsField.setText("5000000");
		iterationsField.setHorizontalAlignment(SwingConstants.RIGHT);
		iterationsPanel.add(Box.createHorizontalGlue());
		iterationsPanel.add(Box.createRigidArea(new Dimension(10,0)));
		iterationsPanel.add(iterationsLabel);
		iterationsPanel.add(Box.createRigidArea(new Dimension(12,0)));
		iterationsPanel.add(iterationsField);
		iterationsPanel.add(Box.createHorizontalGlue());
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
		
		drawPolygonPanel = new JPanel();
		drawPolygonLabel = new JLabel("Draw the Polygon?");
		drawPolygonPanel.setLayout(new BoxLayout(drawPolygonPanel, BoxLayout.LINE_AXIS));
		drawPolygonLabel.setAlignmentX(RIGHT_ALIGNMENT);
		drawPolygonCheckbox = new JCheckBox();
		drawPolygonCheckbox.setSelected(false);
		drawPolygonPanel.add(Box.createHorizontalGlue());
		drawPolygonPanel.add(drawPolygonLabel);
		drawPolygonPanel.add(drawPolygonCheckbox);
		
		middlePanel = new JPanel();
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.LINE_AXIS));
		middlePanel.add(Box.createHorizontalGlue());
		middlePanel.add(drawPolygonPanel);
		middlePanel.add(iterationsPanel);
		middlePanel.add(Box.createHorizontalGlue());

		presetBox = new JComboBox<>(Presets.values());
		presetBox.setMaximumSize(new Dimension(200,20));
		presetBox.addActionListener(e -> {
				setOptions(((Presets)presetBox.getSelectedItem()).getOptions());
				System.out.println(((Presets)presetBox.getSelectedItem()).getOptions().args[2] + " " + ((Presets)presetBox.getSelectedItem()).getOptions().args[3]);
//			int nothing = cVertexPanel.getMask();
//			int nothing2 = pVertexPanel.getMask(); //debugging
		});
		sidesBox = new JComboBox<>(polygons);
		sidesBox.setMaximumSize(new Dimension(200,20));
		sidesBox.setSelectedIndex(2);
		sidesBox.addItemListener(e -> {		
				
				vertexPanel.removeAll();
				cVertexPanel = new VertexMaskPanel(sidesBox.getSelectedIndex() + 3, "Current vertex");
				pVertexPanel = new VertexMaskPanel(sidesBox.getSelectedIndex() + 3, "Previous vertex");
				cVertexPanel.setPreferredSize(new Dimension(300,300));
				pVertexPanel.setPreferredSize(new Dimension(300,300));
				vertexPanel.add(cVertexPanel);
				vertexPanel.add(Box.createRigidArea(new Dimension(2,0)));
				vertexPanel.add(vertexMiddlePanel);
				vertexPanel.add(Box.createRigidArea(new Dimension(2,0)));
				vertexPanel.add(pVertexPanel);
				validate();
		});
		vertexPanel = new JPanel();
		vertexPanel.setLayout(new BoxLayout(vertexPanel, BoxLayout.LINE_AXIS));
		equalBox = new JComboBox<>(new String[]{"OR","AND"});
		equalBox.setSelectedIndex(1);
		equalBox.setPreferredSize(new Dimension(60,20));
		equalBox.setMaximumSize(new Dimension(60,20));
		equalBox.setAlignmentX(LEFT_ALIGNMENT);
		allButton = new JButton("All");
		allButton.setPreferredSize(new Dimension(60,20));
		allButton.setMaximumSize(new Dimension(60,20));
		noneButton = new JButton("None");
		noneButton.setPreferredSize(new Dimension(60,20));
		noneButton.setMaximumSize(new Dimension(60,20));
		vertexMiddlePanel = new JPanel();
		vertexMiddlePanel.setLayout(new BoxLayout(vertexMiddlePanel, BoxLayout.PAGE_AXIS));
		cVertexPanel = new VertexMaskPanel(sidesBox.getSelectedIndex() + 3, "Current vertex");
		pVertexPanel = new VertexMaskPanel(sidesBox.getSelectedIndex() + 3, "Previous vertex");
		cVertexPanel.setPreferredSize(new Dimension(300,300));
		pVertexPanel.setPreferredSize(new Dimension(300,300));
		
		equalBox.addItemListener(e -> {
//			pVertexPanel.setAllButtons((equalBox.getSelectedIndex() > 0) ? true : false);
		});
		allButton.addActionListener(e ->{
			pVertexPanel.setAllButtons(true);
		});
		noneButton.addActionListener(e ->{
			pVertexPanel.setAllButtons(false);
		});
		vertexPanel.add(cVertexPanel);
		vertexPanel.add(Box.createRigidArea(new Dimension(2,0)));
		vertexMiddlePanel.add(equalBox);
		vertexMiddlePanel.add(allButton);
		vertexMiddlePanel.add(noneButton);
		vertexPanel.add(vertexMiddlePanel);
		vertexPanel.add(Box.createRigidArea(new Dimension(2,0)));
		vertexPanel.add(pVertexPanel);

		colorPanel = new JPanel();
		cLabelPanel = new JPanel();
		cBoxPanel = new JPanel();
		colorPanel.setLayout(new BoxLayout(colorPanel, BoxLayout.LINE_AXIS));
		cLabelPanel.setLayout(new BoxLayout(cLabelPanel, BoxLayout.PAGE_AXIS));
		cBoxPanel.setLayout(new BoxLayout(cBoxPanel, BoxLayout.PAGE_AXIS));
		coldColorBox = new JComboBox<>(COLOR_STRINGS);
		warmColorBox = new JComboBox<>(COLOR_STRINGS);
		hotColorBox = new JComboBox<>(COLOR_STRINGS);
		coldColorBox.setSelectedIndex(0);
		warmColorBox.setSelectedIndex(6);
		hotColorBox.setSelectedIndex(5);
		coldLabel = new JLabel("Cold Color");
		coldLabel.setToolTipText("The Color that pixels start out as when they're plotted for the first time.");
		warmLabel = new JLabel("Warm Color");
		warmLabel.setToolTipText("The Color that a pixel transitions to as it gets plotted more often.");
		hotLabel = new JLabel("Hot Color");
		hotLabel.setToolTipText("The Color that pixels will eventually become when plotted many times.");
		cLabelPanel.add(coldLabel);
		cLabelPanel.add(Box.createRigidArea(new Dimension(0,5)));
		cLabelPanel.add(warmLabel);
		cLabelPanel.add(Box.createRigidArea(new Dimension(0,5)));
		cLabelPanel.add(hotLabel);
		cBoxPanel.add(coldColorBox);
		cBoxPanel.add(warmColorBox);
		cBoxPanel.add(hotColorBox);
		colorPanel.add(Box.createHorizontalGlue());
		colorPanel.add(cLabelPanel);
		colorPanel.add(Box.createHorizontalGlue());
		colorPanel.add(cBoxPanel);
		colorPanel.add(Box.createHorizontalGlue());
		
		add(colorPanel);
		add(middlePanel);
		add(sidesBox);
		add(presetBox);
		add(vertexPanel);
		setVisible(true);
	}

	public int[] getArgs() {
			int[] args = {sidesBox.getSelectedIndex() + 1};
			return args;
	}
	@Override
	public String toString() {
		return "Chaos Polygon New";
	}

	public VertexRestrictions[] getRestrictions() {
		return null;
	}

	@Override
	public void setOptions(Options options) {
		try {
			sidesBox.setSelectedIndex(options.args[0] - 3);
			iterationsField.setText(Integer.toString(options.args[1]));
			equalBox.setSelectedIndex(options.equal ? 0 : 1);			//TODO funny, somewhere this is backwards, so I need to track down where later. All the presets are messed up because of it
			cVertexPanel.setMask(options.args[2]);
			pVertexPanel.setMask(options.args[3]);
			
		} catch (NullPointerException e){
			JOptionPane.showMessageDialog(null, "That preset is incompatible with this design.");
		}		
	}
	@Override
	public Options getOptions() {
		Options options = new Options("Chaos Polygon New"); //Name of the Drawing for ChoiceFrame
		
		options.args = new int[] {
				sidesBox.getSelectedIndex() + 3,
				Integer.parseInt(iterationsField.getText()),
				cVertexPanel.getMask(),
				pVertexPanel.getMask(),
				(drawPolygonCheckbox.isSelected() ? 1 : 0)
		};
		options.colors = new Color[] { 			//While the color comboBoxes are type String, the COLOR[] field supplied by Options.class has identical index values
				COLORS[coldColorBox.getSelectedIndex()],
				COLORS[warmColorBox.getSelectedIndex()],
				COLORS[hotColorBox.getSelectedIndex()]
		};
		options.equal = (equalBox.getSelectedIndex() > 0) ? true : false;
		return options;
	}
	

}
