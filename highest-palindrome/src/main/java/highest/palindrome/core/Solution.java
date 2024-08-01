package highest.palindrome.core;

public class Solution {
	
	public String highestValuePalindrome(String s, int n, int k) {
		char[] l = s.toCharArray();
		int[] visit = new int[n];
		Arrays.fill(visit, 0);
		int i = 0, j = n - 1;
		while (i <= j) {
			if (l[i] != l[j]) {
				if (l[i] < l[j]) {
					l[i] = l[j];
					visit[i] += 1;
				}
				if (l[j] < l[i]) {
					l[j] = l[i];
					visit[j] += 1;
				}
				k -= 1;
			}
			i += 1;
			j -= 1;
		}
		if (k < 0) {
			return "-1";
		}
		i = 0;
		j = n - 1;
		while (i <= j) {
			if (i == j && k >= 1) {
				l[i] = '9';
			}
			if (l[i] < '9') {
				if (visit[i] == 0 && visit[j] == 0 && k >= 2) {
					l[i] = l[j] = '9';
					k -= 2;
				}
				if ((visit[i] == 1 || visit[j] == 1) && k >= 1) {
					l[i] = l[j] = '9';
					k -= 1;
				}
			}
			i += 1;
			j -= 1;
		}
		return new String(l);
	}

}
