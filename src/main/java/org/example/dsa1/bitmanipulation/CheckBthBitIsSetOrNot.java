package org.example.dsa1.bitmanipulation;

public class CheckBthBitIsSetOrNot {
    public static void main(String[] args) {
        int A = 4;
        int B = 1;
        System.out.println(new CheckBthBitIsSetOrNot().solve(A, B));
    }

    public int solve(int A, int B) {
        return (A & (1 << B)) > 0 ? 1 : 0;
    }
}
