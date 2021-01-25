package mathgraphics;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;

/**
 * @author John
 * 
 */
public abstract class OptionPanel extends JPanel {
	
	//Start Members
	/**
	 * 
	 */
	private static final long serialVersionUID = -892834822827996414L;
	protected static final String[] COLOR_STRINGS = {
			"Red",
			"Green",
			"Blue",
			"Magenta",
			"Cyan",
			"Yellow",
			"Orange",
			"Pink",
			"White",
			"Black",
	};
	protected static final Color[] COLORS = {			
			Color.RED,
			Color.GREEN,
			Color.BLUE,
			Color.MAGENTA,
			Color.CYAN,
			Color.YELLOW,
			Color.ORANGE,
			Color.PINK,
			Color.WHITE,
			Color.BLACK,
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
