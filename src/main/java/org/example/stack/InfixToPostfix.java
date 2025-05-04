package org.example.stack;

import java.util.Stack;

public class InfixToPostfix {
    /**
     * Given string A denoting an infix expression. Convert the infix expression into a postfix expression.
     *
     *
     * String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.
     *
     * Find and return the postfix expression of A.
     *
     * NOTE:
     *
     * ^ has the highest precedence.
     * / and * have equal precedence but greater than + and -.
     * + and - have equal precedence and lowest precedence among given operators.
     * @param args
     */
    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Postfix Expression: " + new InfixToPostfix().infixToPostfix(infix));
    }

    // Method to get precedence of operators
    private static int precedence(char ch) {
        switch (ch) {
            case '^': return 3; // Highest precedence (right-associative)
            case '*': case '/': return 2;
            case '+': case '-': return 1;
            default: return -1;
        }
    }

    // Method to check if an operator is left associative
    private static boolean isLeftAssociative(char ch) {
        return ch != '^'; // Only '^' is right-associative
    }

    // Method to convert infix to postfix
    public static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder(); // Output postfix expression
        Stack<Character> stack = new Stack<>();    // Stack to store operators

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // If the character is an operand (a-z), add it to output
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            // If the character is '(', push it to stack
            else if (c == '(') {
                stack.push(c);
            }
            // If the character is ')', pop and append until '(' is found
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty()) stack.pop(); // Remove '(' from stack
            }
            // If an operator is encountered
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) > precedence(c) ||
                        (!stack.isEmpty() && precedence(stack.peek()) == precedence(c) && isLeftAssociative(c))) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all remaining operators in stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(' || stack.peek() == ')') {
                throw new IllegalArgumentException("Mismatched parentheses in expression");
            }
            result.append(stack.pop());
        }

        return result.toString();
    }

}
