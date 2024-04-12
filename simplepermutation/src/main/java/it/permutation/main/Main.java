package it.permutation.main;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import it.permutation.core.MySolution;
import it.permutation.utility.ListComparator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		MySolution s = new MySolution();
		Set<List<Integer>> result = s.solve(arr, arr.length - 1, arr.length - 1);
		List<List<Integer>> list = result.stream().collect(Collectors.toList());
		Collections.sort(list, new ListComparator<>());
		list.forEach(i -> log.info(i.toString()));
		
	}

}


