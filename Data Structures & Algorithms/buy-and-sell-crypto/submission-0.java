class Solution {
    public int maxProfit(int[] prices) {
        var profit = Integer.MIN_VALUE;
        int i = 0, j = 1;
        while (j < prices.length) {
            if (prices[j] > prices[i]) {
                profit = Math.max(profit, prices[j++] - prices[i]);
            } else {
                i = j;
                j = i+1;
            }
        }
        return profit >= 0 ? profit : 0;
    }
}