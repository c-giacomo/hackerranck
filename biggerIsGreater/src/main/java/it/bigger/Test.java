package it.bigger;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    private final static Map<String, Integer> hashMap = Map.ofEntries(
            new AbstractMap.SimpleEntry<String, Integer>("a",1),
            new AbstractMap.SimpleEntry<String, Integer>("b",2),
            new AbstractMap.SimpleEntry<String, Integer>("c",3),
            new AbstractMap.SimpleEntry<String, Integer>("d",4),
            new AbstractMap.SimpleEntry<String, Integer>("e",5),
            new AbstractMap.SimpleEntry<String, Integer>("f",6),
            new AbstractMap.SimpleEntry<String, Integer>("g",7),
            new AbstractMap.SimpleEntry<String, Integer>("h",8),
            new AbstractMap.SimpleEntry<String, Integer>("i",9),
            new AbstractMap.SimpleEntry<String, Integer>("j",10),
            new AbstractMap.SimpleEntry<String, Integer>("k",11),
            new AbstractMap.SimpleEntry<String, Integer>("l",12),
            new AbstractMap.SimpleEntry<String, Integer>("m",13),
            new AbstractMap.SimpleEntry<String, Integer>("n",14),
            new AbstractMap.SimpleEntry<String, Integer>("o",15),
            new AbstractMap.SimpleEntry<String, Integer>("p",16),
            new AbstractMap.SimpleEntry<String, Integer>("q",17),
            new AbstractMap.SimpleEntry<String, Integer>("r",18),
            new AbstractMap.SimpleEntry<String, Integer>("s",19),
            new AbstractMap.SimpleEntry<String, Integer>("t",20),
            new AbstractMap.SimpleEntry<String, Integer>("u",21),
            new AbstractMap.SimpleEntry<String, Integer>("v",22),
            new AbstractMap.SimpleEntry<String, Integer>("w",23),
            new AbstractMap.SimpleEntry<String, Integer>("x",24),
            new AbstractMap.SimpleEntry<String, Integer>("y",25),
            new AbstractMap.SimpleEntry<String, Integer>("z",26));

    public static String biggerIsGreater(String w) {
        return resolve(w);
    }

    public static String resolve(String s) {
        String[] result = s.split("");
        List<Integer> lexicalOrder = Arrays.asList(result).stream().map(x -> hashMap.get(x)).collect(Collectors.toList());
        lexicalOrder.forEach(x -> System.out.println(x));
        Integer[] arr = lexicalOrder.stream().toArray(Integer[]::new);
        for (int i = arr.length -1; i > 0; i--) {
            if (i > 0) {
                if (arr[i - 1] >= arr[i]) {
                    continue;
                } else {

                }
            }
        }
        return null;
    }

    public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
