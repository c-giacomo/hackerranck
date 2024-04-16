package it.absolute.permutation.core;

import java.util.ArrayList;
import java.util.List;

public class Solve {

	public List<Integer> solve(int n, int k) {
		List<Integer> permutation = new ArrayList<>();

		if (k == 0) {
			for (int i = 1; i <= n; i++) {
				permutation.add(i);
			}
		} else if (n % (2 * k) == 0) {
			boolean[] position = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				int pos1 = i - k;
				int pos2 = i + k;

				if (pos1 > 0 && !position[pos1]) {
					permutation.add(pos1);
					position[pos1] = true;
				} else if (pos2 <= n && !position[pos2]) {
					permutation.add(pos2);
					position[pos2] = true;
				} else {
					permutation.clear();
					for (int j = 1; j <= n; j++) {
						permutation.add(j);
					}
					break;
				}

			}
		} else {
			permutation.add(-1);
		}

		return permutation;

	}

}
