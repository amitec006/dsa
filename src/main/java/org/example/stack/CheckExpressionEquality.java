package org.example.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CheckExpressionEquality {

    /**
     * Given two strings A and B. Each string represents an expression consisting of lowercase English alphabets, '+', '-', '(' and ')'.
     *
     *
     * The task is to compare them and check if they are similar. If they are identical, return 1 else, return 0.
     *
     * NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and every operand appears only once.
     *
     * for example
     * A = "-(a+b+c)"
     *  B = "-a-b-c"
     *
     * these two expression are equal
     * @param args
     */
    public static void main(String[] args) {
        String A = "-(a+b+c)";
        String B = "-a-b-c";

        System.out.println(new CheckExpressionEquality().areExpressionsEqual(A, B));
    }
    public int areExpressionsEqual(String A, String B) {
        Map<Character, Integer> expr1 = getExpressionMap(A);
        Map<Character, Integer> expr2 = getExpressionMap(B);
        return expr1.equals(expr2) ? 1 : 0;
    }

    private Map<Character, Integer> getExpressionMap(String expr) {
        Map<Character, Integer> map = new HashMap<>();
        Stack<Integer> signStack = new Stack<>();
        signStack.push(1); // Initial sign is positive

        int sign = 1;
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (ch == '+') {
                continue; // '+' is redundant
            } else if (ch == '-') {
                sign = -sign;
            } else if (ch == '(') {
                // Push current sign to stack
                signStack.push(signStack.peek() * sign);
                sign = 1; // Reset current sign
            } else if (ch == ')') {
                signStack.pop(); // Remove top sign
            } else {
                // It's a variable (a-z)
                int totalSign = sign * signStack.peek();
                map.put(ch, map.getOrDefault(ch, 0) + totalSign);
                sign = 1; // Reset sign after processing a variable
            }
        }
        return map;
    }
}
