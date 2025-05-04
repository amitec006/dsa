package org.example.dsa1.recursion;

public class FindSumOfItsDigit {
    public static void main(String[] args) {
        System.out.println(new FindSumOfItsDigit().solve(46));
    }

    public int solve(int A) {
        if (A == 0) {
            return 0;
        }
        return (A%10) + solve(A / 10);
    }
}
