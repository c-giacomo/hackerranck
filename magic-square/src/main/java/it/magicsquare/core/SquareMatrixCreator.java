package it.magicsquare.core;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SquareMatrixCreator {
	
	public void createMatrix() {
		List<int[][]> list = new ArrayList<>();
		
		for (int x=-9; x<=9; x++) {
			for (int y=-9; y<=9; y++) {
				for (int z=-9; z<=9; z++) {
					int[][] arr = buildMatrix(x, y, z);
					if (checkValidity(arr))
						list.add(arr);
					
				}
			}
		}
		
		log.info(String.valueOf(list.size()));
		list.forEach(this::print);
	}

	private void print(int[][] arr) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(String.valueOf(arr[i][j]));
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	private int[][] buildMatrix(int x, int y, int z) {
		int[][] matrix = new int[3][3];
		
		matrix[0][0] = x + y; matrix[0][1] = x - y + z; matrix[0][2] = x - z;
		matrix[1][0] = x - y - z; matrix[1][1] = x; matrix[1][2] = x + y + z;
		matrix[2][0] = x + z; matrix[2][1] = x + y - z; matrix[2][2] = x - y;
		
		return matrix;
	}
	
	private boolean checkValidity(int[][] arr) {
		
		// ROW
		if (arr[0][0] == arr[0][1] || arr[0][0] == arr[0][2] || arr[0][1] == arr[0][2]) return false;
		if (arr[1][0] == arr[1][1] || arr[1][0] == arr[1][2] || arr[1][1] == arr[1][2]) return false;
		if (arr[2][0] == arr[2][1] || arr[2][0] == arr[2][2] || arr[2][1] == arr[2][2]) return false;
		
		// COLUMN
		if (arr[0][0] == arr[1][0] || arr[0][0] == arr[2][0] || arr[1][0] == arr[2][0]) return false;
		if (arr[0][1] == arr[1][1] || arr[0][1] == arr[2][1] || arr[1][1] == arr[2][1]) return false;
		if (arr[0][2] == arr[1][2] || arr[0][2] == arr[2][2] || arr[1][2] == arr[2][2]) return false;
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (arr[i][j] > 9 || arr[i][j] < 0 || arr[i][j] == 0) return false;
			}
		}
		
		if ( (arr[0][0] == arr[1][1]) || (arr[0][0] == arr[2][2]) || (arr[1][1] == arr[2][2]) ||
		   (arr[0][2] == arr[1][1]) || (arr[0][2] == arr[0][0]) || (arr[1][1] == arr[0][0]) ) return false;
		
		return true;
	}

}
