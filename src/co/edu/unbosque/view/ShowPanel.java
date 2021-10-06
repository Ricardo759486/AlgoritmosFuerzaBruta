/**
 * The package that contains this class
 */
package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 * Class ShowPanel that extends JPanel this class is a part of the window and
 * shows the scroll bar and the text area.
 * 
 * @authors Jhoan Ricardo Cuevas Patinio, Robinson Jose Gutierrez Solano, Juana
 *          Valentina Torres Parrado and Juan Felipe Rojas Rodriguez
 * @version 1.0
 *
 */
public class ShowPanel extends JPanel {
	
	/**
	 * Variable labelResult type JLabel
	 */
	private JLabel labelResult;
	/**
	 * Variable txtAreaShow type JTextArea
	 */
	private JTextArea txtAreaShow;
	/**
	 * Variable scrollPane type JScrollPane
	 */
	private JScrollPane scrollPane;
	/**
	 * Variable hilit type Highlighter
	 */
	private Highlighter hilit;
	/**
	 * Variable painter type Highlighter.HighlightPainter
	 */
	private Highlighter.HighlightPainter painter;

	/**
	 * Constructor of the class that initialise every variable because come from
	 * different classes and make the bounds and layouts.
	 */
	public ShowPanel() {
		setLayout(null);
		labelResult = new JLabel();
		txtAreaShow = new JTextArea();
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(txtAreaShow);
		hilit = new DefaultHighlighter();
		painter = new DefaultHighlighter.DefaultHighlightPainter(new Color(150, 150, 77));
		txtAreaShow.setHighlighter(hilit);
		labelResult.setBounds(0, 0, 800, 50);
		scrollPane.setBounds(0, 40, 815, 200);
		this.add(labelResult);
		this.add(scrollPane);
	}

	/**
	 * This method find in the text the letter or word the user try to find in the
	 * text, next put a highlighter in the word or letter.
	 * 
	 * @param array is a parameter type String[] that is an array this can't be null
	 *              array != null
	 * @param size  is a type int and is used for the position in the text int >= 0
	 */
	public void searchText(String[] array, int size) {
		hilit.removeAllHighlights();
		try {
			for (int i = 1; i < array.length; i++) {
				hilit.addHighlight(Integer.parseInt(array[i]), Integer.parseInt(array[i]) + size, painter);
				txtAreaShow.setCaretPosition(Integer.parseInt(array[i]) + size);
			}
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the labelResult
	 */
	public JLabel getLabelResult() {
		return labelResult;
	}

	/**
	 * @param labelResult the labelResult to set
	 */
	public void setLabelResult(JLabel labelResult) {
		this.labelResult = labelResult;
	}

	/**
	 * @return the txtAreaShow
	 */
	public JTextArea getTxtAreaShow() {
		return txtAreaShow;
	}

	/**
	 * @param txtAreaShow the txtAreaShow to set
	 */
	public void setTxtAreaShow(JTextArea txtAreaShow) {
		this.txtAreaShow = txtAreaShow;
	}


}
