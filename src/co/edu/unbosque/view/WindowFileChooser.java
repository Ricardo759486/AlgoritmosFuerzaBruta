package co.edu.unbosque.view;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class WindowFileChooser extends JPanel {
	private JFileChooser jf;
	private FileNameExtensionFilter filter;

//	public static void main(String... args) {
//		WindowFileChooser tf = new WindowFileChooser();
//
//	}

	public WindowFileChooser() {
		jf = new JFileChooser();
		jf.showOpenDialog(WindowFileChooser.this);
		filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		jf.setFileFilter(filter);
		this.checkFile();

	}

	public File checkFile() {
		File f = jf.getSelectedFile();
		while (f == null ) {
			this.printWarningMessage("Debe elegir un archivo en formato .txt");
			jf.showOpenDialog(WindowFileChooser.this);
			jf.setFileFilter(filter);
			f = jf.getSelectedFile();
		}
		return f;
	}

	public void printWarningMessage(String m) {
		JOptionPane.showMessageDialog(null, m, "Mensaje advertencia", JOptionPane.WARNING_MESSAGE);
	}
}