package org.example.dsa1.bitmanipulation;

public class HelpFromSam {
    public static void main(String[] args) {
        System.out.println(new HelpFromSam().solve(8549));
    }

    public int solve(int A) {
        int cnt = 0;
        for (int i = 0 ; i < 31; i++) {
            if (((1 << i) & A) != 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
