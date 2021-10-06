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
	private JScrollPane scrollPane;
	private Highlighter hilit;
	private Highlighter.HighlightPainter painter;

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
	 * @return the cOMMAND_BACK
	 */
	public String getCOMMAND_BACK() {
		return COMMAND_BACK;
	}


}
