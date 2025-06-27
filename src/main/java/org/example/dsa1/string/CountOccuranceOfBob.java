package org.example.dsa1.string;

public class CountOccuranceOfBob {
    public static void main(String[] args) {
        System.out.println(new CountOccuranceOfBob().countBobOccurrences("bobobob"));
    }

    public static int countBobOccurrences(String A) {
        int count = 0;
        for (int i = 0; i <= A.length() - 3; i++) {
            if (A.substring(i, i + 3).equals("bob")) {
                count++;
            }
        }
        return count;
    }

    public static int countBobOccurrences2(String A) {
        int count = 0;
        for (int i = 0; i <= A.length() - 3; i++) {
            if (A.startsWith("bob", i)) {
                count++;
            }
        }
        return count;
    }
}
