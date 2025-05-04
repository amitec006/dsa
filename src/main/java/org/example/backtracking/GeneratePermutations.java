package org.example.backtracking;

import java.util.Set;

public class GeneratePermutations {

    public static void main(String[] args) {

    }
    private static void generatePermutations(String str, String prefix, Set<String> permutations) {
        if (str.isEmpty()) {
            permutations.add(prefix);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            generatePermutations(remaining, prefix + currentChar, permutations);
        }
    }
}
