package org.example;

public class AGPairCount  {
    public static void main(String[] args) {
        String A = "ABCGAG";
        int a_count = 0;
        int ag_count = 0;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'A') {
                a_count++;
            }
            if (A.charAt(i) == 'G') {
                ag_count += a_count;
            }
        }
        System.out.println(ag_count);
    }
}
