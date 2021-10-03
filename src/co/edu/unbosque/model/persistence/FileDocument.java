package co.edu.unbosque.model.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

public class FileDocument {

	private File file;

	public FileDocument(File fileC) {
		this.file = fileC;
	}

	public String readFile() {

		String line = "";
		String chain = "";

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			line = br.readLine();
			while (line != null) {
				chain += line + "\n";
				line = br.readLine();
			}
			fr.close();
		} catch (IOException e) {
			return null;
		}
		return chain;
	}
}
