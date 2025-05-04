package org.example;

import java.util.ArrayList;
import java.util.List;

public class MergeNewOverlapInterval {
    public static void main(String[] args) {
        /**
         * Note that if max(a,c) > min(b,d), then the intervals do not overlap. Otherwise, they overlap.
         *
         * Once we figure out the intervals ( interval[i] to the interval[j] ) which overlap with the new interval, note that we can replace all the overlapping intervals with one interval, which would be
         *
         * (min(interval[i].start, newInterval.start), max(interval[j].end, newInterval.end)).
         *
         * Do make sure you cover the other corner cases.
         *
         * Also take care that the data is provided in an Interval class interface, so use it appropriately.
         */
        //Given intervals [1, 3], [6, 9] insert and merge [0, 2]
        int[][] A = {{5735878,14055448}};
        int[] B = {45639660,84793834};
        int[][] res = new MergeNewOverlapInterval().insert(A, B);
        for (int[] re : res) {
            System.out.println(re[0] + " " + re[1]);
        }
    }

    public int[][] insert(int[][] a, int[] b) {
        int n = a.length;
        if (n == 0) {
            return new int[][]{b};
        }
        int position = 0;
        for (int i = 0; i < n; i++) {
            if (b[0] < a[i][0]) {
                int[] temp = a[i];
                a[i] = b;
                b = temp;
            }
            position = i;
        }
        if (position > 0) {
            position = position + 1;
        } else {
            /**
             * this below condition will handle the case
             * when array size is 1 and b interval is greater
             * int[][] A = {{5735878,14055448}};
             *         int[] B = {45639660,84793834};
             */
            if (b[0] > a[0][0]) {
                position = position + 1;
            }
        }

        List<int[]> res = new ArrayList<>();
        int s1 = a[0][0];
        int e1 = a[0][1];
        for(int i = 1; i < n+1 ; i++) {
            if (i != position) {
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
            } else {
                if (b[0] <= e1) {
                    e1 = Math.max(e1, b[1]);
                } else {
                    int[] temp = new int[2];
                    temp[0] = s1;
                    temp[1] = e1;
                    res.add(temp);
                    if (i == n) {
                        s1 = b[0];
                        e1 = b[1];
                    } else {
                        s1 = a[i][0];
                        e1 = a[i][1];
                    }
                }
            }
        }
        int[] temp = new int[2];
        temp[0] = s1;
        temp[1] = e1;
        res.add(temp);

        return res.toArray(new int[res.size()][]);
    }
}
