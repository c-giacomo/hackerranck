package it.permutation.mine.iterative.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings({"rawtypes", "unchecked"})
public class MineIterative {
	
	public static void main(String[] arg) {
		int[] arr = {1,2,3,4,5};
		new MineIterative(arr).doSome(arr, arr.length - 1);
	}
	
	
	private final int[] arrorig;
	
	private Set<List<Integer>> set = new HashSet<>();
	
	boolean swap = false;
	
	private Integer pivot = 1;
	
	public MineIterative(int[] arr) {
		this.arrorig = reset(arr);
	}
	
	public void doSome(int[] arr, int i) {
	
		while (i >= 0) {
			if (i == 0) {
				if (pivot == arr.length) break;
				arr = swap(reset(arrorig), 0, pivot);
				++pivot;
				i = arr.length - 1;
			}
			if (i == arr.length - 1) --i;
			else {
				arr = swap(i, arr);
				List l = toList(arr);
				if (!set.contains(l)) {
					print(l);
					set.add(l);
					swap = true;
					++i;
				} else {
					if (swap) {
						arr = swap(i, arr);
						swap = false;
					}
					--i;
				}
			}
		}
		
	}
	
	
	public int[] swap(int x, int[] arr) {
		int temp = arr[x];
		arr[x] = arr[x+1];
		arr[x+1] = temp;
		return arr;
	}
	
	public int[] swap(int[] arr, int x, int j) {
		int temp = arr[x];
		arr[x] = arr[j];
		arr[j] = temp;
		return arr;
	}
	
	public int[] reset(int[] origarr) {
		int[] arr = new int[origarr.length];
		for (int i=0; i<arr.length; i++) {
			arr[i] = origarr[i];
		}
		return arr;
	}
	
	public List toList(int[] arr) {
		return Arrays.stream(arr).boxed().collect(Collectors.toList());
	}
	
	public void print(List l) {
		System.out.println(l.toString());
	}

}
