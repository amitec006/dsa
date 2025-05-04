package org.example.dsa1.carryForwardandcontributiontechnique;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int []A = {4, 4, 5, 2, 4};
        int buy = A[0];
        int sell = A[0];
        int profit = 0;
        for (int i = 1; i < A.length; i++) {
            int temp_profit = A[i] - buy;
            if (temp_profit > profit) {
                profit = temp_profit;
                sell = A[i];
            }
            if (A[i] < buy) {
                buy = A[i];
            }
        }
        System.out.println(profit);
        System.out.println("Buy at: " + buy);
        System.out.println("Sell at: " + sell);
    }

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - min);
            }
        }
        return profit;
    }
}
