package co.edu.unbosque.model;

import java.io.File;
import java.util.ArrayList;

import javax.swing.UIManager;

import co.edu.unbosque.model.persistence.FileDocument;

public class World {

	private String alFile;
	private Algorithm algorithm;
	private File file;
	private FileDocument fileDocument;
	private UIManager UI = new UIManager();

	public World() {
		algorithm = new Algorithm();
		file = null;
	}

	public void uploadFile(File file) {
		this.file = file;
		if (file != null) {
			fileDocument = new FileDocument(file);
			alFile = fileDocument.readFile();
		}
	}

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
