package it.queens;

import java.util.ArrayList;
import java.util.List;

import it.queens.core.Solve;

public class Main {

	public static void main(String[] args) {
		List<List<Integer>> obstacles = new ArrayList<>();
//        Solve.solve(4,0,4,4, obstacles);
		
		List<Integer> ob1 = new ArrayList<>();
		ob1.add(5);
		ob1.add(5);
		
		List<Integer> ob2 = new ArrayList<>();
		ob2.add(4);
		ob2.add(2);
		
		List<Integer> ob3 = new ArrayList<>();
		ob3.add(2);
		ob3.add(3);
		obstacles.add(ob1);
		obstacles.add(ob2);
		obstacles.add(ob3);
		Solve.solve(5,3,4,3, obstacles);

	}

}
