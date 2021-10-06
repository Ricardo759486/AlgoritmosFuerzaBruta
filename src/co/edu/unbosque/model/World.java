/**
 * The package that contains this class
 */
/**
 * The package that contains this class
 */
package co.edu.unbosque.model;

import java.io.File;
import java.util.ArrayList;

import javax.swing.UIManager;

import co.edu.unbosque.model.persistence.FileDocument;

/**
 * Class World this class is used for manage between the view and the file that
 * will be used. This file will send it to the class and will be read.
 * 
 * @authors Jhoan Ricardo Cuevas Patinio, Robinson Jose Gutierrez Solano, Juana
 *          Valentina Torres Parrado and Juan Felipe Rojas Rodriguez
 * @version 1.0
 *
 */
public class World {
	/**
	 * Variable alFile type String
	 */
	private String alFile;
	/**
	 * Variable algorithm type Algorithm
	 */
	private Algorithm algorithm;
	/**
	 * Variable file type File
	 */
	private File file;
	/**
	 * Variable fileDocument type FileDocument
	 */
	private FileDocument fileDocument;
	private UIManager UI = new UIManager();

	/**
	 * Constructor of the class that initialise the variables algorithm and file for
	 * being used.
	 */
	public World() {
		algorithm = new Algorithm();
		file = null;
	}

	/**
	 * This method will upload the file to be read. Use a parameter file for the
	 * archive that the user upload.
	 * 
	 * @param file is a type File. file != null
	 */
	public void uploadFile(File file) {
		this.file = file;
		if (file != null) {
			fileDocument = new FileDocument(file);
			alFile = fileDocument.readFile();
		}
	}

	/**
	 * This method will find the word or letter by the algorithm that is selected by
	 * the user.
	 * 
	 * @param text      is a variable type String that put all the text that have
	 *                  the "txt". text != null
	 * @param key       is a variable type String and is the word or letter that
	 *                  user want to find. key != null
	 * @param algorithm is a variable type String that is the algorithm selected by
	 *                  the user. algorithm != "Select algorithm"
	 * @return pos that is a variable type String with the text find
	 */
	public String search(String text, String key, String algorithm) {
		String pos = this.algorithm.cutText(text, key, algorithm);
		return pos;
	}

	/**
	 * @return the alFile
	 */
	public String getAlFile() {
		return alFile;
	}

	/**
	 * @param alFile the alFile to set
	 */
	public void setAlFile(String alFile) {
		this.alFile = alFile;
	}

	/**
	 * @return the algorithm
	 */
	public Algorithm getAlgorithm() {
		return algorithm;
	}

	/**
	 * @param algorithm the algorithm to set
	 */
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * @return the fileDocument
	 */
	public FileDocument getFileDocument() {
		return fileDocument;
	}

	/**
	 * @param fileDocument the fileDocument to set
	 */
	public void setFileDocument(FileDocument fileDocument) {
		this.fileDocument = fileDocument;
	}

	/**
	 * @return the uI
	 */
	public UIManager getUI() {
		return UI;
	}

	/**
	 * @param uI the uI to set
	 */
	public void setUI(UIManager uI) {
		UI = uI;
	}

}
