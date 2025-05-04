package org.example.dsa1.hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacter {
    /**
     * Determine the "GOOD"ness of a given string A, where the "GOOD"ness is defined by the length of the longest substring that contains no repeating characters. The greater the length of this unique-character substring, the higher the "GOOD"ness of the string.
     *
     * Your task is to return an integer representing the "GOOD"ness of string A.
     *
     * Note: The solution should be achieved in O(N) time complexity, where N is the length of the string.
     */

    public static void main(String[] args) {
        System.out.println(new LongestSubStringWithoutRepeatingCharacter().lengthOfLongestSubstring("abcabcbb")); // 3
    }

    public int lengthOfLongestSubstring(String A) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int ans = 0;
        //String str = "";

        for (int j = 0; j < A.length(); j++) {
            while (set.contains(A.charAt(j))) {
                set.remove(A.charAt(i));
                i++;
            }
            set.add(A.charAt(j));
            if (j - i + 1 > ans) {
                ans = j - i + 1;
                //str = A.substring(i, j + 1);
            }
            //System.out.println(str);
        }
        return ans;
    }
    public int lengthOfLongestSubstring2(String A) {
        int n = A.length();
        int[] visited = new int[256];
        int max = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (visited[A.charAt(i)] == 0) {
                visited[A.charAt(i)] = 1;
            } else {
                max = Math.max(max, i - start);
                while (A.charAt(start) != A.charAt(i)) {
                    visited[A.charAt(start)] = 0;
                    start++;
                }
                start++;
            }
        }
        max = Math.max(max, n - start);
        return max;
    }
}
