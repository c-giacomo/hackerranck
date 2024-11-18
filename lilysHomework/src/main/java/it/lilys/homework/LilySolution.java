package it.lilys.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class LilySolution {
	
	public int solve(List<Integer> list) {
		Integer[] original = new Integer[list.size()];
		list.toArray(original);
		
		Collections.sort(list);
		
		Integer[] sortedUp = new Integer[list.size()];
		list.toArray(sortedUp);
		
		List<Integer> visited = new ArrayList<>();
		
		int count = countSwaps(original, sortedUp);
		
		list = new ArrayList<>();
		Collections.addAll(list, Arrays.stream(original).toArray(Integer[]::new));
		visited.clear();
		
		Collections.sort(list, Collections.reverseOrder());
		
		Integer[] sortedDown = new Integer[list.size()];
		list.toArray(sortedDown);
		
		int countR = countSwaps(original, sortedDown);
		
		if (count < countR) return count;
		else if (countR < count) return countR;
		else return count;
	}
	
	public int countSwaps(Integer[] arr1, Integer[] arr2) {
        // Step 1: Create a mapping of arr2 elements to their indices
        Map<Integer, Integer> targetIndexMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            targetIndexMap.put(arr2[i], i);
        }

        // Step 2: Transform arr1 into their target indices according to arr2
        int[] targetOrder = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            targetOrder[i] = targetIndexMap.get(arr1[i]);
        }

        // Step 3: Count swaps using cycle detection
        boolean[] visited = new boolean[arr1.length];
        int swaps = 0;

        for (int i = 0; i < targetOrder.length; i++) {
            if (visited[i] || targetOrder[i] == i) {
                continue; // Skip already visited or correctly placed elements
            }

            // Cycle detection
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = targetOrder[j];
                cycleSize++;
            }

            // Add the number of swaps for this cycle
            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }

}
