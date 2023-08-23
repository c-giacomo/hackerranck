package it.nondivisible.subset.core;

import java.util.List;

public class FindSubSet {

	public void findNonDvisibleSubSet(List<Integer> s, Integer k) {
		int [] rem = new int[k];
		for(int i = 0; i < s.size(); ++i) {
            rem[s.get(i)%k]++;            
        }
        int sum = 0;
        for(int i = 1;i * 2 < k;++i) {
            if (rem[i] < rem[k-i] ) {
                sum += rem[k-i];
            } else {
                sum += rem[i];
            }
        }
        if(rem[0] > 0) {
            ++sum;
        }
        if(k%2 == 0 && rem[k/2] > 0) {
            ++sum;
        }
        System.out.println(sum);
	}

}
