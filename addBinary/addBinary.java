/**
 * Given two binary strings, return their sum as a binary string
 * e.g, a = "11", b = "1", return "100"
 */
 
// Complexity: O(n) space and time
public class Solution {
    public String addBinary(String a, String b) {
        if(a.length() < b.length() ) return addBinary(b, a);
        int n = a.length(), m = b.length();
        
        // Since the sum may be 1 digit longer than any of a and b, we allocate one more element
        char[] A = new char[n + 1];
        int c = 0; // the carry
        for (int i = 0; i < n; i++) {
            int t = a.charAt(n - 1 - i) + c - '0';
            if(i < m) t += b.charAt(m - 1 - i) - '0';
            A[n - i] = (char)( t % 2 + '0');
            c = t / 2;
        }
        A[0] = (char)(c + '0');
        String ans = String.valueOf(A);
        if(A[0] == '0') return ans.substring(1);
        else return ans;
    }
}
