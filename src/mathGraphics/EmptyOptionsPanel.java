package mathGraphics;

import java.awt.LayoutManager;

public class EmptyOptionsPanel extends OptionPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7476696124920430239L;

	public EmptyOptionsPanel() {
	}

	public EmptyOptionsPanel(LayoutManager layout) {
		super(layout);
	}

	public EmptyOptionsPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public EmptyOptionsPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	@Override
	public int[] getArgs() {
		return null;
	}

	@Override
	public String toString() {
		return "Pick a Design";
	}

	@Override
	public VertexRestrictions[] getRestrictions() {
		return null;
	}

}
