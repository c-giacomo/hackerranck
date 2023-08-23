package it.permutation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.math3.util.CombinatoricsUtils;

import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

public class NewSolution {
	
	private Set<List<Integer>> set = new HashSet<>();
	
	private final int[] arrorig;
	
	public NewSolution(int[] arr) {
		this.arrorig = reset(arr);
//		stop = CombinatoricsUtils.factorial(arr.length);
		List<Integer> l = Arrays.stream(arr).boxed().collect(Collectors.toList());
		set.add(l);
		print(l);
	}
	
	public void doSome(int[] arr, int i) {
		Tuple2 tuple = swap(arr, i);
		List<Integer> l = Arrays.stream((int[])tuple.getT2()).boxed().collect(Collectors.toList());
		if (!set.contains(l)) {
			set.add(l);
			print(l);
		}
		combine(arr, (Integer)tuple.getT1());
		arr = reset(arrorig);
		doSome(arr, --i);
		
	}
	
	public void combine(int[] arr, int x) {
		for (int i = arr.length-1; i > x; i--) {
			swap(i, arr);
			List l = toList(arr);
			if (!set.contains(l)) {
				set.add(l);
				print(l);
			}
			for (int j=i-1; j <= arr.length - 1; j++) {
				arr = swap(arr, i, j);
				l = toList(arr);
				if (!set.contains(l)) {
					set.add(l);
					print(l);
				} 
//				else {
//					swap(arr, i, j);
//				}
			}
		}
	}
	
	public Integer[] toArray(List l) {
		Integer[] arr = new Integer[l.size()];
		l.toArray(arr);
		return arr;
	}
	
	public List toList(int[] arr) {
		return Arrays.stream(arr).boxed().collect(Collectors.toList());
	}
	
	public void swap(int x, int[] arr) {
		int temp = arr[x-1];
		arr[x-1] = arr[x];
		arr[x] = temp;
	}
	
	public int[] swap(int[] arr, int x, int j) {
		int temp = arr[x];
		arr[x] = arr[j];
		arr[j] = temp;
		return arr;
	}
	
	public Tuple2<Integer, int[]> swap(int[] arr, int x) {
		int temp = arr[x-1];
		arr[x-1] = arr[x];
		arr[x] = temp;
		return Tuples.of(x - 1, arr);
	}
	
	public void print(@SuppressWarnings("rawtypes") List l) {
		System.out.println(l.toString());
	}
	
	public int[] reset(int[] origarr) {
		int[] arr = new int[origarr.length];
		for (int i=0; i<arr.length; i++) {
			arr[i] = origarr[i];
		}
		return arr;
	}

}
