package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ShowPanel extends JPanel{
	
	private final String COMMAND_BACK = "BACK";
	
	private JTextArea txtAreaShow;
	private JButton buttonBack;
	
	public ShowPanel() {
		setLayout(new GridLayout(2, 1));
		txtAreaShow = new JTextArea();
		buttonBack = new JButton("Back");
		
		buttonBack.setActionCommand(COMMAND_BACK);
		this.add(txtAreaShow);
		this.add(buttonBack);
	}

	public JTextArea getTxtAreaShow() {
		return txtAreaShow;
	}

	public void setTxtAreaShoww(JTextArea txtShow) {
		this.txtAreaShow = txtShow;
	}

	public JButton getButtonBack() {
		return buttonBack;
	}

	public void setButtonBack(JButton buttonBack) {
		this.buttonBack = buttonBack;
	}

	public String getCOMMAND_BACK() {
		return COMMAND_BACK;
	}
	
	
}
