package it.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	static List<List<Integer>> set = new ArrayList<>();
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		new RecursiveSolution(arr).doSome(arr, arr.length - 1);
	}

//	public static void main(String[] args) {
//		int[] arr = {1, 2, 3, 4, 5};
//		printPermutations(arr, 0);
////		set.forEach(p -> {
////			p.forEach(System.out::print);
////			System.out.println();
////		});
//	}

	static void printPermutations(int[] arr, int index) {
		if (index == arr.length) {
			System.out.println(Arrays.toString(arr));
			return;
		}

		for (int i = index; i < arr.length; i++) {
			swap(arr, index, i);
			printPermutations(arr, index + 1);
			swap(arr, index, i);
		}
	}

	static void swap(int[] arr, int i, int j) {
		if (i != j) {
			List<Integer> l = Arrays.asList(i,j);
			set.add(l);
		}
			
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


}
