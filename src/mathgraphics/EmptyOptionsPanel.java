package mathgraphics;

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

	public int[] getArgs() {
		return new int[0];
	}

	@Override
	public String toString() {
		return null;
	}

	public VertexRestrictions[] getRestrictions() {
		return new VertexRestrictions[0];
	}

	@Override
	public Options getOptions() {
		return null;
	}

	@Override
	public void setOptions(Options options) {
	}

}
