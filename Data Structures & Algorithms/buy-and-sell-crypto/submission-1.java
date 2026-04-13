class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int windowStart = 0;
        int windowEnd = 1;
        for(;windowEnd < prices.length;windowEnd++) {
            if(prices[windowEnd] > prices[windowStart]) {
                profit = Math.max(profit, prices[windowEnd] - prices[windowStart]);
            } else {
                windowStart = windowEnd;
            }
        }
        return profit;
    }
}
