package org.example.sorting.quicksort;

import java.util.Arrays;

public class TenDigitSorting {
    public static void main(String[] args) {
        int[] A = {15, 11, 7, 19};
        int[] res = new TenDigitSorting().solve(A);
        for (int el : res) {
            System.out.print(el +" ");
        }
    }

    public int[] solve(int[] A) {
        Integer[] arr = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b)->{
            int i = (a / 10)%10;
            int j = (b / 10)%10;

            if (i == j) {
                return Integer.compare(b, a);
            }
            return Integer.compare(i, j);
        });
        return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
    }
}
