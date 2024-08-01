package highest.palindrome;

import highest.palindrome.core.Solution;

public class Main {

	public static void main(String[] args) {
		String s = "12321"; // 5,1 -> 12921
//		String s = "932239"; // 6,2 -> 992299
//		String s = "3943";  // 4,1 -> 3993
		Solution sol = new Solution();
		String result = sol.highestValuePalindrome(s, 5, 1);
		System.out.println(result);

	}

}
