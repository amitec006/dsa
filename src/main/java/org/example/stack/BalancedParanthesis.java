package org.example.stack;

import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args) {
        String A = "({)}";
        //String A = "(){}[]";

        System.out.println(new BalancedParanthesis().solve(A));
    }

    public int solve(String A) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char exp = A.charAt(i);
            if (exp == '{' || exp == '(' || exp == '[') {
                st.push(exp);
            } else if (exp == '}' || exp == ')' || exp == ']'){
                if (!st.isEmpty()) {
                    char peek = st.peek();
                    if ((exp == '}' && peek == '{') || (exp == ')' && peek == '(') || (exp == ']' && peek == '[')) {
                        st.pop();
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            }
        }
        return st.isEmpty()?1:0;
    }
}
