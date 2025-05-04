package org.example.dsa1.recursion;

import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoi {
    /**
     *In the classic problem of the Towers of Hanoi, you have 3 towers numbered from 1 to 3 (left to right)
     * and A disks numbered from 1 to A (top to bottom) of different sizes which can slide onto any tower.
     * The puzzle starts with disks sorted in ascending order of size from top to bottom
     * (i.e., each disk sits on top of an even larger one).
     * You have the following constraints:
     *
     * Only one disk can be moved at a time.
     * A disk is slid off the top of one tower onto another tower.
     * A disk cannot be placed on top of a smaller disk.
     * You have to find the solution to the Tower of Hanoi problem.
     * You have to return a 2D array of dimensions M x 3, where M is the minimum number of moves needed to solve the problem.
     * In each row, there should be 3 integers (disk, start, end), where:
     *
     * disk - number of the disk being moved
     * start - number of the tower from which the disk is being moved
     * end - number of the tower to which the disk is being moved
     */
    public static void main(String[] args) {
        int A = 3;
        //new TowerOfHanoi().towerOfHanoi(A, 'A', 'C', 'B');
        int[][] result = new TowerOfHanoi().towerOfHanoi(A);
        for (int[] move : result) {
            System.out.println(move[0] + " " + move[1] + " " + move[2]);
        }
    }

    public int[][] towerOfHanoi(int A) {
        List<int[]> moves = new ArrayList<>();
        solve(A, 1, 3, 2, moves);
        return moves.toArray(new int[moves.size()][]);
    }

    private void solve(int A, int tower1, int tower3, int tower2, List<int[]> moves) {
        if (A == 0) {
            return;
        }
        solve(A - 1, tower1, tower2, tower3, moves);
        System.out.println("Move disk " + A + " from rod "
                + tower1 + " to rod "
                + tower3);
        moves.add(new int[]{A, tower1, tower3});
        solve(A - 1, tower2, tower3, tower1, moves);
    }

    private void towerOfHanoi(int n, char from_rod,
                      char to_rod, char aux_rod)
    {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod "
                + from_rod + " to rod "
                + to_rod);
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }
}
