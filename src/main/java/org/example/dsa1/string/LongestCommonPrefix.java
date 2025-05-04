package org.example.dsa1.string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] A = {"abcdefgh", "aefghijk", "abcefgh"};
        System.out.println(new LongestCommonPrefix().solve(A));
    }

    private String solve(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        int low = 1, high = minLen;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int length) {
        String prefix = strs[0].substring(0, length);
        for (String str : strs) {
            if (!str.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}
