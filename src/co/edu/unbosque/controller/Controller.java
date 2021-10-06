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
			view.getSelectionPanel().getShowPanel().getTxtAreaShow().setText(world.getAlFile());
		}
		if (command.equals(view.getSelectionPanel().getCOMMAND_CONFIRM())) {
			this.manageSelectionKeyword();
		}
		if (command.equals(view.getShowPanel().getCOMMAND_BACK())) {
			view.getSplitPane().setRightComponent(view.getSelectionPanel());
			view.getSelectionPanel().getTxtKey().setText("");
			view.getSelectionPanel().getComboTypeAlgorithm().setSelectedIndex(0);
		}

	}

	public void manageSelectionKeyword() {
		String[] inputs = view.getSelectionPanel().checkInputs();
		String text = world.getAlFile();
		if (world.getFile() != null) {
			if (inputs[0].equals("0")) {
				if(view.getSelectionPanel().getCheckSearch().isSelected() == true) {
					this.searchFor(text, inputs[1], inputs[2]);
				}else {
					this.searchFor(text.toLowerCase(), inputs[1].toLowerCase(), inputs[2]);
				}
			} else {
				view.showWarningMessage(inputs[1]);
			}
		} else {
			view.showWarningMessage("First you must select the .txt file");
		}
	}
	
	public void searchFor(String text, String inputs1, String inputs2) {
		
		view.getSelectionPanel().getShowPanel().getTxtAreaShow().setText(world.getAlFile());
		view.getSelectionPanel().getShowPanel().getLabelResult().setText( inputs1 + world.search(text, inputs1, inputs2));
		if (inputs2.equals("BM")) {
			String[] array = world.getAlgorithm().orBM(text, inputs1)
					.split(",");
			view.getSelectionPanel().getShowPanel().searchText(array, inputs1.length());
		} else if (inputs2.equals("KMP")) {
			String[] array = world.getAlgorithm().orKMP(text, inputs1)
					.split(",");
			view.getSelectionPanel().getShowPanel().searchText(array, inputs1.length());
		}
	}

}