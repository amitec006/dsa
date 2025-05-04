package org.example.dsa1.sorting;

import java.util.Arrays;

public class NobelInteger {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] A = {-10,1,1,3,100};
        System.out.println(countNobelIntegers(A));
    }


    /**
     * Given an integer array A, find if an integer p exists in the array
     * such that the number of integers greater than p in the array equals p.
     * @param A
     * @return
     */
    public static boolean existsSpecialInteger(int[] A) {
        Arrays.sort(A); // Step 1: Sort the array
        int n = A.length;

        for (int i = 0; i < n; i++) {
            // Step 2: Number of elements greater than A[i] = n - i - 1
            /**
             * The number of elements strictly greater than A[i] is:
             * greaterCount=total elements−current index − 1 = n − i − 1
             * (We subtract 1 because A[i] itself is not counted.)
             */
            int greaterCount = n - i - 1;

            // Step 3: Ensure we only check for the first occurrence of a number in sorted order
            if (i == 0 || A[i] != A[i - 1]) {
                if (greaterCount == A[i]) {
                    return true;
                }
            }
        }

        return false; // No such integer found
    }


    /**
     * Find count of Nobel integers,
     * A[i] is Nobel integer if count of elements smaller than A[i] is equal to A[i]
     * @param A
     * @return
     */
    public static int countNobelIntegers(int[] A) {
        /*Arrays.sort(A); // Sort the array
        int count = 0;
        int n = A.length;

        for (int i = 0; i < n; i++) {
            // Ignore duplicates, count only the first occurrence
            if (i > 0 && A[i] == A[i - 1]) continue;

            // Count of elements smaller than A[i] is just i (since array is sorted)
            if (A[i] == i) {
                count++;
            }
        }

        return count;*/


          Arrays.sort(A); // Sort the array
                  int count = 0;
                  int n = A.length;
                  int ans = 0;
                  for (int i = 1; i < n; i++) {
                      if (A[i] != A[i-1]) {
                          count = i;
                      }
                      if (count == A[i]) {
                          ans++; // Increment the count of Nobel integers
                      }
                  }

                  return ans;

    }

}
