package it.permutation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.math3.util.CombinatoricsUtils;

import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;
import reactor.util.function.Tuples;

public class Solution {
	
	private long stop;
	
	private final int[] arrorig;
	
	private int pivot = 0;
	
	private Set<List<Integer>> set = new HashSet<>();
	
	public Solution(int[] arr) {
		this.arrorig = reset(arr);
		stop = CombinatoricsUtils.factorial(arr.length);
		List<Integer> l = Arrays.stream(arr).boxed().collect(Collectors.toList());
		set.add(l);
		print(l);
	}
	
	public void doSome(int[] arr, int x, Tuple3 tup) {
 		Tuple3 t = swap(arr, x, tup);
		List<Integer> l = Arrays.stream((int[])t.getT3()).boxed().collect(Collectors.toList());
		if (!set.contains(l)) {
			set.add(l);
			print(l);
			doSome(arr, arr.length - 1, t);
		} else {
			if ((Integer)t.getT2() > 0) {
				swap(arr, x, t);
				doSome(arr, --x, t);
			} else {
				doSome((int[])t.getT3(), --x, t);
			}
		}
		
	}

//	FUNZIONA FINO A N = 4
//	public void doSome(int[] arr, int x) {
//		if (set.size() == stop) return;
//		if (x == 1) {
//			arr = changeFirst(reset(arrorig), 0, increasepPivot());
//			x = arr.length - 1;
//		}
//		arr = swap(arr, x);
//		List<Integer> l = Arrays.stream(arr).boxed().collect(Collectors.toList());
//		if (!set.contains(l)) {
//			set.add(l);
//			print(l);
//			doSome(arr, arr.length - 1);
//		} else {
//			swap(arr, x);
//			doSome(arr, --x);
//		}
//	}
	
	public void print(@SuppressWarnings("rawtypes") List l) {
		System.out.println(l.toString());
	}
	
	public int increasepPivot() {
		return ++pivot;
	}
	
	public Tuple3<Integer, Integer, int[]> swap(int[] arr, int x, Tuple3 tuple) {
		int temp = arr[x-1];
		if ((Integer)tuple.getT1() != arr[x] && Math.abs((Integer)tuple.getT1() - x) > 1) {
			arr[x-1] = arr[x];
			arr[x] = temp;
			return Tuples.of(x-1, temp, arr);
		} else {
			arr = reset(arrorig);
			return Tuples.of(-1, -1, arr);
		}
	}
	
	public int[] swap(int[] arr, int x, int j) {
		int temp = arr[x];
		arr[x] = arr[j];
		arr[j] = temp;
		return arr;
	}
	
	public int[] changeFirst(int[] arr, int x, int j) {
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
}
