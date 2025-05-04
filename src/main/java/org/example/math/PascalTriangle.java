package org.example.math;

import java.util.ArrayList;

public class PascalTriangle {

    public static void main(String[] args) {
        //Write a program to print the pascal triangle up to A rows.
        System.out.println(new PascalTriangle().solve(5));

    }

    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            ArrayList<Integer> row = new ArrayList<>(A);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
            }
            if (i > 0) {
                row.add(1);
            }
            for (int j = i; j < A - 1; j++) {
                row.add(0);
            }

            list.add(row);
        }
        return list;
    }
}
