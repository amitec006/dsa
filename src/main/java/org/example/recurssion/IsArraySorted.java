package org.example.recurssion;

public class IsArraySorted {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};

        System.out.println(new IsArraySorted().isSorted(arr, 0));
    }

    private boolean isSorted (int[] arr, int idx) {
        if (idx == arr.length-1) {
            return true;
        }

        return arr[idx] <= arr[idx+1] && isSorted(arr, idx+1);
    }
}
