/**
 * The package that contains this class
 */
package co.edu.unbosque.controller;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

/**
 * Class AplMain that call controller because is the union with the model and
 * the view.
 * 
 * @authors Jhoan Ricardo Cuevas Patinio, Robinson Jose Gutierrez Solano, Juana
 *          Valentina Torres Parrado and Juan Felipe Rojas Rodriguez
 * @version 1.0
 *
 */
public class AplMain {

	public static void main(String[] args) throws Exception {
		try {
			UIManager.setLookAndFeel(HiFiLookAndFeel.class.getName());

		} catch (UnsupportedLookAndFeelException e) {
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		
		Controller control = new Controller();
	}
}