package org.example.dsa1.sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] A = {4, 7, 9, 2, 11, 19, 21, 24};
        new QuickSort().solve(A);

        for (int i : A) {
            System.out.print(i + " ");
        }
    }

    public int[] solve(int[] A) {
        quickSort(A, 0, A.length - 1);
        return A;
    }

    private void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {
            int pi = partition3(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition3(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low+1;
        int j = low+1;
        while (j < high) {
            if (arr[j] > pivot) {
                j++;
            } else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }
        swap(arr, low, i-1);
        return j;
    }

    private int partition2(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i < high) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
