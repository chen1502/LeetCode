/**
 * Given an array of strings, return all groups of strings that are anagrams
 * All inputs will be in lower-case
 * e.g, Input: {i, am, ma}, Output: {am, ma}.
 * Order doesn't matter
 */
 
// Complexity: O(n) space, amortized O(n) time.
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        Map<String, Integer> hm = new HashMap<String, Integer>();
        ArrayList<String> list = new ArrayList<String>();
        
        for (int i = 0; i < strs.length; i++) {
            // get a string with characters in sorted order
            char[] ca = strs[i].toCharArray();
            Arrays.sort(ca);
            String s = String.valueOf(ca);
            
            
            if (!hm.containsKey(s)) hm.put(s, i);
            // if hm contains s, we have two strings that are anagrams
            else {
                if (hm.get(s) >= 0) {
                    list.add(strs[hm.get(s)]);
                    hm.put(s, -1); // change the value to negative so that we don't add it twice
                }
                list.add(strs[i]);
            }
        }
        return list;
    }
}
