package co.edu.unbosque.controller;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;



public class AplMain {

	public static void main(String[] args) throws Exception {
		try {
			UIManager.setLookAndFeel(HiFiLookAndFeel.class.getName());

		} catch (UnsupportedLookAndFeelException e) {
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		
		//Controller control = new Controller();
	}
}