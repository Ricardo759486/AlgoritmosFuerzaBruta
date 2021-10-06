/**
 * The package that contains this class
 */
package co.edu.unbosque.model.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

/**
 * Class FileDocument that read the file that the user choose and start reading
 * adding a new line.
 * 
 * @authors Jhoan Ricardo Cuevas Patinio, Robinson Jose Gutierrez Solano, Juana
 *          Valentina Torres Parrado and Juan Felipe Rojas Rodriguez
 * @version 1.0
 *
 */
public class FileDocument {
	/**
	 * Variable file type File
	 */
	private File file;

	/**
	 * Constructor of the class with a parameter file. This will send the file to
	 * read.
	 * 
	 * @param fileC type File fileC will be a "txt" format.
	 */
	public FileDocument(File fileC) {
		this.file = fileC;
	}

	/**
	 * This method will read the file and will be added in the variable to send it.
	 * 
	 * @return variable chain that contains the text.
	 */
	public String readFile() {

		String line = "";
		String chain = "";

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			while ((line = in.readLine()) != null) {
				chain += line + "\n";
			}
			in.close();
		} catch (IOException e) {
			return null;
		}
		return chain;
	}
}
