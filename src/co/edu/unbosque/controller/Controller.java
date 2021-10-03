package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.View;
import co.edu.unbosque.model.*;

public class Controller implements ActionListener {

	private View view;
	private World world;

	public Controller() {
		view = new View(this);
		world = new World();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals(view.getWelcomePanel().getCOMMAND_SELECT_FILE())) {
			world.uploadFile(view.conectarFileChooser());
		}
		if (command.equals(view.getSelectionPanel().getCOMMAND_CONFIRM())) {
			this.manageSelectionKeyword();
		}
		if (command.equals(view.getShowPanel().getCOMMAND_BACK())) {
			view.getSplitPane().setRightComponent(view.getSelectionPanel());
			view.getSelectionPanel().getTxtKey().setText("");
		}

	}

	public void manageSelectionKeyword() {
		String[] inputs = view.getSelectionPanel().checkInputs();
		if (world.getFile() != null) {
			if (inputs[0].equals("0")) {
				view.getShowPanel().getTxtAreaShow().setText(world.search(inputs[1], inputs[2]));
				view.getSplitPane().setRightComponent(view.getShowPanel());
			} else {
				view.showWarningMessage(inputs[1]);
			}
		} else {
			view.showWarningMessage("First you must select the .txt file");
		}

	}

}