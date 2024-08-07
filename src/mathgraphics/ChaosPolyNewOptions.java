package mathgraphics;

import java.awt.Color;
import java.awt.Dimension;
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
	private JComboBox<String> sidesField;
	String[] polygons = {
			"Triangle",
			"Square",
			"Pentagon",
			"Hexagon",
			"Septagon",
			"Octagon",
			"Nonagon",
			"Decagon"};	
	private JPanel vertexPanel;
	private VertexMaskPanel cVertexPanel;
	private VertexMaskPanel pVertexPanel;
	private JComboBox<String> equalBox;
//	private DrawPatterns dp;
//	private List<JRadioButton> vertexButtons;
	private JPanel iterationsPanel;
	private JLabel iterationsLabel;
	private JPanel drawPolygonPanel;
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
//		this.setPreferredSize(new Dimension(200,200));
		
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
		
		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.LINE_AXIS));
		middlePanel.add(Box.createHorizontalGlue());
		middlePanel.add(drawPolygonPanel);
		middlePanel.add(iterationsPanel);
		middlePanel.add(Box.createHorizontalGlue());

		sidesField = new JComboBox<>(polygons);
		sidesField.setMaximumSize(new Dimension(100,20));
		sidesField.setSelectedIndex(2);
		sidesField.addItemListener(new ItemListener() { //TODO make a new panel class to clear up tihs constructor, then to refresh it, we can just dispose the old panel and make a new one.
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				vertexPanel.removeAll();
				equalBox = new JComboBox<>(new String[]{"OR","AND"});
				equalBox.setSelectedIndex(1);
				equalBox.setPreferredSize(new Dimension(50,20));
				equalBox.setMaximumSize(new Dimension(50,20));
				cVertexPanel = new VertexMaskPanel(sidesField.getSelectedIndex() + 3, "Current vertex");
				pVertexPanel = new VertexMaskPanel(sidesField.getSelectedIndex() + 3, "Previous vertex");
				cVertexPanel.setPreferredSize(new Dimension(300,300));
				pVertexPanel.setPreferredSize(new Dimension(300,300));
				vertexPanel.add(cVertexPanel);
				vertexPanel.add(Box.createRigidArea(new Dimension(2,0)));
				vertexPanel.add(equalBox);
				vertexPanel.add(Box.createRigidArea(new Dimension(2,0)));
				vertexPanel.add(pVertexPanel);
				validate();
			}
		});
		vertexPanel = new JPanel();
		vertexPanel.setLayout(new BoxLayout(vertexPanel, BoxLayout.LINE_AXIS));
		equalBox = new JComboBox<>(new String[]{"OR","AND"});
		equalBox.setSelectedIndex(1);
		equalBox.setPreferredSize(new Dimension(50,20));
		equalBox.setMaximumSize(new Dimension(50,20));
		cVertexPanel = new VertexMaskPanel(sidesField.getSelectedIndex() + 3, "Current vertex");
		pVertexPanel = new VertexMaskPanel(sidesField.getSelectedIndex() + 3, "Previous vertex");
		cVertexPanel.setPreferredSize(new Dimension(300,300));
		pVertexPanel.setPreferredSize(new Dimension(300,300));
		vertexPanel.add(cVertexPanel);
		vertexPanel.add(Box.createRigidArea(new Dimension(2,0)));
		vertexPanel.add(equalBox);
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
		add(sidesField);
		add(vertexPanel);
		setVisible(true);
	}

	public int[] getArgs() {
			int[] args = {sidesField.getSelectedIndex() + 1};
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public Options getOptions() {
		Options options = new Options("Chaos Polygon New"); //Name of the Drawing for ChoiceFrame
		
		int drawPolygon = drawPolygonCheckbox.isSelected() ? 1 : 0;
		options.args = new int[] {
				//				Integer.parseInt(sidesField.getText())
				sidesField.getSelectedIndex() + 3,
				Integer.parseInt(iterationsField.getText()),
				cVertexPanel.getMask(),
				pVertexPanel.getMask(),
				drawPolygon
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
