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

public class ShowPanel extends JPanel {

	private final String COMMAND_BACK = "BACK";

	private JLabel labelResult;
	private JTextArea txtAreaShow;
	private JTextArea txtAreaSearch;
	private JButton buttonBack;
	private JScrollPane scrollPane;
	private Color colorfondodefault;
	private Highlighter hilit;
	private Highlighter.HighlightPainter painter;

	public ShowPanel() {
		setLayout(new GridLayout(3, 1));
		labelResult = new JLabel();
		txtAreaShow = new JTextArea();
		txtAreaSearch = new JTextArea();
		buttonBack = new JButton("Back");
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(txtAreaShow);
		buttonBack.setActionCommand(COMMAND_BACK);
		hilit = new DefaultHighlighter();
		painter = new DefaultHighlighter.DefaultHighlightPainter(new Color(150, 150, 77));
		txtAreaShow.setHighlighter(hilit);
		colorfondodefault = txtAreaSearch.getBackground();
		this.add(labelResult);
		this.add(scrollPane);
		this.add(buttonBack);
	}

	public void color() {

	}

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

	/**
	 * @return the buttonBack
	 */
	public JButton getButtonBack() {
		return buttonBack;
	}

	/**
	 * @param buttonBack the buttonBack to set
	 */
	public void setButtonBack(JButton buttonBack) {
		this.buttonBack = buttonBack;
	}

	/**
	 * @return the cOMMAND_BACK
	 */
	public String getCOMMAND_BACK() {
		return COMMAND_BACK;
	}

	/**
	 * @return the txtAreaSearch
	 */
	public JTextArea getTxtAreaSearch() {
		return txtAreaSearch;
	}

	/**
	 * @param txtAreaSearch the txtAreaSearch to set
	 */
	public void setTxtAreaSearch(JTextArea txtAreaSearch) {
		this.txtAreaSearch = txtAreaSearch;
	}

}
