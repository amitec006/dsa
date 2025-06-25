package org.example.dsa1.sorting;

import java.util.Arrays;

public class NobelInteger {
    /**
     *Given an integer array A, find if an integer p exists in the array
     * such that the number of integers greater than p in the array equals p.
     *
     * A = [3, 2, 1, 3]
     *
     * For integer 2, there are 2 greater elements in the array.
     * @param args
     */
    public static void main(String[] args) {
        int[] A = {-4,7,5,3,5,-4,2,-1,-9,-8,-3,0,9,-7,-4,-10,-4,2,6,1,-2,-3,-1,-8,0,-8,-7,-3,5,-1,-8,-8,8,-1,-3,3,6,1,-8,-1,3,-9,9,-6,7,8,-6,5,0,3,-4,1,-10,6,3,-8,0,6,-9,-5,-5,-6,-3,6,-5,-4,-1,3,7,-6,5,-8,-5,4,-3,4,-6,-7,0,-3,-2,6,8,-2,-6,-7,1,4,9,2,-10,6,-2,9,2,-4,-4,4,9,5,0,4,8,-3,-9,7,-8,7,2,2,6,-9,-10,-4,-9,-5,-1,-6,9,-10,-1,1,7,7,1,-9,5,-1,-3,-3,6,7,3,-4,-5,-4,-7,9,-6,-2,1,2,-1,-7,9,0,-2,-2,5,-10,-1,6,-7,8,-5,-4,1,-9,5,9,-2,-6,-2,-9,0,3,-10,4,-6,-6,4,-3,6,-7,1,-3,-5,9,6,2,1,7,-2,5};
        System.out.println(isNobelInteger(A));
    }

    public static int isNobelInteger(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        // Check if the last element is 0 meaning it is a Nobel integer
        // as there is no element greater than 0
        if (A[n-1] == 0) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            if (A[i] == n - i - 1) {
                // Either this is the last element, or next element is greater
                //check if current should not be equal to next element, its an edge case where all elements are same and equal in number
                // like {2,2} here 2 is not Nobel integer as there is no element greater than 2 to remove this check we can write
                // A[i] != A[i+1]
                if (i == n - 1 || A[i] != A[i + 1]) {
                    return 1;
                }
            }
        }
        return -1;
    }

    /**
     *     Arrays.sort(A); // Sort in ascending order
     *         int count = 0;
     *         int n = A.length;
     *
     *         if (A[n - 1] == 0) {
     *             return 1;
     *         }
     *
     *         for (int i = n - 2; i >= 0; i--) { // Iterate in reverse order
     *             if (A[i] != A[i + 1]) {
     *                 count = n - 1 - i;
     *             }
     *             if (A[i] == count) {
     *                 return 1;
     *             }
     *         }
     *         return -1;
     */


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
