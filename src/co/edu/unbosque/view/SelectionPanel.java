/**
 * The package that contains this class
 */
package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class SelectionPanel that extends JPanel this class contains different
 * variables that the user can write the word or letter that want to find,
 * select the algorithm that the user want to find what writes in the text
 * field.
 * 
 * @authors Jhoan Ricardo Cuevas Patinio, Robinson Jose Gutierrez Solano, Juana
 *          Valentina Torres Parrado and Juan Felipe Rojas Rodriguez
 * @version 1.0
 *
 */
public class SelectionPanel extends JPanel {
	/**
	 * Variable static COMMAND_CONFIRM type String
	 */
	private final String COMMAND_CONFIRM = "CONFIRM";

	/**
	 * Variable labelTypeAlgorithm type JLabel
	 */
	private JLabel labelTypeAlgorithm;
	/**
	 * Variable txtKey type JTextField
	 */
	private JTextField txtKey;
	/**
	 * Variable comboTypeAlgorithm type JComboBox that type list is String
	 */
	private JComboBox<String> comboTypeAlgorithm;
	/**
	 * Variable checkSearch type JCheckBox
	 */
	private JCheckBox checkSearch;
	/**
	 * Variable buttonConfirm type JButton
	 */
	private JButton buttonConfirm;
	/**
	 * Variable showPanel type ShowPanel
	 */
	private ShowPanel showPanel;
	/**
	 * Variable panel type JPanel
	 */
	private JPanel panel;

	/**
	 * Constructor of the class that initialise the variables and add text in the
	 * JComboBox, then add the components in the panel and organise the window for
	 * the view.
	 */
	public SelectionPanel() {
		setLayout(new GridLayout(2, 1));
		labelTypeAlgorithm = new JLabel("Write the word to search");
		txtKey = new JTextField();
		comboTypeAlgorithm = new JComboBox<String>();
		comboTypeAlgorithm.addItem("Select algorithm");
		comboTypeAlgorithm.addItem("BM");
		comboTypeAlgorithm.addItem("KMP");
		checkSearch = new JCheckBox("Precise search");
		buttonConfirm = new JButton("Search");
		showPanel = new ShowPanel();
		panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1));
		panel.add(labelTypeAlgorithm);
		panel.add(txtKey);
		panel.add(comboTypeAlgorithm);
		panel.add(checkSearch);
		panel.add(buttonConfirm);
		this.add(panel);
		this.add(showPanel);

		buttonConfirm.setActionCommand(COMMAND_CONFIRM);
	}

	/**
	 * This method check what the user type and select, put in the array and return
	 * with the data in the array.
	 * 
	 * @return the variable output with the data and type String.
	 */
	public String[] checkInputs() {
		String[] output = new String[3];
		output[0] = "0";
		if (!txtKey.getText().trim().equals("") && !comboTypeAlgorithm.getSelectedItem().equals("Select algorithm")) {
			output[1] = txtKey.getText();
			output[2] = comboTypeAlgorithm.getSelectedItem().toString();
		} else {
			output[0] = "1";
			output[1] = "Please complete the fields";
		}
		return output;
	}

	/**
	 * @return the labelTypeAlgorithm
	 */
	public JLabel getLabelTypeAlgorithm() {
		return labelTypeAlgorithm;
	}

	/**
	 * @param labelTypeAlgorithm the labelTypeAlgorithm to set
	 */
	public void setLabelTypeAlgorithm(JLabel labelTypeAlgorithm) {
		this.labelTypeAlgorithm = labelTypeAlgorithm;
	}

	/**
	 * @return the txtKey
	 */
	public JTextField getTxtKey() {
		return txtKey;
	}

	/**
	 * @param txtKey the txtKey to set
	 */
	public void setTxtKey(JTextField txtKey) {
		this.txtKey = txtKey;
	}

	/**
	 * @return the comboTypeAlgorithm
	 */
	public JComboBox<String> getComboTypeAlgorithm() {
		return comboTypeAlgorithm;
	}

	/**
	 * @param comboTypeAlgorithm the comboTypeAlgorithm to set
	 */
	public void setComboTypeAlgorithm(JComboBox<String> comboTypeAlgorithm) {
		this.comboTypeAlgorithm = comboTypeAlgorithm;
	}

	/**
	 * @return the buttonConfirm
	 */
	public JButton getButtonConfirm() {
		return buttonConfirm;
	}

	/**
	 * @param buttonConfirm the buttonConfirm to set
	 */
	public void setButtonConfirm(JButton buttonConfirm) {
		this.buttonConfirm = buttonConfirm;
	}

	/**
	 * @return the cOMMAND_CONFIRM
	 */
	public String getCOMMAND_CONFIRM() {
		return COMMAND_CONFIRM;
	}

	/**
	 * @return the checkSearch
	 */
	public JCheckBox getCheckSearch() {
		return checkSearch;
	}

	/**
	 * @param checkSearch the checkSearch to set
	 */
	public void setCheckSearch(JCheckBox checkSearch) {
		this.checkSearch = checkSearch;
	}

	/**
	 * @return the showPanel
	 */
	public ShowPanel getShowPanel() {
		return showPanel;
	}

	/**
	 * @param showPanel the showPanel to set
	 */
	public void setShowPanel(ShowPanel showPanel) {
		this.showPanel = showPanel;
	}

	/**
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

}
