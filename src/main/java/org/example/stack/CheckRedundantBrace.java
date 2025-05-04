package org.example.stack;

import java.util.Stack;

public class CheckRedundantBrace {
    /**
     * Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
     *
     *
     * Check whether A has redundant braces or not.
     *
     * NOTE: A will be always a valid expression and will not contain any white spaces.
     */

    public static void main(String[] args) {
        //String  A = "((a+b))";
        //String  A = "(a+(a+b))";
        //String A = "(a*b)+(b*(d+(a)))";
        String A = "(a+((b*c)+c))";
        System.out.println(new CheckRedundantBrace().hasRedundantBraces(A));

    }

    /**
     * When encountering a closing bracket ), check if there was at least one operator (+, -, *, /) inside the parentheses.
     *
     * If only operands or another set of parentheses exist, the brackets are redundant.
     *
     * Otherwise, the expression inside is necessary.
     *
     * If redundant braces are found, return 1, otherwise return 0.
     * @param A
     * @return
     */

    public int hasRedundantBraces(String A) {
        Stack<Character> stack = new Stack<>();
        for (char ch : A.toCharArray()) {
            if (ch == ')') {
                boolean hasOperator = false;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char top = stack.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        hasOperator = true;
                    }
                }
                stack.pop(); // Remove the '('

                if (!hasOperator) {
                    return 1; // Redundant braces found
                }
            } else {
                stack.push(ch);
            }
        }
        return 0; // No redundant braces
    }

}
