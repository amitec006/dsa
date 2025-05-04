package org.example.dsa1.sorting;

import java.util.Arrays;

public class BClosestPointsToOrigin {
    /**
     * You are developing a feature for Zomato that helps users
     * find the nearest restaurants to their current location.
     * It uses GPS to determine the user's location and has access to a database of restaurants,
     * each with its own set of coordinates in a two-dimensional space representing
     * their geographical location on a map. The goal is to identify the "B" closest
     * restaurants to the user, providing a quick and convenient way to choose where to eat.
     *
     * Given a list of restaurant locations, denoted by A
     * (each represented by its x and y coordinates on a map), and an integer B
     * representing the number of closest restaurants to the user.
     * The user's current location is assumed to be at the origin (0, 0).
     *
     * Here, the distance between two points on a plane is the Euclidean distance.
     *
     * You may return the answer in any order. The answer is guaranteed
     * to be unique (except for the order that it is in.)
     *
     * NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2).
     */

    public static void main(String[] args) {
        int[][] A = {{1, 3},{-2, 2}};
        int B = 1;
        int[][] result = new BClosestPointsToOrigin().solve(A, B);

        for (int[] i : result) {
            System.out.print(i[0] + " " + i[1] + " ");
        }
    }

    public int[][] solve(int[][] A, int B) {
        int n = A.length;
        int[][] result = new int[B][2];
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = A[i][0] * A[i][0] + A[i][1] * A[i][1];
        }
        Arrays.sort(A, (a, b)->{
            int d1 = a[0] * a[0] + a[1] * a[1];
            int d2 = b[0] * b[0] + b[1] * b[1];
            return d1 - d2;
        });
        //quickSelect(A, distance, 0, n - 1, B);
        for (int i = 0; i < B; i++) {
            result[i][0] = A[i][0];
            result[i][1] = A[i][1];
        }
        return result;
    }

    private void quickSelect(int[][] a, int[] distance, int i, int i1, int b) {
        if (i >= i1) {
            return;
        }
        int pivot = partition(a, distance, i, i1);
        if (pivot == b) {
            return;
        } else if (pivot < b) {
            quickSelect(a, distance, pivot + 1, i1, b);
        } else {
            quickSelect(a, distance, i, pivot - 1, b);
        }
    }

    private int partition(int[][] a, int[] distance, int i, int i1) {
        int pivot = distance[i1];
        int j = i;
        for (int k = i; k < i1; k++) {
            if (distance[k] < pivot) {
                swap(a, distance, j, k);
                j++;
            }
        }
        swap(a, distance, j, i1);
        return j;
    }

    private void swap(int[][] a, int[] distance, int j, int k) {
        int[] temp = a[j];
        a[j] = a[k];
        a[k] = temp;
        int temp1 = distance[j];
        distance[j] = distance[k];
        distance[k] = temp1;
    }
}
