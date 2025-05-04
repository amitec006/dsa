package org.example.stack;

import java.util.Stack;

public class RemoveConsecutiveIdenticalPairs {

    /**
     * You have a string, denoted as A.
     *
     * To transform the string, you should perform the following operation repeatedly:
     * Identify the first occurrence of consecutive identical pairs of characters within the string.
     * Remove this pair of identical characters from the string.
     * Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.
     * The final result will be the transformed string.
     * @param args
     */
    public static void main(String[] args) {
        String A = "aaa";
        System.out.println(new RemoveConsecutiveIdenticalPairs().solve(A));
    }

    public String solve(String A) {
        Stack<Character> st = new Stack<>();
        st.push(A.charAt(0));
        for (int i =1; i< A.length(); i++) {
            char tmp = A.charAt(i);
            if (!st.isEmpty()) {
                char ch = st.peek();
                if (tmp == ch) {
                    st.pop();
                } else {
                    st.push(tmp);
                }
            } else {
                st.push(tmp);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        return res.reverse().toString();
    }
}
