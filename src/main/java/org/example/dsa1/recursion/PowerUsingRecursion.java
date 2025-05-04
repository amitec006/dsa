package org.example.dsa1.recursion;

public class PowerUsingRecursion {
    public static void main(String[] args) {
        int A = 2 , B = 10;
        long res = new PowerUsingRecursion().power(A,B);
        System.out.println(res);
    }

    public long power(int A, int B) {
        return solve(A, B);
    }

    private long solve(int A, int B) {
        if (B <= 1) {
            return A;
        }
        long pow = solve(A, B/2);
        if (B % 2 == 0) {
            return pow * pow;
        } else {
            return pow * pow * A;
        }
    }
}
