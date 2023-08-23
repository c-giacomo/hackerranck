package it.queens.core;

import java.util.List;

public class Solve {
	
	static int queenRow = 0;
	static int queenCol = 0;

	public static int solve(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
		int matrix[][] = new int[n][n];

		matrix[r_q - 1][c_q - 1] = 1; // posizione regina;

		for (int i = 0; i < obstacles.size(); i++) {
			List<Integer> subList = obstacles.get(i);
			matrix[subList.get(0) - 1][subList.get(1) - 1] = 2;
		}
		
		for (int i=0; i<n; i++) {
        	for (int j=0; j<n; j++) {
        		System.out.print(matrix[i][j] + " ");
        	}
        	System.out.println();
        }

		Integer cells = 0;
		
		
		/** up **/
		reset(r_q - 1, c_q - 1);
		boolean up = true;
		queenRow--;
		while (up) {
			if (queenRow >= 0) {
				if (matrix[queenRow][queenCol] == 0) {
					cells++;
					queenRow--;
				} else up = false;
			} else up = false;
		}
		
		/** ne **/
		reset(r_q - 1, c_q - 1);
		boolean ne = true;
		queenCol++;
		queenRow--;
		while (ne) {
			if (queenCol < n && queenRow >= 0) {
				if (matrix[queenRow][queenCol] == 0) {
					cells++;
					queenCol++;
					queenRow--;
				} else ne = false;
			} else ne = false;
		}
		
		/** east **/
		reset(r_q - 1, c_q - 1);
		boolean e = true;
		queenCol++;
		while (e) {
			if (queenCol < n) {
				if (matrix[queenRow][queenCol] == 0) {
					cells++;
					queenCol++;
				} else e = false;
			} else e = false;
		}
		
		/** southest **/
		reset(r_q - 1, c_q - 1);
		boolean se = true;
		queenCol++;
		queenRow++;
		while (se) {
			if (queenCol < n && queenRow < n) {
				if (matrix[queenRow][queenCol] == 0) {
					cells++;
					queenCol++;
					queenRow++;
				} else se = false;
			} else se = false;
		}
		
		/** down **/
		reset(r_q - 1, c_q - 1);
		boolean d = true;
		queenRow++;
		while (d) {
			if (queenRow < n) {
				if (matrix[queenRow][queenCol] == 0) {
					cells++;
					queenRow++;
				} else d = false;
			} else d = false;
		}
		
		/** southovest **/
		reset(r_q - 1, c_q - 1);
		boolean so = true;
		queenCol--;
		queenRow++;
		while (so) {
			if (queenCol >= 0 && queenRow < n) {
				if (matrix[queenRow][queenCol] == 0) {
					cells++;
					queenCol--;
					queenRow++;
				} else so = false;
			} else so = false;
		}
		
		/** ovest **/
		reset(r_q - 1, c_q - 1);
		boolean o = true;
		queenCol--;
		while (o) {
			if (queenCol >= 0) {
				if (matrix[queenRow][queenCol] == 0) {
					cells++;
					queenCol--;
				} else o = false;
			} else o = false;
		}
		
		
		/** northovest **/
		reset(r_q - 1, c_q - 1);
		boolean no = true;
		queenRow--;
		queenCol--;
		while (no) {
			if (queenRow >= 0 && queenCol >= 0) {
				if (matrix[queenRow][queenCol] == 0) {
					cells++;
					queenRow--;
					queenCol--;
				} else no = false;
			} else no = false;
		}

		System.out.println(cells);
		return cells;
	}
	
	public static void reset(int row, int col) {
		queenRow = row;
		queenCol = col;
	}

}
