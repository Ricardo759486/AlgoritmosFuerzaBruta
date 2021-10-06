/**
 * The package that contains this class
 */
package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

import co.edu.unbosque.controller.Controller;

/**
 * This class contains all of the view for show in the frame, every panel, text
 * fields and everything.
 * 
 * @authors Jhoan Ricardo Cuevas Patinio, Robinson Jose Gutierrez Solano, Juana
 *          Valentina Torres Parrado and Juan Felipe Rojas Rodriguez
 * @version 1.0
 *
 */
public class View extends JFrame {
	/**
	 * Variable welcomePanle type WelcomePanel
	 */
	private WelcomePanel welcomePanel;
	/**
	 * Variable selectionPanel type SelectionPanel
	 */
	private SelectionPanel selectionPanel;
	/**
	 * Variable showPanel type ShowPanel
	 */
	private ShowPanel showPanel;
	/**
	 * Variable splitPanel type JSplitPane
	 */
	private JSplitPane splitPane;

	/**
	 * This constructor will have a parameter from controller to initialise in the
	 * controller and inside the constructor will initialise every class that we
	 * have in the variables. Creates the layouts and make the size of the window
	 * 
	 * @param controller type Controller that bring the class.
	 */
	public View(Controller controller) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(900, 500);
		this.setTitle("BM / KMP Program");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);

		welcomePanel = new WelcomePanel();
		selectionPanel = new SelectionPanel();
		showPanel = new ShowPanel();
		splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setRightComponent(selectionPanel);
		splitPane.setLeftComponent(welcomePanel);
		getContentPane().add(splitPane);
		assignListeners(controller);
		repaint();
		revalidate();
	}

	/**
	 * This method will assign the listeners for the buttons that we create in the
	 * class for the purpose that we can select some items in the window and make it
	 * functional for the user.
	 * 
	 * @param controller type Controller that bring the class.
	 */
	public void assignListeners(Controller controller) {
		welcomePanel.getButtonSelectFile().addActionListener(controller);
		selectionPanel.getButtonConfirm().addActionListener(controller);
	}

	/**
	 * This method type File will return the file choose by the user, and will show
	 * the a message with the name of the file.
	 * 
	 * @return fileChooser with the name and the archive choose by the user.
	 */
	public File connectFileChooser() {
		WindowFileChooser tf = new WindowFileChooser();
		File fileChooser = tf.checkFile();
		this.showInformationMessage("The selected file is: " + fileChooser.getName());
		return fileChooser;
	}

	/**
	 * This method will use a parameter with a message send it at the moment is
	 * used.
	 * 
	 * @param String message to show in JOptionPane for warning the user. String
	 *               message != null
	 */
	public void showWarningMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Warning message", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * This method will use a parameter with a message send it at the moment is
	 * used.
	 * 
	 * @param String message to show in JOptionPane for show the information to the
	 *               user. String message != null
	 */
	public void showInformationMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * @return the welcomePanel
	 */
	public WelcomePanel getWelcomePanel() {
		return welcomePanel;
	}

	/**
	 * @param welcomePanel the welcomePanel to set
	 */
	public void setWelcomePanel(WelcomePanel welcomePanel) {
		this.welcomePanel = welcomePanel;
	}

	/**
	 * @return the selectionPanel
	 */
	public SelectionPanel getSelectionPanel() {
		return selectionPanel;
	}

	/**
	 * @param selectionPanel the selectionPanel to set
	 */
	public void setSelectionPanel(SelectionPanel selectionPanel) {
		this.selectionPanel = selectionPanel;
	}

	/**
	 * @return the showPanel
	 */
	public ShowPanel getShowPanel() {
		return showPanel;
	}

	/**
	 * @param showPanel the showPanel to set
	 */
	public void setShowPanel(ShowPanel showPanel) {
		this.showPanel = showPanel;
	}

	/**
	 * @return the splitPane
	 */
	public JSplitPane getSplitPane() {
		return splitPane;
	}

	/**
	 * @param splitPane the splitPane to set
	 */
	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}

}
