package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import co.edu.unbosque.controller.Controller;

public class View extends JFrame{

	private WelcomePanel welcomePanel;
	
	public View (Controller controller) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(500, 300);
		this.setTitle("Welcome");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		welcomePanel = new WelcomePanel();
		welcomePanel.setVisible(false);
		this.add(welcomePanel);
	}
	
	public void asignarOyentes(Controller controller) {
		welcomePanel.getBotonSeleccionArchivo().addActionListener(controller);

	}

	public WelcomePanel getWelcomePanel() {
		return welcomePanel;
	}

	public void setWelcomePanel(WelcomePanel welcomePanel) {
		this.welcomePanel = welcomePanel;
	}
	
	
}
