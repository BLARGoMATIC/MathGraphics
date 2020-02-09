package mathGraphics;

import javax.swing.JComboBox;

public class ChoiceBox extends JComboBox<String> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6040195176950241380L;
	
	OptionPanel selection;
	
	public ChoiceBox(String[] items) {
		super(items);
		selection = null;
	}
	
	public void setOptionPanel(OptionPanel selection) {
		this.selection = selection;
	}
	
	public OptionPanel getOptionPanel() {
		return selection;
	}
}
