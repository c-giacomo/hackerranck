package it.slowest.key.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindSlowest {
	
	public char findSlow(List<List<Integer>> keyTimes) {
		
//		char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		
//		List<Integer> key = keyTimes.stream().map(i -> {
//			return i.get(0);
//		}).collect(Collectors.toList());
//		
//		List<Integer> times = keyTimes.stream().map(i -> {
//			return i.get(i.size() - 1);
//		}).collect(Collectors.toList());
		
//		List<Integer> sub = new ArrayList<>();
//		sub.add(times.get(0));
//		for (int i=1; i < times.size(); i++) {
//			sub.add(times.get(i) - times.get(i - 1));
//		}
//		
//		Integer position = sub.indexOf(Collections.max(sub));
//		
//		return alphabet[key.get(position)];
		
		List<KeyTime> keyAndTimes = keyTimes.stream().map(i -> {
			KeyTime kt = new KeyTime(i.get(0), i.get(1));
			return kt;
		}).collect(Collectors.toList());
		
		List<Integer> subTime = new ArrayList<>();
		subTime.add(keyAndTimes.get(0).getTime());
		for (int i=1; i < keyAndTimes.size(); i++) {
			subTime.add(keyAndTimes.get(i).getTime() - keyAndTimes.get(i - 1).getTime());
		}
		
		Integer position = subTime.indexOf(Collections.max(subTime));
		
		return KeyTime.alphabet[keyAndTimes.get(position).getKey()];
		
	}

}

class KeyTime {
	private Integer key;
	private Integer time;
	protected static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	
	public KeyTime() {}
	public KeyTime(Integer key, Integer time) {
		this.time = time;
		this.key = key;
	}
	
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
}
