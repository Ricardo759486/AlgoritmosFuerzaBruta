package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.io.File;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

import co.edu.unbosque.controller.Controller;

public class View extends JFrame{

	private WelcomePanel welcomePanel;
	private SelectionPanel selectionPanel;
	private ShowPanel showPanel;
	private JSplitPane splitPane; 

	public View (Controller controller) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(600, 300);
		this.setTitle("Welcome");
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
	
	public void assignListeners(Controller controller) {
		welcomePanel.getButtonSelectFile().addActionListener(controller);
		selectionPanel.getButtonConfirm().addActionListener(controller);
		showPanel.getButtonBack().addActionListener(controller);

	}
	public File connectFileChooser() {
		WindowFileChooser tf = new WindowFileChooser();
		File fileChooser=tf.checkFile();
		this.showInformationMessage("The selected file is: "+fileChooser.getName());
		return fileChooser;
	}
	
	public void showWarningMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Warning message", JOptionPane.WARNING_MESSAGE);
	}
	
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
