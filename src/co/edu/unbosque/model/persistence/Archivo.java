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

public class Archivo {

	private File file;

	public Archivo(File fileC) {
		this.file = fileC;
	}

	public String leerArchivo() {

		String linea = "";
		String cadena = "";

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			linea = br.readLine();
			while (linea != null) {
				cadena += linea + " ";
				linea = br.readLine();
			}
			fr.close();
		} catch (IOException e) {
			return null;
		}
		return cadena;
	}
}
