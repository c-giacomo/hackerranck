package it.encryption.core;

public class Solve {
	
	public String solve(String s) {
		int column = 0;
		String newS = s.trim();
		double value = Math.sqrt(newS.length());
		
		int intPart = (int)value;
		if ((intPart - value) == 0) column = intPart;
		else column = intPart + 1;
		
		if (intPart * column < newS.length()) intPart++;
		
		char[][] arr = new char[intPart][column];
		
		int index = 0;
		for (int i=0; i < intPart; i++) {
			for (int j=0; j < column; j++) {
				try {
					arr[i][j] = newS.charAt(index);
					index++;
				} catch (StringIndexOutOfBoundsException e) {
					arr[i][j] = '-';
				}
			}
		}
		
		StringBuilder st = new StringBuilder();
		for (int j=0; j < column; j++) {
			for (int i=0; i < intPart; i++) {
				if (arr[i][j] != '-')
					st.append(arr[i][j]);
			}
			st.append(" ");
		}
		
		for (int i=0; i < intPart; i++) {
			for (int j=0; j < column; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		return st.toString();
	}

}
