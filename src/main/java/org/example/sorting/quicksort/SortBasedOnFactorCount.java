package org.example.sorting.quicksort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortBasedOnFactorCount {

    public static void main(String[] args) {
        System.out.println(new SortBasedOnFactorCount().countFactor(12));
        int[] A = {12,45,34,67,20,47,36,76};
        Integer[] arr = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (o1, o2) -> {
            int factorCount1 = new SortBasedOnFactorCount().countFactor(o1);
            int factorCount2 = new SortBasedOnFactorCount().countFactor(o2);

            if (factorCount1 == factorCount2) {
                return Integer.compare(o1, o2); // Sort by value if factor count is same
            }
            return Integer.compare(factorCount1, factorCount2); // Sort by factor count
        });
    }

    public int[] sort(int[] A) {
        Integer[] arr = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (o1, o2) -> {
            int factorCount1 = new SortBasedOnFactorCount().countFactor(o1);
            int factorCount2 = new SortBasedOnFactorCount().countFactor(o2);

            if (factorCount1 == factorCount2) {
                return Integer.compare(o1, o2); // Sort by value if factor count is same
            }
            return Integer.compare(factorCount1, factorCount2); // Sort by factor count
        });
        return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
    }

    public int countFactor(int n) {
        int count = 0;
        int div  = (int)Math.sqrt(n);
        for (int i = 1; i <= div; i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
}
