/**
 * Say you have an array for which the ith elements is the price of a given stock on day i
 * Design an algorithm to find the maximum profit
 * You may complete as many transactions as you like
 * However, you may not engate in multiple transactions at the same time
 * i.e, you have to sell the stock before you buy again
 */
 
 // Complexity: constant space, O(n) time
 // just make a transaction whenever there is profit
public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if( prices[i] > prices[i-1]) profit += prices[i] - prices[i-1];   
        }
        return profit;
    }
}
