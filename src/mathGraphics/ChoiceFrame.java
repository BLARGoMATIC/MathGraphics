package mathGraphics;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

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
	private JPanel designOptionsPanel; 
	
	/**Panel For the ComboBox
	 */
	private JPanel designComboBoxPanel;	
	
	/**Panel For the 'Draw' Button
	 */
	private JPanel buttonPanel;
	
	private DrawFrame drawFrame;
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
//				new ChaosTriangleOptions(),
//				new ChaosPentOptions(),
//				new ChaosHexOptions(),
				new ChaosPolyOptions()
		};
		choiceBox = new JComboBox<OptionPanel>(designOptionCollection); //This is so much easier than xaml
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
		buttonPanel.setLayout(new BoxLayout(buttonPanel , BoxLayout.X_AXIS));
		buttonPanel.add(Box.createRigidArea(new Dimension(0,10)));
		JButton drawButton = new JButton("Draw");
		buttonPanel.add(drawButton);
		buttonPanel.add(Box.createRigidArea(new Dimension(10,40)));
		drawButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		drawButton.addActionListener(new ActionListener() { //'Draw Button' pushed

			@Override
			public void actionPerformed(ActionEvent e) {
				if (drawFrame != null) drawFrame.dispose();
				try {
					if(((OptionPanel) choiceBox.getSelectedItem()).getArgs() != null) { //make sure that the panel parsing is working correctly
						drawFrame = new DrawFrame(	
								choiceBox.getSelectedIndex(),							//The Selected drawing
								((OptionPanel) choiceBox.getSelectedItem()).getArgs(),  //Relevant Arguments for selected Drawing
								((OptionPanel) choiceBox.getSelectedItem()).getRestrictions(),													//TODO remove when vertex restrictions fully implemented.
								choiceBox.getSelectedItem().toString());				//Arguments for the selected drawing
						Thread t = new Thread() { //TODO why doesn't this work sometimes? Is it because java.awt.swing isn't thread-safe? For the moment it works fine... needs more testing.
							public void run() {
								drawFrame.draw();
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
		JButton saveButton = new JButton("Save");
		buttonPanel.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Dimension d = drawFrame.getSize();
				BufferedImage image = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g2d = image.createGraphics();
				drawFrame.print(g2d);
				
				JFrame parentFrame = new JFrame();
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileFilter(new FileNameExtensionFilter("PNG and JPG Images", "png", "jpg"));
				fileChooser.setDialogTitle("Saved Image Location");
				int userSelection = fileChooser.showSaveDialog(parentFrame);
				if(userSelection == JFileChooser.APPROVE_OPTION) {
					try {
						ImageIO.write(image, "png", fileChooser.getSelectedFile());
					} catch (IOException e1) {
						e1.printStackTrace();
					} 
				}				
			}
		});
		
		mainFrame.pack();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2-400, dim.height/2-mainFrame.getSize().height/2-100);
		mainFrame.setVisible(true);
	}
}


