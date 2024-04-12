package it.permutation.core;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChatGtpSolution {

	private ChatGtpSolution() {
		throw new IllegalStateException("Utility class");
	}

	static void printPermutations(int[] arr, int index) {
		if (index == arr.length) {
			log.info(Arrays.toString(arr));
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
