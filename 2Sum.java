/**
 * Given an array of integers, find two numbers such that they add up to a target number.
 * The function twoSum should return the two indices of the two numbers, where index1 is less than index2.
 * The returnd answers are NOT zero-based.
 * You may assume there is a unique solution for each input.
 *
 * Input: numbers = {2, 7, 11, 15}, target = 9
 * Output: {1, 2}
 */

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        // we first put all the (value, index) pairs in a hashmap
        // if there are duplicate values, just keep the one with largest index
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++) hm.put(numbers[i], i);
        
        // scan numbers from beginning to end
        // since a solution is guaranteed, the for-loop can stop somewhere
        int first = -1;
        for ( first = 0; first < numbers.length; first++) {
            if ( hm.containsKey(target - numbers[first]) && hm.get(target - numbers[first]) > first ) break;
        }
        int[] ans = {first + 1, hm.get(target - numbers[first]) + 1};
        return ans;
    }
}
