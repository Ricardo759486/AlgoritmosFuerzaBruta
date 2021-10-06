/**
 * The package that contains this class
 */
package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class WelcomePanel that extends JPanel this class is a part of the window and
 * shows the button to select a file and welcoming you to the program.
 * 
 * @authors Jhoan Ricardo Cuevas Patinio, Robinson Jose Gutierrez Solano, Juana
 *          Valentina Torres Parrado and Juan Felipe Rojas Rodriguez
 * @version 1.0
 *
 */
public class WelcomePanel extends JPanel {
	/**
	 * Variable static COMMAND_SELECT_FILE type String
	 */
	private final String COMMAND_SELECT_FILE = "SELCT_FILE";
	/**
	 * Variable labelWelcome type JLabel
	 */
	private JLabel labelWelcome;
	/**
	 * Variable buttonSelectFile type JButton
	 */
	private JButton buttonSelectFile;

	/**
	 * This is the constructor from the class to initialise the variables, create
	 * the layouts and adding to the panel
	 */
	public WelcomePanel() {
		setLayout(new GridLayout(2, 1));
		labelWelcome = new JLabel("Welcome");
		buttonSelectFile = new JButton("Select file");
		this.add(labelWelcome);
		this.add(buttonSelectFile);

		buttonSelectFile.setActionCommand(COMMAND_SELECT_FILE);
	}

	/**
	 * @return the labelWelcome
	 */
	public JLabel getLabelWelcome() {
		return labelWelcome;
	}

	/**
	 * @param labelWelcome the labelWelcome to set
	 */
	public void setLabelWelcome(JLabel labelWelcome) {
		this.labelWelcome = labelWelcome;
	}

	/**
	 * @return the buttonSelectFile
	 */
	public JButton getButtonSelectFile() {
		return buttonSelectFile;
	}

	/**
	 * @param buttonSelectFile the buttonSelectFile to set
	 */
	public void setButtonSelectFile(JButton buttonSelectFile) {
		this.buttonSelectFile = buttonSelectFile;
	}

	/**
	 * @return the cOMMAND_SELECT_FILE
	 */
	public String getCOMMAND_SELECT_FILE() {
		return COMMAND_SELECT_FILE;
	}

}
