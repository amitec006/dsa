package org.example.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElementIndex {

    public static int[] findNearestSmallerIndices(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stack to store indices

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop(); // Remove elements that are not smaller
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek(); // Store the nearest smaller element index
            stack.push(i); // Push current index onto stack
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(findNearestSmallerIndices(A)));
    }
}
