package org.example.recurssion.backtracking;


import java.util.HashSet;
import java.util.Set;

public class FindSubSets {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        new FindSubSets().findSubsets("ABC", "", 0,set);
        System.out.println(set);
    }

    public void findSubsets(String input, String output, int index, Set<String> result) {
        if (index == input.length()) {
            result.add(output);
            return;
        }

        // Include the output character
        findSubsets(input, output + input.charAt(index), index + 1, result);

        // Exclude the output character
        findSubsets(input, output, index + 1, result);
    }
}
