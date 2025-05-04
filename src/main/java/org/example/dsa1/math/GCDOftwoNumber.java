package org.example.dsa1.math;

public class GCDOftwoNumber {
    public static void main(String[] args) {
        System.out.println(new GCDOftwoNumber().gcd(10, 15));
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public int gcd2(int a, int b)
    {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // Base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
    }
}
