package org.example;

import java.util.ArrayList;
import java.util.List;

public class MergeOverlappingIntervals {
    /**
     * You are given a collection of intervals A in a 2-D array format,
     * where each interval is represented by a pair of integers `[start, end]`.
     * The intervals are sorted based on their start values.
     *
     * Your task is to merge all overlapping intervals and return the resulting set of non-overlapping intervals.
     * @param args
     */
    public static void main(String[] args) {
        int[][] A = {{1, 3}, {2, 6}, {8, 10}, {15, 18} };
        int[][] res = new MergeOverlappingIntervals().solve(A);
        for (int[] re : res) {
            System.out.println(re[0] + " " + re[1]);
        }
    }

    private int[][] solve(int[][] a) {
        int n = a.length;
        int s1 = a[0][0];
        int e1 = a[0][1];
        List<int[]> res = new ArrayList<>();
        for(int i = 1; i < n ; i++) {
            if (a[i][0] <= e1) {
                e1 = Math.max(e1, a[i][1]);
            } else {
                int[] temp = new int[2];
                temp[0] = s1;
                temp[1] = e1;
                res.add(temp);
                s1 = a[i][0];
                e1 = a[i][1];
            }
        }
        int[] temp = new int[2];
        temp[0] = s1;
        temp[1] = e1;
        res.add(temp);

        return res.toArray(new int[res.size()][]);

    }
}
