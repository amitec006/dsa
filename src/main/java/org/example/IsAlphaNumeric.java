package org.example;

public class IsAlphaNumeric {
    public static void main(String[] args) {
        char [] arr = {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0'};
        int i = 0;
        int j = arr.length - 1;
        boolean allAlphaNumeric = true;
        while (i < j) {
            if (!Character.isLetterOrDigit(arr[i])
                || !Character.isLetterOrDigit(arr[j])) {
                allAlphaNumeric = false;
                break;
            }
            i++;
            j--;
        }
        System.out.println(allAlphaNumeric);
    }
}
