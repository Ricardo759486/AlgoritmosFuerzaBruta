package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShowPanel extends JPanel{
	
	private final String COMMAND_BACK = "BACK";
	
	private JTextField txtShow;
	private JButton buttonBack;
	
	public ShowPanel() {
		setLayout(new GridLayout(2, 1));
		txtShow = new JTextField();
		buttonBack = new JButton("Back");
		
		buttonBack.setActionCommand(COMMAND_BACK);
		this.add(txtShow);
		this.add(buttonBack);
	}

	public JTextField getTxtShow() {
		return txtShow;
	}

	public void setTxtShow(JTextField txtShow) {
		this.txtShow = txtShow;
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
