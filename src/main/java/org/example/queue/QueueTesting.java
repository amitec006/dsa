package org.example.queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTesting {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(10);
        queue.add(20);
        queue.add(5);
        System.out.println("PriorityQueue: " + queue);

// Accessing the head of the queue
        Integer head = queue.peek();
        System.out.println("Head of PriorityQueue: " + head);

// Removing elements from the queue
        Integer removedElement = queue.poll();
        System.out.println("Removed Element: " + removedElement);
        System.out.println("PriorityQueue after removal: " + queue);
    }
}
