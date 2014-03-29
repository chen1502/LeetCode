/**
 * Say you have an array for which the ith element if the price of a given stock on day i
 * Design an algorithm to find the maximum profit
 * You may complete at most two transactions
 */

// If for each i, we know the max profit of one transaction before day i and another after day i,
// then we can solve this problem easily.
// So we use an array aux to record max profit of a transaction after day i
// Complexity: O(n) time and space
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[] aux = new int[n];
        Arrays.fill(aux, 0);
        int highest = prices[n-1], lowest = prices[0], profit = 0;
        
        // build aux
        for (int i = n - 2; i >= 0; i--) {
            if (profit < highest - prices[i]) profit = highest - prices[i];
            aux[i] = profit;
            if (highest < prices[i]) highest = prices[i];
        }
        
        // for each i, find max profit
        for (int i = 1; i < n; i++) {
            if (profit < aux[i] + prices[i] - lowest) profit = aux[i] + prices[i] - lowest;
            if (lowest > prices[i]) lowest = prices[i];
        }
        
        return profit;
    }
}
