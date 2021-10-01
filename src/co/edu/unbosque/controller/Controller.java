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
		
		if(command.equals(view.getWelcomePanel().getCOMMAND_SELECT_FILE())) {
			WindowFileChooser tf = new WindowFileChooser();
			mundo.cargarFile(tf.checkFile());
		}

	}

}