package org.example.dsa1.basicarray;

public class TimeToEquality {
    public static void main(String[] args) {
        int[] A = {1,1,1000000000};
        System.out.println(new TimeToEquality().solve(A));
    }

    public int solve(int[] A) {
        int max = A[0];
        for (int el : A) {
            if (el > max)
                max = el;
        }

        int res = 0;
        for (int el : A) {
            res = res + (max - el);
        }
        return res;
    }
}
