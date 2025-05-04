package org.example.stack;

import java.util.Stack;

public class LargestRectangleHistogram {
    /**
     * Given an array of integers A.
     *
     *
     * A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
     *
     * Find the area of the largest rectangle formed by the histogram.
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // Use 0 height as a sentinel to process remaining elements
            int h = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(A)); // Output: 10
    }
}
