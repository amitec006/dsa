package org.example.dsa1.bitmanipulation;

public class FindNthMagicNumber {
    public static void main(String[] args) {
        int  A = 10;
        System.out.println(new FindNthMagicNumber().solve(A));
    }

    public int solve(int A) {
        double ans = 0;
        int i = 1;
        while ( A > 0) {
            int rem = A % 2;
            A = A / 2;
            ans = (rem * (Math.pow(5, i))) + ans;
            i++;
        }
        return (int) ans;
    }
}
