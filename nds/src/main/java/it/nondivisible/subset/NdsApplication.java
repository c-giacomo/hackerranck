package it.nondivisible.subset;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.nondivisible.subset.core.FindSubSet;

@SpringBootApplication
public class NdsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NdsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		List<Integer> list = Arrays.asList(19,10,12,10,24,25,22); // k=4 res=3
//		List<Integer> list = Arrays.asList(1,7,2,4); // k=3 res=3
		List<Integer> list = Arrays.asList(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436); // k=7 res=11
//		List<Integer> list = Arrays.asList(582740017,954896345,590538156,298333230,859747706,155195851,331503493,799588305,164222042,563356693,80522822,432354938,652248359);
		new FindSubSet().findNonDvisibleSubSet(list, 7);
	}

}
