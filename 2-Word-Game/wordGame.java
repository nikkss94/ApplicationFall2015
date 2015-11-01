package wordGame;

public class wordGame {
	public static int counter = 0;
	public static char[] findRight(char[][] arr, char[] word, int x, int y) {
		char[] findedWord = new char[word.length];
		
		for (int i = y, index = 0; i < arr[0].length && index < word.length; i++, index++) {
			findedWord[index] = arr[x][i];
		}
		
		return findedWord;
	}
	
	public static char[] findLeft(char[][] arr, char[] word, int x, int y) {
		char[] findedWord = new char[word.length];
		
		for (int i = y, index = 0; i >= 0 && index < word.length; i--, index++) {
			findedWord[index] = arr[x][i];
		}
		
		return findedWord;
	}
	
	public static char[] findUp(char[][] arr, char[] word, int x, int y) {
		char[] findedWord = new char[word.length];
		
		for (int i = x, index = 0; i >= 0 && index < word.length; i--, index++) {
			findedWord[index] = arr[i][y];
		}
		
		return findedWord;
	}
	
	public static char[] findDown(char[][] arr, char[] word, int x, int y) {
		char[] findedWord = new char[word.length];
		
		for (int i = x, index = 0; i < arr.length && index < word.length; i++, index++) {
			findedWord[index] = arr[i][y];
		}
		
		return findedWord;
	}
	
	public static char[] findLeftUpDiag(char[][] arr, char[] word, int x, int y) {
		char[] findedWord = new char[word.length];
		
		for (int i = x, j = y, index = 0; i >= 0 && j >= 0 && index < word.length; i--, j--, index++) {
			findedWord[index] = arr[i][j];
		}
		
		return findedWord;
	}
	
	public static char[] findLeftDownDiag(char[][] arr, char[] word, int x, int y) {
		char[] findedWord = new char[word.length];
		
		for (int i = x, j = y, index = 0; i < arr.length && j < arr[0].length && index < word.length; i++, j++, index++) {
			findedWord[index] = arr[i][j];
		}
		
		return findedWord;
	}
	
	public static char[] findRightUpDiag(char[][] arr, char[] word, int x, int y) {
		char[] findedWord = new char[word.length];
		
		for (int i = x, j = y, index = 0; i >= 0 && j < arr[0].length && index < word.length; i--, j++, index++) {
			findedWord[index] = arr[i][j];
		}
		
		return findedWord;
	}
	
	public static char[] findRightDownDiag(char[][] arr, char[] word, int x, int y) {
		char[] findedWord = new char[word.length];
		
		for (int i = x, j = y, index = 0; i < arr.length && j >= 0 && index < word.length; i++, j--, index++) {
			findedWord[index] = arr[i][j];
		}
		
		return findedWord;
	}
	
	public static void wordsCompare(char[][] arr, char[] word, int x, int y) {
		
		if (charCompare(word, findRight(arr, word, x, y))) {
			counter++;
		}
		if (charCompare(word, findRightDownDiag(arr, word, x, y))) {
			counter++;
		}
		if (charCompare(word, findRightUpDiag(arr, word, x, y))) {
			counter++;
		}
		if (charCompare(word, findLeft(arr, word, x, y))) {
			counter++;
		}
		if (charCompare(word, findLeftDownDiag(arr, word, x, y))) {
			counter++;
		}
		if (charCompare(word, findLeftUpDiag(arr, word, x, y))) {
			counter++;
		}
		if (charCompare(word, findUp(arr, word, x, y))) {
			counter++;
		}
		if (charCompare(word, findDown(arr, word, x, y))) {
			counter++;
		}
	}
	
	public static boolean charCompare(char[] word1, char[] word2) {
		if (word1.length != word2.length) {
			return false;
		}
		
		for (int i = 0; i < word1.length; i++) {
			if (word1[i] != word2[i]) {
				return false;
			}
		}
		return true;
	}
}