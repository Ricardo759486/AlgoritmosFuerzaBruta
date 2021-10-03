package co.edu.unbosque.model;

public class Algorithm {

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

	public String cutText(String text, String key, String algorithm) {
		String message = "";
		if (algorithm.equals("KMP")) {
			String[] array = orKMP(text, key).split(",");
			message = text.replace(key, "*" + key + "*") + "\n\n" + key + " repeated " + array[0] + " times";
		} else if (algorithm.equals("BM")) {
			String[] array = orBM(text, key).split(",");
			message = text.replace(key, "*" + key + "*") + "\n\n" + key + " repeated " + array[0] + " times";
		}

		return message;
	}

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

	public void getRight(String pat, int[] right) {
		for (int i = 0; i < 256; i++) {
			right[i] = -1;
		}
		for (int j = 0; j < pat.length(); j++) {
			right[pat.charAt(j)] = j;
		}
	}

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
