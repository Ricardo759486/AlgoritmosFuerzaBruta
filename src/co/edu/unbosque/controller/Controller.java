package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.View;
import co.edu.unbosque.view.WindowFileChooser;
import co.edu.unbosque.model.*;

public class Controller implements ActionListener {

	private View view;
	private Mundo mundo;

	public Controller() {
		view = new View(this);
		mundo = new Mundo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals(view.getWelcomePanel().getCOMMAND_SELECT_FILE())) {
			WindowFileChooser tf = new WindowFileChooser();
			mundo.cargarFile(tf.checkFile());
		}
		if (command.equals(view.getSelectionPanel().getCOMMAND_CONFIRM())) {
			this.manageSelectionKeyword();
		}
		if (command.equals(view.getShowPanel().getCOMMAND_BACK())) {
			view.getSplitPane().setRightComponent(view.getSelectionPanel());
		}

	}

	public void manageSelectionKeyword() {
		String[] inputs = view.getSelectionPanel().checkInputs();
		if (inputs[0].equals("0")) {
			if (inputs[2].equals("BM")) {
				view.getShowPanel().getTxtShow().setText(mundo.busquedaBM(inputs[1]));
				view.getSplitPane().setRightComponent(view.getShowPanel());
			} else if (inputs[2].equals("KMP")) {
				view.getShowPanel().getTxtShow().setText(mundo.busquedaKMP(inputs[1]));
				view.getSplitPane().setRightComponent(view.getShowPanel());
			}
		} else {
			view.showErrorMessage(inputs[1]);
		}
	}

}