package org.example.recurssion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        new TowerOfHanoi().solve(10, "A", "B", "C");
    }

    private void solve(int nRing, String fromPillar, String viaPillar , String toPillar) {
        if (nRing == 0) {
            return;
        }
        solve(nRing-1, fromPillar, toPillar, viaPillar);
        System.out.println(fromPillar +" => "+ toPillar);
        solve(nRing-1, viaPillar, fromPillar, toPillar);
    }
}
