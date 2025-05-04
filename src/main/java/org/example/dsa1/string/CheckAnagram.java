package org.example.dsa1.string;

public class CheckAnagram {
    public static void main(String[] args) {
        String A = "listen";
        String B = "silent";
        System.out.println(new CheckAnagram().solve(A, B));
    }

    public int solve(String A, String B) {
        if (A.length() != B.length()) {
            return 0;
        }

        int[] count = new int[26];
        for (int i = 0; i < A.length(); i++) {
            count[A.charAt(i) - 'a']++;
            count[B.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return 0;
            }
        }
        return 1;
    }
}
