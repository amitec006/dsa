package org.example.dsa1.bitmanipulation;

public class UnsetIthBit {

    public static void main(String[] args) {
        int A = 4;
        int B = 1;
        System.out.println(new UnsetIthBit().solve(A, B));
    }

    public int solve(int A, int B) {
        if ((A & (1 << B)) > 0) {
         return A ^ (1 << B);
        } else {
            return A;
        }
    }
}
