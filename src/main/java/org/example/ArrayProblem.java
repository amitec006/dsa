package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayProblem {
    public static void main(String[] args) {
        int []A = {-3,-3,3,5,4,1,7,4,7,-7};
        ArrayList<Integer> arrayList1 = new ArrayList<>();

        // Adding elements of array A to the ArrayList
        for (int element : A) {
            arrayList1.add(element);
        }
        int[][] B = {{0, 2}, {1, 4}, {4, 6},{4, 6}, {3, 3},{4, 6}, {3, 4}};
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        // Convert the 2D array to ArrayList<ArrayList<Integer>>
        for (int[] row : B) {
            ArrayList<Integer> tempList = new ArrayList<>();
            for (int element : row) {
                tempList.add(element);
            }
            arrayList.add(tempList);
        }
        //solve(arrayList1,arrayList, );
    }

    public static int solve(int[] A, int B, int C) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i<B;i++) {
            sum += A[i];
        }
        if ((sum/B) <= C) {
            return 1;
        }
        int d = 0;
        for (int i =B; i< A.length; i++) {
            sum = sum + A[i] - A[d];
            d = d+1;
            if ((sum/B) <= C){
                count += 1;
            }
        }
        if (count > 0){
            return 1;
        } else {
            return 0;
        }
    }
}
