package mathgraphics;

import java.awt.Color;
import java.awt.color.ColorSpace;

public class Mark extends Color {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2726768479346637670L;

	private int timesPicked;
	
	/**
	 * @return the timesPicked
	 */
	public int getTimesPicked() {
		return timesPicked;
	}

	/**
	 * @param timesPicked the timesPicked to set
	 */
	public void setTimesPicked(int timesPicked) {
		this.timesPicked = timesPicked;
	}
	public Mark(Color c) {
		super(c.getRGB());
		timesPicked = 0;
	}
	public Mark(Color c, int timesPicked) {
		super(c.getRGB());
		this.timesPicked = timesPicked;
	}

	public Mark(int rgb) {
		super(rgb);
		// TODO Auto-generated constructor stub
	}

	public Mark(int rgba, boolean hasalpha) {
		super(rgba, hasalpha);
		// TODO Auto-generated constructor stub
	}

	public Mark(int r, int g, int b) {
		super(r, g, b);
		// TODO Auto-generated constructor stub
	}
	public Mark(float r, float g, float b) {
		super(r, g, b);
		this.timesPicked = 0;
		// TODO Auto-generated constructor stub
	}

	public Mark(float r, float g, float b, int timesPicked) {
		super(r, g, b);
		this.timesPicked = timesPicked;
		// TODO Auto-generated constructor stub
	}

	public Mark(ColorSpace cspace, float[] components, float alpha) {
		super(cspace, components, alpha);
		// TODO Auto-generated constructor stub
	}

	public Mark(int r, int g, int b, int a, int timesPicked) {
		super(r, g, b, a);
		this.timesPicked = timesPicked;
		// TODO Auto-generated constructor stub
	}

	public Mark(float r, float g, float b, float a) {
		super(r, g, b, a);
		// TODO Auto-generated constructor stub
	}

}
