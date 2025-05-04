package org.example.dsa1.recursion;

public class CheckPalindromeUsingRecursion {
    /*
    Write a recursive function that checks whether string A is a palindrome or Not.
    Return 1 if the string A is a palindrome, else return 0.

    Note: A palindrome is a string that's the same when read forward and backward.
     */
    public static void main(String[] args) {
        System.out.println(new CheckPalindromeUsingRecursion().solve("VACDTTDCA"));
    }
    public int solve(String A) {
        return isPalindrome(A,A.length(), 0)?1:0;
    }

    private boolean isPalindrome(String A, int l, int start) {
        if (start > A.length()/2) {
            return true;
        }
        if (A.charAt(start) != A.charAt(l-1-start)) {
            return false;
        }
        start += 1;
        String str = A.substring(start, l-1-start);
        isPalindrome(str, str.length(), start);
        return true;
    }
}
