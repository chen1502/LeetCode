/**
 * There are N children standing in a line. Each child is assigned a rating value
 * You are giving candies to these children subjected to the following requirements"
 *   each child must have at least one candy
 *   children with a higher rating get more candies than their neighbors
 * What is the minimum candies you must give?
 */
 
 
// Complexity: O(n) space and time. Could be mordified to use constant space
public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n < 2) return n;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);
        
        for (int i = 1; i < n; i++){
            if (ratings[i] > ratings[i-1]) candy[i] = candy[i-1] + 1;
        }
        
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i-1] > ratings[i] && candy[i-1] <= candy[i])
                candy[i-1] = candy[i] + 1;
        }
        
        int ans = 0;
        for (int item : candy) ans += item;
        return ans;
    }
}
