package org.example.recurssion;

public class CountString {
    /**
     * We have given an string length which we have to create using 0 and 1
     * only constraint is there cannt be consecutive one in string
     */

    public static void main(String[] args) {
        System.out.println(new CountString().solve(10));
    }

    private int solve(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        return solve(n-1) + solve(n-2);
    }
}
