package org.example;

public class FactorCount {
    public static void main(String[] args) {
        int n = 36;
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        System.out.println(count);
    }
}
