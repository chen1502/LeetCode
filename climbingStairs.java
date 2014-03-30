/**
 * You are climbing a stair case. It takes n steps to reach the top
 * Each time you can either climb 1 or 2 steps
 * In how many distinct ways can you climb to the top?
 */
 

// This is exactly the Fibonacci sequence
// If n is large, pay attention to overflow since F(n) ~ 2^n
public class Solution {
    public int climbStairs(int n) {
        if (n < 2) return 1;
        int a = 1, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = b;
            b += a;
            a = c;
        }
        return b;
    }
}
