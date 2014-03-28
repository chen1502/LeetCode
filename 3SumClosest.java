/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to the target.
 * Return the sum of the three integers.
 * You may assume that S has at least three elements and there is a unique solution
 /*
 

// The idea for this solution is,
// if we have a triple sum s < target, then there is no need to examine other triplets with sum < s
// if we have a triple sum s > target, then there is no need to examine other triplets with sum > s
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int i = 0, j = 1, k = num.length - 1;
        int ans = num[0] + num[1] + num[2];
        while(i < j && j < k) {
            int s = num[i] + num[j] + num[k];
            if( s == target) return s;
            else {
                if (Math.abs(target - ans) > Math.abs(target - s) ) ans = s;
                
                if (s > target) k--;
                else {
                    if(i < j - 1) i++;
                    else j++;
                }
            }
        }
        return ans;
    }
}
