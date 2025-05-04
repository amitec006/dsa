package org.example.dsa1.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutAnyRepeatingCharacter {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = new LongestSubStringWithoutAnyRepeatingCharacter().solve(s);
        System.out.println(result);
    }

    private int solve(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            // If character is repeated, move left pointer to max of (existing index + 1) or current left
            if (map.containsKey(currentChar)) {
                left = Math.max(map.get(currentChar) + 1, left);
            }

            // Store the current character index
            map.put(currentChar, right);

            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
