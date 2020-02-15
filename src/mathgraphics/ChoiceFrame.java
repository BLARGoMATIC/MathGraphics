package mathgraphics;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
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
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author John
 *
 */
public class ChoiceFrame {

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
	private JButton drawButton;
	private JButton exportButton;
	/** 
	 */
	public ChoiceFrame() {
		try { 
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		    e.printStackTrace();
		}
		mainFrame = new JFrame();
		designOptionsPanel = new JPanel();
		designComboBoxPanel = new JPanel();
		buttonPanel = new JPanel();
		drawButton = new JButton("Draw");
		exportButton = new JButton("Export");
		
		//Creating the different optionPanels for each selection of the ComboBox. Each extends JPanel, and implements the interface OptionPanel 
		//so I can pull the option values in one line once the draw button is pressed. PolyMorphism is an amazing thing.
		OptionPanel[] designOptionCollection = {
				//						new EmptyOptionsPanel(),
				new ChaosPolyOptions(),
				//						new CircleWrapOptions(),
				//						new TreeOptions(),
				//						new SquareOptions(),
				//						new CircleFracOptions()
				//						new ChaosTriangleOptions(),
				//						new ChaosPentOptions(),
				//						new ChaosHexOptions(),
		};
		
		//Setting up the Frame and adding the panels
		mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.PAGE_AXIS));
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(screen.width/2-mainFrame.getSize().width/2+100, screen.height/2-mainFrame.getSize().height/2-250);
		
		choiceBox = new JComboBox<>(designOptionCollection); //This is so much easier than xaml
		designComboBoxPanel.add(choiceBox); //Adding it to the selections Panel,
		choiceBox.setPreferredSize(new Dimension(200,25));
		choiceBox.setSelectedIndex(0);
		designOptionsPanel.add((JPanel)choiceBox.getSelectedItem());
		buttonPanel.setLayout(new BoxLayout(buttonPanel , BoxLayout.X_AXIS));
		buttonPanel.add(Box.createRigidArea(new Dimension(0,10)));
		buttonPanel.add(drawButton);
		buttonPanel.add(Box.createRigidArea(new Dimension(10,40)));
		buttonPanel.add(exportButton);
		mainFrame.add(designComboBoxPanel);
		mainFrame.add(designOptionsPanel); //empty for now
		mainFrame.add(buttonPanel);
		
		//Action Listeners
		
		//When the ChoiceBox is changed
		choiceBox.addActionListener(e -> { //when the selection changes, so does the available designOptionsPanel, since each Drawing has different arguments
				designOptionsPanel.removeAll(); //Remove everything, if anything is there, just a precaution to avoid choices for a different design from showing up.
				designOptionsPanel.add((JPanel)choiceBox.getSelectedItem());
				mainFrame.validate();
				mainFrame.pack();
			});
		//Draw the selected design with the selected options
		drawButton.addActionListener(e -> { //Changes when
				if (drawFrame != null) drawFrame.dispose();
				try {
					drawFrame = new DrawFrame(((OptionPanel)choiceBox.getSelectedItem()).getOptions());
					Thread t = new Thread() { //This somehow allows the design 'animation' to begin right when the frame opens, as opposed to having a white box for a little bit
						@Override
						public void run() {  //TODO find a way to kill this thread, or stop the drawing once the frame has been closed in order to prevent unnecessary cpu usage. Don't want to draw a picture we can't see!
							drawFrame.draw();
						}
					};
					t.start();
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Select a Design");
					e1.printStackTrace();
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Numbers Only Please");
					e2.printStackTrace();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
		});
		//"I like this design, I want to save it as a picture"
		exportButton.addActionListener(e -> {
			String fileSeparator = System.getProperty("file.separator");
			File saveDirectory = new File(System.getProperty("user.home") + fileSeparator + "Pictures" + fileSeparator + "Chaos Game");	//Pathname to where we want to save a picture
			if (!saveDirectory.exists()) saveDirectory.mkdir(); //Folder don't real, make real
			File fileToCheck = new File(saveDirectory + fileSeparator + "Chaos Polygon");
			File fileToSave = new File(fileToCheck + ".png");
			JFileChooser fileChooser = new JFileChooser(saveDirectory);

			if (fileToSave.exists()) {
				int i = 1;
				do {
					fileToSave = new File(fileToCheck + " " + Integer.toString(i) + ".png");
					i++;
				} while (fileToSave.exists());
			}
			fileChooser.setFileFilter(new FileNameExtensionFilter("PNG and JPG Images", "png", "jpg"));
			fileChooser.setDialogTitle("Saved Image Location");
			fileChooser.setSelectedFile(fileToSave);

			Dimension d = drawFrame.getFrameSize();
			BufferedImage image = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = image.createGraphics();
			drawFrame.print(g2d);
			JFrame parentFrame = new JFrame();
			
			int userSelection = fileChooser.showSaveDialog(parentFrame);
			if(userSelection == JFileChooser.APPROVE_OPTION) {
				try {
					ImageIO.write(image, "PNG", fileChooser.getSelectedFile());
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
			}				
		});

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
}


