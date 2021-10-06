/**
 * The package that contains this class
 */
package co.edu.unbosque.view;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Class WindowFileChooser that extends JPanel this class contains the methods of the archive
 * selection that's ".txt"
 * @authors Jhoan Ricardo Cuevas Patinio, Robinson Jose Gutierrez Solano, Juana
 *          Valentina Torres Parrado and Juan Felipe Rojas Rodriguez
 * @version 1.0
 * 
 */

public class WindowFileChooser extends JPanel {
	/**
	 * Variable jf from JFileChooser
	 */
	private JFileChooser jf;
	/**
	 * Variable filter from FileNameExtensionFilter
	 */
	private FileNameExtensionFilter filter;
	
	/**
	 * Constructor from the class WindowFileChooser
	 * that initialise the variables 
	 */
	public WindowFileChooser() {
		jf = new JFileChooser();
		jf.showOpenDialog(WindowFileChooser.this);
		filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		jf.setFileFilter(filter);
	}
	
	/**
	 * This method check if the file is selected from the view
	 * if get selected if the format ".txt" it will used the 
	 * file for open.
	 * @return it return a "f" that is the file is choose by the 
	 * user and it will be open.
	 */
	public File checkFile() {
		File f = jf.getSelectedFile();
		while (f == null) {
			this.printWarningMessage("You must choose a .txt file format");
			jf.showOpenDialog(WindowFileChooser.this);
			jf.setFileFilter(filter);
			f = jf.getSelectedFile();
		}
		return f;
	}
	
	/**
	 * This method will use a parameter with a message send it at 
	 * the moment is used.
	 * @param String message to show in JOptionPane for warning the user. String message != null
	 */
	public void printWarningMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Warning message", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * @return the jf
	 */
	public JFileChooser getJf() {
		return jf;
	}

	/**
	 * @param jf the jf to set
	 */
	public void setJf(JFileChooser jf) {
		this.jf = jf;
	}

	/**
	 * @return the filter
	 */
	public FileNameExtensionFilter getFilter() {
		return filter;
	}

	/**
	 * @param filter the filter to set
	 */
	public void setFilter(FileNameExtensionFilter filter) {
		this.filter = filter;
	}

}