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
			world.uploadFile(view.connectFileChooser());
		}
		if (command.equals(view.getSelectionPanel().getCOMMAND_CONFIRM())) {
			this.manageSelectionKeyword();
		}
		if (command.equals(view.getShowPanel().getCOMMAND_BACK())) {
			view.getSplitPane().setRightComponent(view.getSelectionPanel());
			view.getSelectionPanel().getTxtKey().setText("");
			view.getSelectionPanel().getComboTypeAlgorithm().setSelectedIndex(0);
			;
		}

	}

	public void manageSelectionKeyword() {
		String[] inputs = view.getSelectionPanel().checkInputs();
		if (world.getFile() != null) {
			if (inputs[0].equals("0")) {
				String text = world.getAlFile().toLowerCase();
				view.getShowPanel().getTxtAreaShow().setText(world.getAlFile());
				view.getShowPanel().getLabelResult().setText( inputs[1] + world.search(inputs[1].toLowerCase(), inputs[2]));
				if (inputs[2].equals("BM")) {
					String[] array = world.getAlgorithm().orBM(world.getAlFile().toLowerCase(), inputs[1].toLowerCase())
							.split(",");
					view.getShowPanel().searchText(array, inputs[1].length());
				} else if (inputs[2].equals("KMP")) {
					String[] array = world.getAlgorithm().orKMP(world.getAlFile().toLowerCase(), inputs[1].toLowerCase())
							.split(",");
					view.getShowPanel().searchText(array, inputs[1].length());
				}

				view.getSplitPane().setRightComponent(view.getShowPanel());
			} else {
				view.showWarningMessage(inputs[1]);
			}
		} else {
			view.showWarningMessage("First you must select the .txt file");
		}

	}

}