package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WelcomePanel extends JPanel{
	
	private final String COMMAND_SELECT_FILE = "SELCT_FILE";
	
	private JTextField txtWelcome;
	private JButton botonSeleccionArchivo;
	
	public WelcomePanel() {
		setLayout(new GridLayout(2, 1));
		txtWelcome = new JTextField("Welcome");
		botonSeleccionArchivo = new JButton("Select file");
		add(txtWelcome);
		add(botonSeleccionArchivo);
		
		botonSeleccionArchivo.setActionCommand(COMMAND_SELECT_FILE);
	}

	public JButton getBotonSeleccionArchivo() {
		return botonSeleccionArchivo;
		
	}

	public void setBotonSeleccionArchivo(JButton botonSeleccionArchivo) {
		this.botonSeleccionArchivo = botonSeleccionArchivo;
	}
	
}
