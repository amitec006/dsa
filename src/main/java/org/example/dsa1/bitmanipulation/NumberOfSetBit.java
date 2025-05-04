package org.example.dsa1.bitmanipulation;

public class NumberOfSetBit {

    public static void main(String[] args) {
        System.out.println(new NumberOfSetBit().numSetBits(11));
    }

    public int numSetBits(int A) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((A & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }
}
