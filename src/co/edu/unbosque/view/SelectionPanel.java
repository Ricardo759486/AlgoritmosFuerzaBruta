package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SelectionPanel extends JPanel{
	
	private final String COMMAND_CONFIRM = "CONFIRM";
	
	private JLabel labelTypeAlgorithm;
	private JTextField txtKey;
	private JComboBox<String> comboTypeAlgorithm;
	private JButton buttonConfirm;
	
	public SelectionPanel() {
		setLayout(new GridLayout(4, 1));
		labelTypeAlgorithm = new JLabel("Write the word to search");
		txtKey = new JTextField();
		comboTypeAlgorithm = new JComboBox<String>();
		comboTypeAlgorithm.addItem("Select algorithm");
		comboTypeAlgorithm.addItem("BM");
		comboTypeAlgorithm.addItem("KMP");
		buttonConfirm = new JButton("Confirm");
		this.add(labelTypeAlgorithm);
		this.add(comboTypeAlgorithm);
		this.add(txtKey);
		this.add(buttonConfirm);
		
		buttonConfirm.setActionCommand(COMMAND_CONFIRM);
	}


	public JLabel getLabelTypeAlgorithm() {
		return labelTypeAlgorithm;
	}

	public void setLabelTypeAlgorithm(JLabel labelTypeAlgorithm) {
		this.labelTypeAlgorithm = labelTypeAlgorithm;
	}


	public JTextField getTxtKey() {
		return txtKey;
	}

	public void setTxtKey(JTextField txtKey) {
		this.txtKey = txtKey;
	}

	public JComboBox<String> getComboTypeAlgorithm() {
		return comboTypeAlgorithm;
	}


	public void setComboTypeAlgorithm(JComboBox<String> comboTypeAlgorithm) {
		this.comboTypeAlgorithm = comboTypeAlgorithm;
	}

	public JButton getButtonConfirm() {
		return buttonConfirm;
	}

	public void setButtonConfirm(JButton buttonConfirm) {
		this.buttonConfirm = buttonConfirm;
	}

	public String getCOMMAND_CONFIRM() {
		return COMMAND_CONFIRM;
	}
	
	
	
}
