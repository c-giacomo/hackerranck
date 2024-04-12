package it.absolute.permutation.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solve {
	
	public List<Integer> solve(int n, int k) {
		int[] arr = new int[n];
		for (int i=0; i < n; i++) arr[i] = i+1;
		
		
		List<List<Integer>> perm = new ArrayList<>(); // TODO method that generate n! simple permutation
		
		List<Integer> result = Arrays.asList(-1);
		
		boolean equals = false;
		for (int i=0; i < perm.size(); i++) {
			List<Integer> lista = perm.get(i);
			for (int j=0; j < lista.size(); j++) {
				if ((Math.abs(lista.get(j) - arr[j])) == k) {
					equals = true;
				} else {
					equals = false;
					break;
				}
			}
			if (equals) {
				result = lista;
				System.out.println(result);
			}
		}
		
		return result;
		
	}

}
