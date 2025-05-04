package org.example.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NIntegersContainingOnly123 {
    public static List<Integer> findNumbers(int A) {
        List<Integer> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        // Initialize the queue with valid single-digit numbers
        queue.add("1");
        queue.add("2");
        queue.add("3");

        while (result.size() < A) {
            String num = queue.poll();
            result.add(Integer.parseInt(num));

            // Generate new numbers by appending '1', '2', and '3'
            queue.add(num + "1");
            queue.add(num + "2");
            queue.add(num + "3");
        }

        return result;
    }

    public static void main(String[] args) {
        int A = 100;  // Example input
        System.out.println(findNumbers(A));
    }
}
