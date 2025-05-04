package org.example.dsa1.string;

import java.util.HashSet;

public class IsClourfulNumber {
    public static void main(String[] args) {
        int A = 236;
        System.out.println(new IsClourfulNumber().colorful(A));
    }

    public int colorful(int A) {
        String numStr = String.valueOf(A);
        int n = numStr.length();
        HashSet<Integer> productSet = new HashSet<>();

        // Generate all contiguous subsequences
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product *= (numStr.charAt(j) - '0'); // Convert char to int and multiply
                // If product already exists, return 0 (not colorful)
                if (productSet.contains(product)) {
                    return 0;
                }
                productSet.add(product);
            }
        }
        return 1; // All products are unique, so it's colorful
    }
}
