//LeetCode Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int minDay = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minDay) {
                minDay = prices[i];
            }

            if(minDay < prices[i]) {
                answer = Math.max(prices[i] - minDay, answer);
            }
        }
        return answer;
    }
}
