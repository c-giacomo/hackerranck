package it.permutation.core;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MySolution {
	
	private final Set<List<Integer>> result;
	
	public MySolution() {
		result = new HashSet<>();
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public Set<List<Integer>> solve(int[] arr, int i, int j) {
		int factorial = calculateFactorial(arr.length); 
		while (result.size() < factorial) {
			if (i > arr.length - 1) {
				i--;
				j = i + 1;
			}
			if (j == arr.length) j--;
			arr = swap(arr, i, j);
			List l = toList(arr);
			if (!result.contains(l)) {
				result.add(l);
				i = arr.length - 2;
				j = i+1;
			} else if (j < arr.length - 1) {
				j++;
			} else {
				i--;
				j = i+1;
			}
		}
		return result;
	}
	
	public int calculateFactorial(int n) {
		int res = 1;
		for (int i=n; i >= 2; i--) {
			res *= i;
		}
		return res;
	}
	
	public int[] swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}
	
	public int[] swap(int[] arr, int i) {
		int temp = arr[i];
		arr[i] = arr[i+1];
		arr[i+1] = temp;
		return arr;
	}
	
	public List<Integer> toList(int[] arr) {
		return Arrays.stream(arr).boxed().collect(Collectors.toList());
	}

}
