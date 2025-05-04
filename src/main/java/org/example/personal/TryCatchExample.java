package org.example.personal;

public class TryCatchExample {
    public static void main(String[] args) {
        int x = tryCatchExample();
        System.out.println(x);
    }

    public static int tryCatchExample() {
        try {
            int a = 10/0;
            return 1;
        } catch (ArithmeticException e) {
            return 2;
        } finally {
            return 3;
        }
    }
}
