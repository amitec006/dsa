package org.example.queue;

import java.util.*;
import java.util.stream.Collectors;

public class SlidingWindowMaximum {
    /**
     * Given an array and window size k , need to find the max of each sub array of size k and return the resultant array
     *
     */

    public static int[] maxSlidingWindow(int[] A, int k) {
        if (A == null || k <= 0) return new int[0];
        int n = A.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements from the front if they are out of the window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements from the back that are smaller than current element
            while (!deque.isEmpty() && A[deque.peekLast()] < A[i]) {
                deque.pollLast();
            }

            // Add current element index to the deque
            deque.offerLast(i);

            // Store result when the window is fully formed
            if (i >= k - 1) {
                result[i - k + 1] = A[deque.peekFirst()];
            }
        }
        return result;
    }

    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        if (A == null || B <= 0) return new ArrayList<>();
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements from the front if they are out of the window
            if (!deque.isEmpty() && deque.peekFirst() < i - B + 1) {
                deque.pollFirst();
            }

            // Remove elements from the back that are smaller than current element
            while (!deque.isEmpty() && A.get(deque.peekLast())< A.get(i)) {
                deque.pollLast();
            }

            // Add current element index to the deque
            deque.offerLast(i);

            // Store result when the window is fully formed
            if (i >= B - 1) {
                result.add(A.get(deque.peekFirst()));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        //System.out.println(Arrays.toString(maxSlidingWindow(A, k)));
        List<Integer> list = Arrays.stream(A)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(new SlidingWindowMaximum().slidingMaximum(list,k));
    }
}
