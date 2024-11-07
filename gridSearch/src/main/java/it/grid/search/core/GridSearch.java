package it.grid.search.core;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GridSearch {
	
	public String gridSearch(List<String> G, List<String> P) {
		Integer patternIndex = 0;
		String answer = "NO";
		
		String pattern = P.get(patternIndex);
		
		LinkedHashMap<Integer, List<Integer>> indexes = new LinkedHashMap<>();
		
		int row = 0;
		for (String g : G) {
			int index = g.indexOf(pattern);
			while (index >= 0) {
				indexes.computeIfAbsent(row, v -> new ArrayList<>()).add(index);
				index = g.indexOf(pattern, index + 1);
			}
			row++;	
		}
		
		if (indexes.isEmpty()) return answer;
		
		patternIndex++;
		
		for (Map.Entry<Integer, List<Integer>> entry : indexes.entrySet()) {
			Integer k = entry.getKey();
			List<Integer> v = entry.getValue();
			
			for (int i=k+1; i <= G.size(); i++) {
				String toSearch = null;
				if (patternIndex == P.size()) 
					break;
				else
					toSearch = P.get(patternIndex);
				String whereSearch = G.get(i);
				
				for (int t=0; t < v.size(); t++) {
					if (whereSearch.contains(toSearch) && whereSearch.indexOf(toSearch, v.get(t)) == v.get(t)) {
						answer = "YES";
						break;
					} else
						answer = "NO";
				}
				
				if (answer.equals("NO")) {
					patternIndex = 1;
					break;
				} else {
					patternIndex++;
				}
			}
			
		}
		
		return answer;
		
	}

}
