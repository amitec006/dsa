package org.example.dsa1.sorting;

import java.util.Arrays;

public class FactorsSort {
    /**
     * You are given an array A of N elements.
     * Sort the given array in increasing order of
     * number of distinct factors of each element,
     * i.e., element having the least number of factors should
     * be the first to be displayed and the number having
     * highest number of factors should be the last one.
     * If 2 elements have same number of factors,
     * then number with less value should come first.
     *
     * Note: You cannot use any extra space
     */

    public static void main(String[] args) {
        int[] A = {6, 8, 9};
        int[] result = new FactorsSort().solve(A);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] solve(int[] A) {
        Integer[] array = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(array, (a, b) -> {
            int countA = countFactors(a);
            int countB = countFactors(b);
            if (countA == countB) {
                return a - b;
            }
            return countA - countB;
        });
        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }

    private int countFactors(int a) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                if (a / i == i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    private int countFactor(int n)
    {
        int count = 0;
        int sq = (int)Math.sqrt(n);

        // if the number is a perfect square
        if (sq * sq == n)
            count++;

        // count all other factors
        for (int i=1; i<Math.sqrt(n); i++)
        {
            // if i is a factor then n/i will be
            // another factor. So increment by 2
            if (n % i == 0)
                count += 2;
        }

        return count;
    }
}
