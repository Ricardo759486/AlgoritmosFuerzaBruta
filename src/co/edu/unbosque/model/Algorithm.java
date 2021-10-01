package co.edu.unbosque.model;

public class Algorithm {

	// KMP
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String txt = "yuchengxin is good man";
//		String pat = "is";
//		int[] next = new int[pat.length()];
//		getNext(pat, next);
//		//next[0] = -1;
//		System.out.println(Search(txt, pat, next));
//	}

	public int orKMP(String text, String clave) {
		int[] next = new int[clave.length()];
		getNext(clave, next);
		return Search(text, clave, next);

	}

	// BM 2
//	public static void main(String[] args) {
//        String txt = "THIS IS A BIG TIGER";
//        String pat = "BIG";
//        int[] right = new int[256];
//        getRight(pat, right);
//        System.out.println(Search2(txt, pat, right));
//    }

	public int orBM(String text, String clave) {
		int[] right = new int[256];
		getRight(clave, right);
		return Search2(text, clave, right);
	}

	// KMP 2
//	public static void main(String[] args) {
//		String str="aaabaa";
//		String obj="aaba";
//		int[] next=getNext(obj);
//		System.out.println(kmp(str, obj));
//	}

	// ------------------------------------KMP-----------------------------------------------------

	public int[] getNext(String pat, int[] next) {
		int N = pat.length();
		next[0] = -1; // Condiciones iniciales siguiente [0] = - 1, siguiente [1] = 0
		int k = -1;
		int j = 0;
		while (j < N - 1) {
			if (k == -1 || pat.charAt(j) == pat.charAt(k)) {
				next[++j] = ++k; // Si es igual, salta al siguiente lugar de k al siguiente lugar de j
				if (pat.charAt(j) == pat.charAt(k)) {
					next[j] = next[k]; // Si sigue igual, salta hacia adelante
				}
			} else {
				k = next[k]; // Si no es igual, retrocede a k
			}
		}
		return next;
	}

	public int Search(String txt, String pat, int[] next) {
		int M = txt.length();
		int N = pat.length();
		int i = 0, j = 0;
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

	// ------------------------------------------------------------------------------------------------------------------------

	public int kmp(String str, String tar) {
		int[] next = getNext(tar);
		for (int i = 0, j = 0; i < str.length(); i++) {
			while (j > 0 && str.charAt(i) != tar.charAt(j)) {
				j = next[j - 1];
			}
			if (str.charAt(i) == tar.charAt(j)) {
				j++;
			}
			if (j == tar.length()) {
				return i - j + 1;
			}
		}
		return -1;
	}

	public int[] getNext(String tar) {
		int[] next = new int[tar.length()];
		int k = 0;
		next[0] = 0;
		for (int i = 1; i < next.length; i++) {
			while (k > 0 && tar.charAt(k) != tar.charAt(i)) {
				k = next[k - 1];
			}
			if (tar.charAt(k) == tar.charAt(i)) {
				k++;
			}
			next[i] = k;
		}
		return next;
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

	public int Search2(String txt, String pat, int[] right) {
		int M = txt.length();
		int N = pat.length();
		int skip;
		for (int i = 0; i < M - N; i += skip) {
			skip = 0;
			for (int j = N - 1; j >= 0; j--) {
				if (pat.charAt(j) != txt.charAt(i + j)) {
					skip = j - right[txt.charAt(i + j)];
					if (skip < 1)
						skip = 1;
					break;
				}
			}
			if (skip == 0)
				return i;
		}
		return -1;
	}

}
