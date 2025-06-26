package org.example.dsa1.string;

public class LongestPalindromicSubString {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("dpacvbbtabbvcad"));
    }

    public static String longestPalindrome(String s) {
        int maxLen = 0;
        int finalLeft = 0;
        int finalRight = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // odd length
            int left = i;
            int right = i;
            while (left >= 0 && right < n) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }
            /**
             * At the end of the while loops, left and right have moved one extra step too far:
             *
             * left is one less than the palindrome's left boundary
             *
             * right is one greater than the palindrome's right boundary
             */
            if (maxLen < right - left + 1) {
                maxLen = right - left + 1;
                finalLeft = left+1;
                finalRight = right;
            }
            // even length
            left = i;
            right = i+1;
            while (left >= 0 && right < n) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }
            /**
             * At the end of the while loops, left and right have moved one extra step too far:
             *
             * left is one less than the palindrome's left boundary
             *
             * right is one greater than the palindrome's right boundary
             */
            if (maxLen < right - left + 1) {
                maxLen = right - left + 1;
                finalLeft = left+1;
                finalRight = right;
            }
        }
        return s.substring(finalLeft, finalRight);
    }
}
