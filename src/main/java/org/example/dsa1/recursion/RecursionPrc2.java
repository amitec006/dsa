package org.example.dsa1.recursion;

public class RecursionPrc2 {
    public static void main(String[] args) {
        System.out.println(fun(2, 10));
    }

    static int fun(int x, int n) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            return fun(x*x, n /2);
        } else {
            return x * fun(x*x, (n - 1)/2);
        }
    }
}
