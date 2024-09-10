package it.magicsquare.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.magicsquare.core.Solve;

public class MagicMatrixTest {
	
	static Solve solve;
	
	@BeforeAll
	public static void setUp() {
		solve = new Solve();
	}
	
	@Test
	void Test1() {
		List<List<Integer>> list = new ArrayList<>();
		
		List<Integer> a = Arrays.asList(5,3,4);
		List<Integer> b = Arrays.asList(1,5,8); 
		List<Integer> c = Arrays.asList(6,4,2);
		
		list.add(a);
		list.add(b);
		list.add(c);
		
		int result = solve.solve(list);
		assertEquals(7, result);
	}
	
	@Test
	void Test2() {
		List<List<Integer>> list = new ArrayList<>();
		
		List<Integer> a = Arrays.asList(4,9,2);
		List<Integer> b = Arrays.asList(3,5,7); 
		List<Integer> c = Arrays.asList(8,1,5);
		
		list.add(a);
		list.add(b);
		list.add(c);
		
		int result = solve.solve(list);
		assertEquals(1, result);
	}

}
