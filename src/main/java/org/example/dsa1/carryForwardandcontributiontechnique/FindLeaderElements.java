package org.example.dsa1.carryForwardandcontributiontechnique;

public class FindLeaderElements {
    public static void main(String[] args) {
        int[] A = {16, 17, 4, 3, 5, 2};
        int n = A.length;
        int max = A[n-1];
        System.out.print(max + " ");
        for (int i = n-2; i >= 0; i--) {
            if (A[i] > max) {
                max = A[i];
                System.out.print(max + " ");
            }
        }
    }
}
