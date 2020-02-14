package mathgraphics;

import java.awt.LayoutManager;

import javax.swing.JPanel;

public abstract class OptionPanel extends JPanel {
	
	//Start Members
	/**
	 * 
	 */
	private static final long serialVersionUID = -892834822827996414L;
	protected static final String[] COLOR_STRINGS = {			
			"Choose a Color", //0
			"White",
			"Black",
			"Red",
			"Green",
			"Blue",
			"Purple",
			"Orange",
			"Yellow",
	};
	//End Members
	
	//Start Constructors
	public OptionPanel() {
	}
	public OptionPanel(LayoutManager layout) {
		super(layout);
	}
	public OptionPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}
	public OptionPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}
	//End Constructors
	
	//Start Methods
	public Options getOptions() { //We don't really store Options, they're really more of a way to pass the state of the JComponents to the drawing program
		return new Options(toString());
	}
	public abstract void setOptions(Options options);
	@Override
	public abstract String toString();
}
