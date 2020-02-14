package mathgraphics;

public class VertexRestrictions {
	private boolean equivalencePreference;
	private boolean equivalenceTrue;
	private boolean adjacentPreference;
	private boolean adjacentTrue;
	private boolean offset1Preference;
	private boolean offset1True;
	private boolean offset2Preference;
	private boolean offset2True;
	
	private int offset1Integer;
	private int offset2Integer;
	
	public VertexRestrictions() {
		
	}
	
	/** For use when manually creating presets
	 * @param bools
	 * @param offsets
	 */
	public VertexRestrictions(boolean[] bools, int[] offsets) {
		equivalencePreference 	= bools[0];
		equivalenceTrue			= bools[1];
		adjacentPreference		= bools[2];
		adjacentTrue 			= bools[3];
		offset1Preference 		= bools[4];
		offset1True 			= bools[5];
		offset2Preference 		= bools[6];
		offset2True 			= bools[7];
		
		offset1Integer = offsets[0];
		offset2Integer = offsets[1];
	}
	
	//Methods
	
	public boolean isEquivalencePreference() {
		return equivalencePreference;
	}
	public void setEquivalencePreference(boolean equivalencePreference) {
		this.equivalencePreference = equivalencePreference;
	}
	public boolean isEquivalenceTrue() {
		return equivalenceTrue;
	}
	public void setEquivalenceTrue(boolean equivalenceTrue) {
		this.equivalenceTrue = equivalenceTrue;
	}
	public boolean isAdjacentPreference() {
		return adjacentPreference;
	}
	public void setAdjacentPreference(boolean adjacentPreference) {
		this.adjacentPreference = adjacentPreference;
	}
	public boolean isAdjacentTrue() {
		return adjacentTrue;
	}
	public void setAdjacentTrue(boolean adjacentTrue) {
		this.adjacentTrue = adjacentTrue;
	}
	public boolean isOffset1Preference() {
		return offset1Preference;
	}
	public void setOffset1Preference(boolean offset1Preference) {
		this.offset1Preference = offset1Preference;
	}
	public boolean isOffset1True() {
		return offset1True;
	}
	public void setOffset1True(boolean offset1True) {
		this.offset1True = offset1True;
	}
	public boolean isOffset2Preference() {
		return offset2Preference;
	}
	public void setOffset2Preference(boolean offset2Preference) {
		this.offset2Preference = offset2Preference;
	}
	public boolean isOffset2True() {
		return offset2True;
	}
	public void setOffset2True(boolean offset2True) {
		this.offset2True = offset2True;
	}
	public int getOffset1Integer() {
		return offset1Integer;
	}
	public void setOffset1Integer(int offset1Integer) {
		this.offset1Integer = offset1Integer;
	}
	public int getOffset2Integer() {
		return offset2Integer;
	}
	public void setOffset2Integer(int offset2Integer) {
		this.offset2Integer = offset2Integer;
	}
	
}
