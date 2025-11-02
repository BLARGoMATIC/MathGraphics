package mathgraphics;

import java.awt.Color;

public class Options {
	
	/**
	 * @param name friendly name
	 * @param colors an array of 3 colors: Cold, Warm, Hot
	 * @param args
	 */
	public String name;
	public Color[] colors;
	public int[] args;
	public boolean equal;
	public boolean showIncrement;
	public VertexRestrictions[] restrictions;
	
	public Options() {
	}
	public Options(String name) {
		this.name = name;
	}
	public Options(int[] args, boolean equal, VertexRestrictions[] restrictions) {
		this.args = args;
		this.equal = equal;
		this.restrictions = restrictions;
	}
	public Options(int[] args, boolean equal, boolean showIncrement, VertexRestrictions[] restrictions) {
		this.args = args;
		this.equal = equal;
		this.showIncrement = showIncrement;
		this.restrictions = restrictions;
	}
	public Options(Color[] colors, int[] args, boolean equal, boolean showIncrement, VertexRestrictions[] restrictions) {
		this.colors = colors;
		this.args = args;
		this.equal = equal;
		this.showIncrement = showIncrement;
		this.restrictions = restrictions;
	}
	public Options(String name, int[] args, boolean equal, VertexRestrictions[] restrictions) {
		this.name = name;
		this.args = args;
		this.equal = equal;
		this.restrictions = restrictions;
	}
	public Options(String name, int[] args, boolean equal, boolean showIncrement, VertexRestrictions[] restrictions) {
		this.name = name;
		this.args = args;
		this.equal = equal;
		this.showIncrement = showIncrement;
		this.restrictions = restrictions;
	}
	public Options(String name, Color[] colors, int[] args, boolean equal, boolean showIncrement, VertexRestrictions[] restrictions) {
		this.name = name;
		this.colors = colors;
		this.args = args;
		this.equal = equal;
		this.showIncrement = showIncrement;
		this.restrictions = restrictions;
	}
	
	public String toString() {
		return name;
	}

	
}
