package it.slowest.key;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.slowest.key.core.FindSlowest;

@SpringBootApplication
public class SlowestKeyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SlowestKeyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Integer> a = Arrays.asList(0, 2);
		List<Integer> b = Arrays.asList(1, 3);
		List<Integer> c = Arrays.asList(0, 7);
//		List<Integer> d = Arrays.asList(2, 15);
		
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		
		l.add(a);
		l.add(b);
		l.add(c);
//		l.add(d);
		
		char result = new FindSlowest().findSlow(l);
		
		System.out.println(result);
		
	}

}
