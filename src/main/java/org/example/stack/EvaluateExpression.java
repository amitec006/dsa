package org.example.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateExpression {

    /**
     * An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     *
     *
     * Valid operators are +, -, *, /. Each string may be an integer or an operator.
     *
     * Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.
     *
     *
     * @param args
     */
    public static void main(String[] args) {
       String[] A =   {"2", "1", "+", "3", "*"};
        System.out.println(new EvaluateExpression().evalRPN(A));

    }

    public int evalRPN(String[] A) {
        Stack<Integer> st = new Stack<>();

        for (String str : A) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int op2 = st.pop();
                int op1 = st.pop();
                int res = evaluate(op1, op2, str);
                st.push(res);
            } else {
                st.push(Integer.valueOf(str));
            }
        }
        return st.pop();
    }

    private int evaluate(int op1, int op2, String str) {
        switch(str) {
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            case "/":
                return op1 / op2;
        }
        return 0;
    }
}
