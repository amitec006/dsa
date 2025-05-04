package org.example.dsa1.bitmanipulation;

public class SetIthAndJthBit {
    public static void main(String[] args) {
       int A = 3;
       int B = 5;
         System.out.println(new SetIthAndJthBit().solve(A, B));
    }

    public int solve(int A, int B) {
        return 0 | (1 << A) | (1 << B);
    }
}
