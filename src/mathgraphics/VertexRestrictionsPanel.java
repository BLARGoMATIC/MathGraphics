package mathgraphics;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * This class exists to make adding multiple vertex controls easier, instead of making the ChaosPolyOptions bloated.
 * @author John
 *
 */
public class VertexRestrictionsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1302085671128912513L;
	
	JPanel ePanel;
	JLabel eLabel;
	JPanel aPanel;
	JLabel aLabel;
	JPanel o1Panel;
	JLabel o1Label;
	JPanel o2Panel;
	JLabel o2Label;
	
	private JRadioButton eButtonTrue;
	private JRadioButton eButtonFalse;
	private JRadioButton eButtonNP;
	private JRadioButton aButtonTrue;
	private JRadioButton aButtonFalse;
	private JRadioButton aButtonNP;
	private JRadioButton o1ButtonTrue;
	private JRadioButton o1ButtonFalse;
	private JRadioButton o2ButtonTrue;
	private JRadioButton o2ButtonFalse;
	
	private ButtonGroup eButtonGroup; 
	private ButtonGroup aButtonGroup;
	private ButtonGroup o1ButtonGroup;
	private ButtonGroup o2ButtonGroup;
	
	private JTextField o1TextField; 
	private JTextField o2TextField;

	public VertexRestrictionsPanel(String title) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBorder(BorderFactory.createTitledBorder(title));
		
		ePanel = new JPanel();
		eLabel = new JLabel("Equivalent");
		ePanel.setLayout(new BoxLayout(ePanel, BoxLayout.LINE_AXIS));
		eButtonTrue = new JRadioButton("Y");
		eButtonFalse = new JRadioButton("N");
		eButtonNP = new JRadioButton("NP");
		eButtonGroup = new ButtonGroup();
		eButtonGroup.add(eButtonTrue);
		eButtonGroup.add(eButtonFalse);
		eButtonGroup.add(eButtonNP);
		eButtonNP.setSelected(true);
		ePanel.add(Box.createRigidArea(new Dimension(10,0)));
		ePanel.add(eLabel);
		ePanel.add(Box.createRigidArea(new Dimension(10,0)));
		ePanel.add(Box.createHorizontalGlue());
		ePanel.add(eButtonNP);
		ePanel.add(eButtonTrue);
		ePanel.add(eButtonFalse);
		ePanel.add(Box.createRigidArea(new Dimension(10,0)));

		aPanel = new JPanel();
		aLabel = new JLabel("Adjacent");
		aPanel.setLayout(new BoxLayout(aPanel, BoxLayout.LINE_AXIS));
		aButtonTrue = new JRadioButton("Y");
		aButtonFalse = new JRadioButton("N");
		aButtonNP = new JRadioButton("NP");
		aButtonGroup = new ButtonGroup();
		aButtonGroup.add(aButtonTrue);
		aButtonGroup.add(aButtonFalse);
		aButtonGroup.add(aButtonNP);
		aButtonNP.setSelected(true);
		aPanel.add(Box.createRigidArea(new Dimension(10,0)));
		aPanel.add(aLabel);
		aPanel.add(Box.createHorizontalGlue());
		aPanel.add(aButtonNP);
		aPanel.add(aButtonTrue);
		aPanel.add(aButtonFalse);
		aPanel.add(Box.createRigidArea(new Dimension(10,0)));

		o1Panel = new JPanel();
		o1Label = new JLabel("Offset 1");
		o1Panel.setLayout(new BoxLayout(o1Panel, BoxLayout.LINE_AXIS));
		o1ButtonTrue = new JRadioButton("Y");
		o1ButtonFalse = new JRadioButton("N");
		o1ButtonGroup = new ButtonGroup();
		o1ButtonGroup.add(o1ButtonTrue);
		o1ButtonGroup.add(o1ButtonFalse);
		o1ButtonFalse.setSelected(true);
		o1TextField = new JTextField();
		o1TextField.setText("0");
		o1TextField.setPreferredSize(new Dimension(30,20));
		o1TextField.setMaximumSize(new Dimension(30, 20));
		o1Panel.add(Box.createRigidArea(new Dimension(10,0)));
		o1Panel.add(o1Label);
		o1Panel.add(Box.createHorizontalGlue());
		o1Panel.add(o1TextField);
		o1Panel.add(Box.createRigidArea(new Dimension(10,0)));
		o1Panel.add(o1ButtonTrue);
		o1Panel.add(o1ButtonFalse);
		o1Panel.add(Box.createRigidArea(new Dimension(10,0)));

		o2Panel = new JPanel();
		o2Label = new JLabel("Offset 2");
		o2Panel.setLayout(new BoxLayout(o2Panel, BoxLayout.LINE_AXIS));
		o2ButtonTrue = new JRadioButton("Y");
		o2ButtonFalse = new JRadioButton("N");
		o2ButtonGroup = new ButtonGroup();
		o2ButtonGroup.add(o2ButtonTrue);
		o2ButtonGroup.add(o2ButtonFalse);
		o2ButtonFalse.setSelected(true);
		o2TextField = new JTextField();
		o2TextField.setText("0");
		o2TextField.setPreferredSize(new Dimension(30,20));
		o2TextField.setMaximumSize(new Dimension(30, 20));
		o2Panel.add(Box.createRigidArea(new Dimension(10,0)));
		o2Panel.add(o2Label);
		o2Panel.add(Box.createHorizontalGlue());
		o2Panel.add(o2TextField);
		o2Panel.add(Box.createRigidArea(new Dimension(10,0)));
		o2Panel.add(o2ButtonTrue);
		o2Panel.add(o2ButtonFalse);
		o2Panel.add(Box.createRigidArea(new Dimension(10,0)));

		add(ePanel);
		add(aPanel);
		add(o1Panel);
		add(o2Panel);
	}
	
	public VertexRestrictions getRestrictions() {
		VertexRestrictions restrictions = new VertexRestrictions();
		restrictions.setEquivalencePreference(!eButtonNP.isSelected()); //If the button is selected, then that means there is no preference, i.e. false
		restrictions.setEquivalenceTrue(eButtonTrue.isSelected()); 
		restrictions.setAdjacentPreference(!aButtonNP.isSelected());
		restrictions.setAdjacentTrue(aButtonTrue.isSelected());

			int offset1 = Integer.parseInt(o1TextField.getText());
			if(offset1 != 0) {
				restrictions.setOffset1Preference(true);
				restrictions.setOffset1True(o1ButtonTrue.isSelected());
				restrictions.setOffset1Integer(offset1);
			}
			else {
				restrictions.setOffset1Preference(false);
				restrictions.setOffset1Integer(0);
			}
			int offset2 = Integer.parseInt(o2TextField.getText());
			if(offset2 != 0) {
				restrictions.setOffset2Preference(true);
				restrictions.setOffset2True(o2ButtonTrue.isSelected());
				restrictions.setOffset2Integer(offset2);
			}
			else {
				restrictions.setOffset2Preference(false);
				restrictions.setOffset2Integer(0);
			}
		return restrictions;
	}
	public void setRestrictions(VertexRestrictions restrictions) {
		if (restrictions.isEquivalencePreference()) eButtonNP.setSelected(true);
		else if (restrictions.isEquivalenceTrue()) eButtonTrue.setSelected(true);
		else eButtonFalse.setSelected(true);
		
		if (restrictions.isAdjacentPreference()) aButtonNP.setSelected(true);
		else if (restrictions.isAdjacentTrue()) aButtonTrue.setSelected(true);
		else aButtonFalse.setSelected(true);
		
		o1TextField.setText(Integer.toString(restrictions.getOffset1Integer()));
		if (restrictions.isOffset1True()) o1ButtonTrue.setSelected(true);
		else o1ButtonFalse.setSelected(true);
		
		o2TextField.setText(Integer.toString(restrictions.getOffset2Integer()));
		if (restrictions.isOffset2True()) o2ButtonTrue.setSelected(true);
		else o2ButtonFalse.setSelected(true);
	}
}
