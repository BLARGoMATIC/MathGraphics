package mathGraphics;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//import com.sun.glass.ui.InvokeLaterDispatcher;

/**
 * @author John
 *
 */
public class ChoiceFrame {

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -2430971203566192633L;
	/**Pull-down combination box for selecting a design.
	 * 
	 */
	private JComboBox<OptionPanel> choiceBox;
	/**Master Frame to hold everything
	 * 
	 */
	private JFrame mainFrame;
	
	/** A panel to hold the design-specific options that change depending on the chosen design.
	 *  
	 */
	private JPanel designOptionsPanel = new JPanel(); 
	
	/**Panel For the ComboBox
	 */
	private JPanel designComboBoxPanel = new JPanel();	
	
	/**Panel For the 'Draw' Button
	 */
	private JPanel buttonPanel = new JPanel();
	
	
	/** 
	 */
	public ChoiceFrame() {
		mainFrame = new JFrame();
		designOptionsPanel = new JPanel();
		designComboBoxPanel = new JPanel();
		buttonPanel = new JPanel();
		
		//Setting up the Frame and adding the panels
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.PAGE_AXIS));
		mainFrame.add(designComboBoxPanel);
		mainFrame.add(designOptionsPanel); //empty for now
		mainFrame.add(buttonPanel);
		
		//Creating the different optionPanels for each selection of the ComboBox. Each extends JPanel, and implements the interface OptionPanel 
		//so I can pull the option values in one line once the draw button is pressed. PolyMorphism is an amazing thing.
		OptionPanel designOptionCollection[] = {
				new EmptyOptionsPanel(),
				new CircleWrapOptions(),
				new TreeOptions(),
				new SquareOptions(),
				new CircleFracOptions(),
				new ChaosTriangleOptions(),
				new ChaosPentOptions(),
				new ChaosHexOptions(),
				new ChaosPolyOptions()
		};
		
		// Making the ComboBox, ChoiceBox class extends JComboBox<String> in order to add the methods set and getOptionPanel() so I can reach the OptionPanel method getArgs()
		choiceBox = new JComboBox<OptionPanel>(designOptionCollection);
		designComboBoxPanel.add(choiceBox); //Adding it to the selections Panel,
		choiceBox.setAlignmentY(Component.LEFT_ALIGNMENT);
		choiceBox.setPreferredSize(new Dimension(200,25));
		choiceBox.setSelectedIndex(0);
		choiceBox.addActionListener(new ActionListener() { //when the selection changes, so does the available designOptionsPanel, since each Drawing has different arguments
			@Override
			public void actionPerformed(ActionEvent e) {
				designOptionsPanel.removeAll(); //Remove everything, if anything is there, just a precaution to avoid choices for a different design from showing up.
				designOptionsPanel.add((JPanel)choiceBox.getSelectedItem());
				mainFrame.validate();
				mainFrame.pack();
			}
		});
		buttonPanel.setLayout(new BoxLayout(buttonPanel , BoxLayout.PAGE_AXIS));
		buttonPanel.add(Box.createRigidArea(new Dimension(0,10)));
		JButton drawButton = new JButton("Draw");
		buttonPanel.add(drawButton);
		drawButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		drawButton.addActionListener(new ActionListener() { //'Draw Button' pushed

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(((OptionPanel) choiceBox.getSelectedItem()).getArgs() != null) {
						DrawFrame df = new DrawFrame(	
								choiceBox.getSelectedIndex(),							//The Selected drawing
								((OptionPanel) choiceBox.getSelectedItem()).getArgs(),  //Relevant Arguments for selected Drawing
								choiceBox.getSelectedItem().toString());				//Arguments for the selected drawing
						
						Thread t = new Thread() { //TODO why doesn't this work sometimes? Is it because java.awt.swing isn't thread-safe? For the moment, it works fine... needs more testing.
							public void run() {
								df.draw();
							}
						};
						t.start();
					}
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Select a Design");
					e1.printStackTrace();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		
		mainFrame.pack();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2-400, dim.height/2-mainFrame.getSize().height/2-100);
		mainFrame.setVisible(true);
	}
}

