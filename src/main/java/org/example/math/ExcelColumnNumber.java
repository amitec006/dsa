package org.example.math;

public class ExcelColumnNumber {

    public static void main(String[] args) {
        System.out.println(new ExcelColumnNumber().titleToNumber("AB"));
    }

    public int titleToNumber(String A) {
        int result = 0;
        for (char ch : A.toCharArray()) {
            result = result * 26 + (ch - 'A' + 1);
        }
        return result;
    }
}
