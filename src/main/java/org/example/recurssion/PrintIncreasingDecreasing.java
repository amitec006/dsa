package org.example.recurssion;

public class PrintIncreasingDecreasing {
    public static void main(String[] args) {
        new PrintIncreasingDecreasing().print(5);
    }

    private void print (int n){
        if (n == 0) return;

        System.out.println(n);
        print(n-1);
        System.out.println(n);
    }
}
