package org.example.dsa1.string;

public class ToggleStringChar {
    public static void main(String[] args) {
        System.out.println(new ToggleStringChar().solve("aBcD"));
    }

    public String solve(String S) {
        int a = 'a';
        int A = 'A';

        int diff = Math.abs(A-a);
        char[] c = S.toCharArray();
        for(int i = 0; i < c.length; i++) {
            if (c[i] < a) {
                c[i] = (char) (c[i] + diff);
            } else {
                c[i] = (char) (c[i] - diff);
            }
        }
        return new String(c);
    }
}

