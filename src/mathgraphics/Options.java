package mathgraphics;

import java.awt.Color;

import com.fasterxml.jackson.annotation.*;

public class Options {
	
	/**
	 * @param name friendly name
	 * @param colors an array of 3 colors: Cold, Warm, Hot
	 * @param args
	 */
	public String name;
	@JsonIgnore
	public Color[] colors;
	
	/** {
	 * 	int numSides,			//int for number of sides
	 * 	iterations,				//int for number
	 * 	int cMask,				//current vertex Mask
	 * 	int pMask				//previous vertex Mask
	 * 	draw the polygon?,		//instruction for LEDGrid to draw the polygon. 1 for yes, 0 for no
	 * 	}
	 */ 
	@JsonProperty("numSides, iterations, cMask, pMask")
	public int[] args;
	public boolean equal;
	public boolean showIncrement;
	@JsonIgnore
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
	public Options(Color[] colors, int[] args, boolean equal) {
		this.colors = colors;
		this.args = args;
		this.equal = equal;
	}
	public Options(Color[] colors, int[] args, boolean equal, boolean showIncrement) {
		this.colors = colors;
		this.args = args;
		this.equal = equal;
		this.showIncrement = showIncrement;
	}
	public Options(Color[] colors, int[] args, boolean equal, boolean showIncrement, VertexRestrictions[] restrictions) {
		this.colors = colors;
		this.args = args;
		this.equal = equal;
		this.showIncrement = showIncrement;
		this.restrictions = restrictions;
	}
	public Options(String name, int[] args, boolean equal) {
		this.name = name;
		this.args = args;
		this.equal = equal;
	}
	public Options(String name, int[] args, boolean equal, boolean showIncrement) {
		this.name = name;
		this.args = args;
		this.equal = equal;
		this.showIncrement = showIncrement;
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
