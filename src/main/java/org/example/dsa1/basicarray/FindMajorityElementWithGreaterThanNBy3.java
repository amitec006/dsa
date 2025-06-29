package org.example.dsa1.basicarray;

public class FindMajorityElementWithGreaterThanNBy3 {
    /**
     * You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
     * If so, return the integer. If not, return -1.
     *
     * If there are multiple solutions, return any one.
     *
     * Note: Read-only array means that the input array should not be modified in the process of solving the problem
     */

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 1, 1};
        System.out.println(new FindMajorityElementWithGreaterThanNBy3().repeatedNumber(A));
    }

    public int repeatedNumber(int[] A) {
        int n = A.length;
        int count1 = 0;
        int count2 = 0;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int k : A) {
            if (first == k) {
                count1++;
            } else if (second == k) {
                count2++;
            } else if (count1 == 0) {
                first = k;
                count1 = 1;
            } else if (count2 == 0) {
                second = k;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int j : A) {
            if (j == first) {
                count1++;
            } else if (j == second) {
                count2++;
            }
        }

        if (count1 > n / 3) {
            return first;
        }
        if (count2 > n / 3) {
            return second;
        }

        return -1;
    }
}
