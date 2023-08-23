package it.junglebook.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
	
	Integer[] arr;
	List<List<Integer>> results = new ArrayList<List<Integer>>();
	
	public Integer minGroups(List<Integer> predators) {
		arr = new Integer[predators.size()];
		predators.toArray(arr);
		
		for (int i=0; i < arr.length; i++) {
			if (arr[i] != -1) continue;
			if (arr[i] != -2) {
				Integer pivot = arr[i];
				
				find(arr, Arrays.asList(pivot));
			}
		}
		
		return results.size();
	}
	
	public void find(Integer[] predators, List<Integer> pivot) {
		List<Integer> result = new ArrayList<Integer>();
		for (int j=0; j < pivot.size(); j++) {
			for (int i=0; i < predators.length; i++) {
				if ((int)predators[i] == (int)pivot.get(j)) {
					result.add(i);
					arr[i] = -2;
				}
			}
		}
		
		if (!result.isEmpty()) results.add(result);
		
		if (result.isEmpty()) return;
		find(predators, result);
	}

}
