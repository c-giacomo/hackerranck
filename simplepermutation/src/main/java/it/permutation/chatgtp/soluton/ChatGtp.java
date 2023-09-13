package it.permutation.chatgtp.soluton;

import java.util.Arrays;

public class ChatGtp {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		printPermutations(arr, 0);
	}
	
	
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
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
