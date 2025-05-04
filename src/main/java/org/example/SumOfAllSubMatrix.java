package org.example;

public class SumOfAllSubMatrix {

    /**
     *
     * Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible submatrices.
     *
     *
     * Let us suppose the index of an element be (X, Y) in 0 based indexing, then the number of submatrices Sub(x,y) for this element
     * can be given by the formula Sub(x, y) = (X + 1) * (Y + 1) * (N – X) * (N – Y) .
     * This formula works because we just have to choose two different positions on the matrix that will create a submatrix that
     * envelopes the element. Thus, for each element, ‘sum’ can be updated as sum += Sub(x,y) * A[x][y].
     *
     * More Formally,
     * Number of ways to choose from top-left elements (X + 1) * (Y + 1)
     * Number of ways to choose from bottom-right elements (N - X) * (N - Y)
     * @param args
     */
    public static void main(String[] args) {
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                sum += A[i][j] * (i+1) * (j+1) * (A.length-i) * (A[i].length-j);
            }
        }
        System.out.println(sum);
    }
}
