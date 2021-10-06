/**
 * The package that contains this class
 */
package co.edu.unbosque.model;

/**
 * Class Algorithm thats for the algorithms KMP or BM for the purpose of the
 * prgram.
 * 
 * @authors Jhoan Ricardo Cuevas Patinio, Robinson Jose Gutierrez Solano, Juana
 *          Valentina Torres Parrado and Juan Felipe Rojas Rodriguez
 * @version 1.0
 *
 */

public class Algorithm {
	/**
	 * This method is for find by the algorithm KMP and have two parameters, one is
	 * for the text and the word o letter that is the key
	 * 
	 * @param text is type String and have the text of the user. text != null
	 * @param key  is the word or letter to find type String. key != null
	 * @return the position with the message
	 */
	public String orKMP(String text, String key) {
		String message = "";
		int a = 0;
		int[] next = new int[key.length()];
		getNext(key, next);
		int i = 0;
		while (implementKMP(text, key, next, i) != -1) {
			message += implementKMP(text, key, next, i) + ",";
			i = implementKMP(text, key, next, i) + 1;
			implementKMP(text, key, next, i);
			a++;
		}
		return a + "," + message;
	}

	/**
	 * This method cut the text to be read in search by the method that user select.
	 * 
	 * @param text      is type String and have the text of the user. text != null
	 * @param key       is the word or letter to find type String. key != null
	 * @param algorithm is a variable type String that is the algorithm selected by
	 *                  the user. algorithm != "Select algorithm"
	 * @return message with the times repeated in the text the word or letter
	 */
	public String cutText(String text, String key, String algorithm) {
		String message = "";
		if (algorithm.equals("KMP")) {
			String[] array = orKMP(text, key).split(",");
			message = " repeated " + array[0] + " times\n\n" + message.replace(" ", "\n");
		} else if (algorithm.equals("BM")) {
			String[] array = orBM(text, key).split(",");
			message = " repeated " + array[0] + " times\n\n" + message.replace(" ", "\n");
		}

		return message;
	}

	/**
	 * This method is for find by the algorithm KMP and have two parameters, one is
	 * for the text and the word o letter that is the key
	 * 
	 * @param text is type String and have the text of the user. text != null
	 * @param key  is the word or letter to find type String. key != null
	 * @return the position with the message
	 */
	public String orBM(String text, String key) {
		int[] right = new int[256];
		String message = "";
		int a = 0;
		int i = 0;
		getRight(key, right);
		while (implementBM(text, key, right, i) != -1) {
			message += implementBM(text, key, right, i) + ",";
			i = implementBM(text, key, right, i) + 1;
			implementBM(text, key, right, i);
			a++;
		}
		return a + "," + message;
	}

	// ------------------------------------KMP-----------------------------------------------------

	/**
	 * This method will check the the next position in the text for method KMP.
	 * 
	 * @param pat  is type String and is for text. pat != null
	 * @param next is an array of int and will do the positions.
	 * @return the next position in the text.
	 */
	public int[] getNext(String pat, int[] next) {
		int N = pat.length();
		next[0] = -1;
		int k = -1;
		int j = 0;
		while (j < N - 1) {
			if (k == -1 || pat.charAt(j) == pat.charAt(k)) {
				next[++j] = ++k;
				if (pat.charAt(j) == pat.charAt(k)) {
					next[j] = next[k];
				}
			} else {
				k = next[k];
			}
		}
		return next;
	}

	/**
	 * This method will implement the algorithm of KMP with the text that user
	 * entered before.
	 * 
	 * @param txt  is the variable type String and is the text of the user. txt !=
	 *             null
	 * @param pat  will be the key that is word or letter that user wants to find.
	 *             pat != null
	 * @param next is an array of int and will do the positions.
	 * @param i    is the variable type int and is the position where will be
	 *             starting find the word or letter. i >= 0
	 * @return the position where is find it the word o letter in the text if
	 *         there's not have any letter will be return -1 .
	 */
	public int implementKMP(String txt, String pat, int[] next, int i) {
		int M = txt.length();
		int N = pat.length();
		int j = 0;
		while (i < M && j < N) {
			if (j == -1 || txt.charAt(i) == pat.charAt(j)) {
				j++;
				i++;
			} else {
				j = next[j];
			}
		}
		if (j == N)
			return i - j;
		else
			return -1;
	}

	// --------------------------------------------------BM----------------------------------------------------------------------

	/**
	 * This method will get the position with the key that is send it in the
	 * parameter.
	 * 
	 * @param pat   is type String an is the key. pat != null
	 * @param right is an array of int and will do the positions.
	 */
	public void getRight(String pat, int[] right) {
		for (int i = 0; i < 256; i++) {
			right[i] = -1;
		}
		for (int j = 0; j < pat.length(); j++) {
			right[pat.charAt(j)] = j;
		}
	}

	/**
	 * This method will implement the algorithm of BM with the text that user
	 * entered before.
	 * 
	 * @param txt   is the variable type String and is the text of the user. txt !=
	 *              null
	 * @param pat   will be the key that is word or letter that user wants to find.
	 *              pat != null
	 * @param right is an array of int and will do the positions.
	 * @param i     is the variable type int and is the position where will be
	 *              starting find the word or letter. i >= 0
	 * @return the position where is find it the word o letter in the text if
	 *         there's not have any letter will be return -1 .
	 */
	public int implementBM(String txt, String pat, int[] right, int i) {
		int M = txt.length();
		int N = pat.length();
		int skip;
		for (int k = i; k < M - N; k += skip) {
			skip = 0;
			for (int j = N - 1; j >= 0; j--) {
				if (pat.charAt(j) != txt.charAt(k + j)) {
					skip = j - right[txt.charAt(k + j)];
					if (skip < 1)
						skip = 1;
					break;
				}
			}
			if (skip == 0)
				return k;
		}
		return -1;
	}

}
