package org.example.personal;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,1,1,1, 2, 2,2,3,3, 4, 5,5,5, 6, 7,7,7,7, 8, 9,9,9,9, 10);

        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //System.out.println(map);
        Object obj = null;
        String s = String.valueOf(obj);
        System.out.println(s);
    }
}
