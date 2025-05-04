package org.example.sorting.quicksort;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        int[] A = {0,0,0,0};
        Integer[] arr = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a,b) -> {
           String xy = a + String.valueOf(b);
           String yx = b + String.valueOf(a);
           return yx.compareTo(xy);
        });

        StringBuilder sb = new StringBuilder();
        for (int el : arr) {
            if (el == 0 && !sb.isEmpty()) {
                sb.append(el);
            }
        }
        if (sb.isEmpty()) {
            System.out.println(0);
        }
        System.out.println(sb.toString());
    }
}
