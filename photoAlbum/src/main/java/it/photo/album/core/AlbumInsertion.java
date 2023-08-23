package it.photo.album.core;

import java.util.ArrayList;
import java.util.List;

public class AlbumInsertion {
	
	
	public List<Integer> photoAlbum(List<Integer> index, List<Integer> identity) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i=0; i < index.size(); i++) {
			result.add(index.get(i), identity.get(i));
		}
		
//		iterate(index, identity, result, 0);
		return result;
	}
	
//	public void iterate(List<Integer> index, List<Integer> identity, List<Integer> result, Integer i) {
//		if (i < index.size()) {
//			Integer value = identity.get(i);
//			result.add(index.get(i), value);
//			i++;
//			iterate(index, identity, result, i);
//		} else return;
//		
//	}


}
