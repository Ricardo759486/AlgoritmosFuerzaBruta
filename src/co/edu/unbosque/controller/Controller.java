package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.View;
import co.edu.unbosque.view.WindowFileChooser;
import co.edu.unbosque.model.*;

public class Controller implements ActionListener {

	private View view;
	private Mundo mundo;
	WindowFileChooser tf;

	public Controller() {
		view = new View(this);
		mundo = new Mundo();
		// tf = new WindowFileChooser();
//		mundo.cargarFile(tf.checkFile());
//		mundo.busquedaBM("dragon");
//		mundo.busquedaKMP("password");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();

	}

}