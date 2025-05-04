package org.example.sorting.quicksort;

public class PartitionTheArray {

    public static void main(String[] args) {
        int[] A = {12,45,34,67,20,47,36,76};
        int pivotIndex = 5;
        int[] res = partition(A, pivotIndex);
        for (int el : res){
            System.out.print(el+" ");
        }
    }

    private static int[] partition(int[] a, int pivotIndex) {
        int pivot = a[pivotIndex];
        a[pivotIndex] = a[0];
        a[0] = pivot;
        int low = 1;
        int high = a.length-1;

        while (low <= high) {
            if (a[low] <= pivot) {
                low++;
            } else if (a[high] >= pivot) {
                high--;
            } else {
                int tmp = a[low];
                a[low++] = a[high];
                a[high--] = tmp;
            }
        }
        a[0] = a[high];
        a[high] = pivot;
        return a;
    }


}
