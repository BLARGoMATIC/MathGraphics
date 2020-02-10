package mathGraphics;

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
	
	private JRadioButton eButtonTrue,
				 eButtonFalse,
				 eButtonNP,
				 aButtonTrue,
				 aButtonFalse,
				 aButtonNP,
				 o1ButtonTrue,
				 o1ButtonFalse,
				 o2ButtonTrue,
				 o2ButtonFalse;
	private ButtonGroup eButtonGroup, aButtonGroup, o1ButtonGroup, o2ButtonGroup;
	private JTextField o1TextField, o2TextField;
//	boolean eButtonVal, eButtonPref, aButton, o1Button, o2Button;

	public VertexRestrictionsPanel(String title) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBorder(BorderFactory.createTitledBorder(title));
		
		JPanel ePanel = new JPanel();
		ePanel.setLayout(new BoxLayout(ePanel, BoxLayout.LINE_AXIS));
		JLabel eLabel = new JLabel("Equivalent");
		eButtonTrue = new JRadioButton("Y");
		eButtonFalse = new JRadioButton("N");
		eButtonNP = new JRadioButton("NP");
		ButtonGroup eButtonGroup = new ButtonGroup();
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

		JPanel aPanel = new JPanel();
		aPanel.setLayout(new BoxLayout(aPanel, BoxLayout.LINE_AXIS));
		JLabel aLabel = new JLabel("Adjacent");
		aButtonTrue = new JRadioButton("Y");
		aButtonFalse = new JRadioButton("N");
		aButtonNP = new JRadioButton("NP");
		ButtonGroup aButtonGroup = new ButtonGroup();
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

		JPanel o1Panel = new JPanel();
		o1Panel.setLayout(new BoxLayout(o1Panel, BoxLayout.LINE_AXIS));
		JLabel o1Label = new JLabel("Offset 1");
		o1ButtonTrue = new JRadioButton("Y");
		o1ButtonFalse = new JRadioButton("N");
		ButtonGroup o1ButtonGroup = new ButtonGroup();
		o1ButtonGroup.add(o1ButtonTrue);
		o1ButtonGroup.add(o1ButtonFalse);
		o1ButtonTrue.setSelected(true);
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

		JPanel o2Panel = new JPanel();
		o2Panel.setLayout(new BoxLayout(o2Panel, BoxLayout.LINE_AXIS));
		JLabel o2Label = new JLabel("Offset 2");
		o2ButtonTrue = new JRadioButton("Y");
		o2ButtonFalse = new JRadioButton("N");
		ButtonGroup o2ButtonGroup = new ButtonGroup();
		o2ButtonGroup.add(o2ButtonTrue);
		o2ButtonGroup.add(o2ButtonFalse);
		o2ButtonTrue.setSelected(true);
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

//		eButtonTrue.addActionListener(this);
//		eButtonFalse.addActionListener(this);
//		eButtonNP.addActionListener(this);
//		aButtonTrue.addActionListener(this);
//		aButtonFalse.addActionListener(this);
//		aButtonNP.addActionListener(this);
//		o1ButtonTrue.addActionListener(this);
//		o1ButtonFalse.addActionListener(this);
//		o2ButtonTrue.addActionListener(this);
//		o2ButtonFalse.addActionListener(this);
//		o1TextField.addActionListener(this);
//		o2TextField.addActionListener(this);

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
		try {
			int offset = Integer.parseInt(o1TextField.getText());
			if(offset != 0) {
				restrictions.setOffset1Preference(true);
				restrictions.setOffset1Integer(offset);
			}
			else {
				restrictions.setOffset1Preference(false);
				restrictions.setOffset1Integer(0);
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Only Integers Please");
			e1.printStackTrace();
			return null;
		}
		try {
			int offset = Integer.parseInt(o1TextField.getText());
			if(offset != 0) {
				restrictions.setOffset2Preference(true);
				restrictions.setOffset2Integer(offset);
			}
			else {
				restrictions.setOffset2Preference(false);
				restrictions.setOffset2Integer(0);
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Only Integers Please");
			e1.printStackTrace();
			return null;
		}
		return restrictions;
	}
}
