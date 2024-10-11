package it.fraud.notifications.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.fraud.notifications.core.SolveOn;

public class FraudTest {
	
	static SolveOn solve;
	
	@BeforeAll
	public static void setUp() {
		solve = new SolveOn();
	}
	
	@Test
	void Test1() {
		List<Integer> exp = Arrays.asList(2, 3, 4, 2, 3, 6, 8, 4, 5);
		int d = 5;
		
		int result = solve.activityNotifications(exp, d);
		
		assertEquals(2, result);
		
	}

}
