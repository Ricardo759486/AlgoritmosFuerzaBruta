package co.edu.unbosque.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.View;
import co.edu.unbosque.model.*;

public class Controller implements ActionListener {
	
	private View principal;
	private Algorithm algoritmo;
	
	public Controller() {
		principal= new View();
		algoritmo= new Algorithm();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}