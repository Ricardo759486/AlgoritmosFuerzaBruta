/**
 * The package that contains this class
 */
package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.View;
import co.edu.unbosque.model.*;

/**
 * Class Controller that implements the interface ActionListener in this class
 * contains the model and the view to attached and make the methods totally
 * functional.
 * 
 * @authors Jhoan Ricardo Cuevas Patinio, Robinson Jose Gutierrez Solano, Juana
 *          Valentina Torres Parrado and Juan Felipe Rojas Rodriguez
 * @version 1.0
 *
 */
public class Controller implements ActionListener {
	/**
	 * Variable view type View
	 */
	private View view;
	/**
	 * Variable world type World
	 */
	private World world;

	/**
	 * Constructor of the class that initialise the variables because became from
	 * the classes.
	 */
	public Controller() {
		view = new View(this);
		world = new World();
	}

	/**
	 * This method make the functionality of the buttons that is in the View class.
	 */
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
	}

	/**
	 * This method will control that the user write and choose a file to be read by
	 * the algorithm.
	 * 
	 */
	public void manageSelectionKeyword() {
		String[] inputs = view.getSelectionPanel().checkInputs();
		String text = world.getAlFile();
		if (world.getFile() != null) {
			if (inputs[0].equals("0")) {
				if (view.getSelectionPanel().getCheckSearch().isSelected() == true) {
					this.searchFor(text, inputs[1], inputs[2]);
				} else {
					this.searchFor(text.toLowerCase(), inputs[1].toLowerCase(), inputs[2]);
				}
			} else {
				view.showWarningMessage(inputs[1]);
			}
		} else {
			view.showWarningMessage("First you must select the .txt file");
		}
	}
	
	/**
	 * 
	 * @param text
	 * @param inputs1
	 * @param inputs2
	 */
	public void searchFor(String text, String inputs1, String inputs2) {

		view.getSelectionPanel().getShowPanel().getTxtAreaShow().setText(world.getAlFile());
		view.getSelectionPanel().getShowPanel().getLabelResult()
				.setText(inputs1 + world.search(text, inputs1, inputs2));
		if (inputs2.equals("BM")) {
			String[] array = world.getAlgorithm().orBM(text, inputs1).split(",");
			view.getSelectionPanel().getShowPanel().searchText(array, inputs1.length());
		} else if (inputs2.equals("KMP")) {
			String[] array = world.getAlgorithm().orKMP(text, inputs1).split(",");
			view.getSelectionPanel().getShowPanel().searchText(array, inputs1.length());
		}
	}

}