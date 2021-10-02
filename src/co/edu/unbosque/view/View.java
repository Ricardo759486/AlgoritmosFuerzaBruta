package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
		asignarOyentes(controller);
		repaint();
		revalidate();
	}
	
	public void asignarOyentes(Controller controller) {
		welcomePanel.getButtonSelectFile().addActionListener(controller);
		selectionPanel.getButtonConfirm().addActionListener(controller);
		showPanel.getButtonBack().addActionListener(controller);

	}
	public File conectarFileChooser() {
		WindowFileChooser tf = new WindowFileChooser();
		File fileChooser=tf.checkFile();
		this.showInformationMessage("El archivo seleccionado es: "+fileChooser.getName());
		return fileChooser;
				
	}
	
	public void showWarningMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Mensaje advertencia", JOptionPane.WARNING_MESSAGE);
	}
	
	public void showInformationMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public WelcomePanel getWelcomePanel() {
		return welcomePanel;
	}

	public void setWelcomePanel(WelcomePanel welcomePanel) {
		this.welcomePanel = welcomePanel;
	}

	public SelectionPanel getSelectionPanel() {
		return selectionPanel;
	}

	public void setSelectionPanel(SelectionPanel selectionPanel) {
		this.selectionPanel = selectionPanel;
	}

	public ShowPanel getShowPanel() {
		return showPanel;
	}

	public void setShowPanel(ShowPanel showPanel) {
		this.showPanel = showPanel;
	}

	public JSplitPane getSplitPane() {
		return splitPane;
	}

	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}
	
	
}
