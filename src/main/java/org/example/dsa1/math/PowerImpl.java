package org.example.dsa1.math;

public class PowerImpl {
    public static void main(String[] args) {
        //23 % 3 = 8 % 3 = 2
        int A = 71045970;
        int B = 41535484;
        int C = 64735492;
        //ans = 20805472
        System.out.println(new PowerImpl().pow(A, B, C));
    }

    public int pow(int A, int B, int C) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        //x ^ n = (x * x) ^ n/2
        return exponentMod(A,B,C);
    }

    private int exponentMod(int A,int B, int C)
    {
        // Base cases
        if (A == 0)
            return 0;
        if (B == 0)
            return 1;

        // If B is even
        long y;
        if (B % 2 == 0)
        {
            y = exponentMod(A, B / 2, C);
            y = (y * y) % C;
        }

        // If B is odd
        else
        {
            y = A % C;
            y = (y * exponentMod(A, B - 1,
                    C) % C) % C;
        }

        return (int)((y + C) % C);
    }
}

