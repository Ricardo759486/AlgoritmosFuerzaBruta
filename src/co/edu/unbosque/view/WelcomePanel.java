package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WelcomePanel extends JPanel{
	
	private final String COMMAND_SELECT_FILE = "SELCT_FILE";
	
	private JLabel labelWelcome;
	private JButton buttonSelectFile;
	
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
