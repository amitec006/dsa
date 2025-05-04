package org.example;

public class RotateArrayBTimesRightSide {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int b = 2;
        rotateArray(arr, b);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void rotateArray(int[] arr, int b) {
        int n = arr.length;
        b = b % n;
        reverseArray(arr, 0, n - 1);
        reverseArray(arr, 0, b - 1);
        reverseArray(arr, b, n - 1);

    }

    private static void reverseArray(int[] arr, int i, int i1) {
        while (i < i1) {
            int temp = arr[i];
            arr[i] = arr[i1];
            arr[i1] = temp;
            i++;
            i1--;
        }
    }
}
