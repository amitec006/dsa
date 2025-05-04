package org.example.dsa1.carryForwardandcontributiontechnique;

import java.util.ArrayList;
import java.util.List;

public class FindAllLeadersInArray {
    public static void main(String[] args) {
        int[] A = {16, 17, 4, 3, 5, 2};
        List<Integer> list = new ArrayList<>();
        list.add(A[A.length-1]);
        int max_so_far = A[A.length-1];
        for (int i = A.length-2; i >= 0; i--) {
            if (A[i] > A[i+1] && A[i] > max_so_far) {
                list.add(A[i]);
                max_so_far = A[i];
            }
        }
        System.out.println(list);
    }
}
