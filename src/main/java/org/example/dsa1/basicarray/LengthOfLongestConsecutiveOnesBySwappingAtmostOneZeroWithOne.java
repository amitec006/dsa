package org.example.dsa1.basicarray;

public class LengthOfLongestConsecutiveOnesBySwappingAtmostOneZeroWithOne {
    /**
     * Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.
     */

    public static void main(String[] args) {
        String A = "1110001";
        System.out.println(new LengthOfLongestConsecutiveOnesBySwappingAtmostOneZeroWithOne().solve(A));
    }

    public int solve2(String A) {
        int n = A.length();
        int maxCount = 0;
        int totalOne = 0;

        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1') {
                totalOne++;
            }
        }
        if (totalOne == n) { return n;}

        for (int i = 0; i < n ; i++) {
            int l = 0;
            int r = 0;
            int j = i-1;
            //walk towards left
            while (j >= 0 && A.charAt(j) == '1') {
                l++;
                j--;
            }
            //walk towards right
            j = i+1;
            while (j < n && A.charAt(j) == '1') {
                r++;
                j++;
            }
            if (l+r == totalOne) {
                maxCount = Math.max(maxCount, l+r);
            } else {
                maxCount = Math.max(maxCount, l+r+1);
            }
        }
        return maxCount;
    }


    public int solve(String A) {
        int n = A.length();
        int totalOne = 0;
        int maxCount = 0;

        // Step 1: Count total number of '1's
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1') {
                totalOne++;
            }
        }

        // If all characters are '1', return the length of the string
        if (totalOne == n) return n;

        // Step 2: Compute leftOnes and rightOnes
        //Only represent consecutive
        int[] leftOnes = new int[n]; //This will represent , how many consecutive 1s will be there till i from 0
        int[] rightOnes = new int[n]; //This will represent , how many consecutive 1s will be there from i to n-1

        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1') {
                leftOnes[i] = (i == 0) ? 1 : leftOnes[i - 1] + 1;
            } else {
                leftOnes[i] = 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (A.charAt(i) == '1') {
                rightOnes[i] = (i == n - 1) ? 1 : rightOnes[i + 1] + 1;
            } else {
                rightOnes[i] = 0;
            }
        }

        // Step 3: Iterate through '0's and compute the max possible ones sequence
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '0') {
                int left = (i > 0) ? leftOnes[i - 1] : 0;
                int right = (i < n - 1) ? rightOnes[i + 1] : 0;

                if (left + right == totalOne) {
                    maxCount = Math.max(maxCount, left + right);
                } else {
                    maxCount = Math.max(maxCount, left + right + 1);
                }
            }
        }

        return maxCount;
    }

}
