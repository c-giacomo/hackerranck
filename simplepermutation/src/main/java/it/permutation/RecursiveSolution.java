package it.permutation;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

public class RecursiveSolution {
	
	private Set<List<Integer>> set = new HashSet<>();
	
	private final int[] arrorig;
	
	private int[] temp;
	
	public RecursiveSolution(int[] arr) {
		this.arrorig = reset(arr);
		List<Integer> l = Arrays.stream(arr).boxed().collect(Collectors.toList());
		set.add(l);
		print(l);
	}
	
	public void doSome(int[] arr, int i) {
		Tuple2 tuple = swap(arr, i);
		List<Integer> l = Arrays.stream((int[])tuple.getT2()).boxed().collect(Collectors.toList());
		print(l);
		set.add(l);
		combine(toArray(l), (Integer)tuple.getT1(), arr.length - 1);
//		arr = reset(arrorig);
//		doSome(arr, --i);
		
	}
	
//	DA RIFINIRE - LA MIGLIORE AL MOMENTO
	public void combine(int[] arr, int x, int j) {
		arr = swap(j, arr);
		List l = toList(arr);
		if (!set.contains(l)) {
			set.add(l);
			print(l);
			temp = reset(arr);
			combine(arr, x, arr.length - 1);
		} else {
			combine(temp == null ? reset(arrorig) : temp, x, --j);
		}
	}
	
	public int[] swap(int[] arr, int x, int j) {
		int temp = arr[x];
		arr[x] = arr[j];
		arr[j] = temp;
		return arr;
	}
	
	public int[] swap(int x, int[] arr) {
		int temp = arr[x-1];
		arr[x-1] = arr[x];
		arr[x] = temp;
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
	
	public int[] toArray(List<Integer> l) {
		int[] arr = new int[l.size()];
		for (int i=0; i < l.size(); i++)
			arr[i] = l.get(i);
		return arr;
	}
	
	public List toList(int[] arr) {
		return Arrays.stream(arr).boxed().collect(Collectors.toList());
	}
	
	public int[] reset(int[] origarr) {
		int[] arr = new int[origarr.length];
		for (int i=0; i<arr.length; i++) {
			arr[i] = origarr[i];
		}
		return arr;
	}

}
