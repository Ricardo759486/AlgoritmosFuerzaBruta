package co.edu.unbosque.model;

import java.io.File;
import java.util.ArrayList;

import javax.swing.UIManager;

import co.edu.unbosque.model.persistence.Archivo;

public class Mundo {

	private String alFile;
	private Algorithm algorithm;
	private File file;
	private Archivo archivo;
	private UIManager UI = new UIManager();

	public Mundo() {
		algorithm = new Algorithm();
	}

	public void cargarFile(File file) {
		archivo = new Archivo(file);
		alFile = archivo.leerArchivo();
	}

	public String busquedaKMP(String clave) {
		return "la palabra: " + clave + " esta en la posicion: " + this.algorithm.orKMP(alFile, clave);
	}

	public String busquedaBM(String clave) {
		return "la palabra: " + clave + " esta en la posicion: " + this.algorithm.orBM(alFile, clave);
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
	 * @return the archivo
	 */
	public Archivo getArchivo() {
		return archivo;
	}

	/**
	 * @param archivo the archivo to set
	 */
	public void setArchivo(Archivo archivo) {
		this.archivo = archivo;
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
