package it.magicsquare.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solve {

	public int solve(List<List<Integer>> list) {
		int[][] arr = convert(list); 
		int[][][] square = {
			   { {2,7,6},{9,5,1},{4,3,8} }, 
			   { {2,9,4},{7,5,3},{6,1,8} },
               { {4,3,8},{9,5,1},{2,7,6} },
               { {4,9,2},{3,5,7},{8,1,6} },
               { {6,1,8},{7,5,3},{2,9,4} },
               { {6,7,2},{1,5,9},{8,3,4} },
               { {8,1,6},{3,5,7},{4,9,2} },
               { {8,3,4},{1,5,9},{6,7,2} }
        };
		
		List<Integer> sum = new ArrayList<>();
		
		for (int i=0; i < 8; i++) {
			int[][] temp = square[i];
			int partialSum = 0;
			for (int j = 0; j<3; j++) {
				for (int z = 0; z<3; z++) {
					partialSum += Math.abs(arr[j][z] - temp[j][z]);
				}
			}
			sum.add(partialSum);
		}
		
		return Collections.min(sum);
	}

	/*
	private void print(int[][] arr) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(String.valueOf(arr[i][j]));
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	*/
	
	private int[][] convert(List<List<Integer>> list) {
		int[][] arr = new int[3][3];
		for (int i = 0; i < 3; i++) {
			List<Integer> l = list.get(i);
			for (int j = 0; j < 3; j++) {
				arr[i][j] = l.get(j);
			}
		}
		
		return arr;
	}

}
