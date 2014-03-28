/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all such unique triplets.
 * Elements in a triplet must be in non-descending order, i.e. a <= b <= c
 * The solution set much not contain duplicate triplets
 */
 
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> comb;
        
        Arrays.sort(num);
        
        // For fixed i, it reduces to the 2sum problem with target -num[i]
        int i = 0, j, k;
        while(i < num.length - 2) {
            j = i + 1;
            k = num.length - 1;
            while(j < k){
                if(num[i] + num[j] + num[k] < 0) j++;
                else if(num[i] + num[j] + num[k] > 0) k--;
                else{
                    comb = new ArrayList<Integer>();
                    comb.add(num[i]);
                    comb.add(num[j]);
                    comb.add(num[k]);
                    ans.add(comb);
                    while(j < k && num[j] == num[j+1]) j++;
                    j++;
                    
                    // the following two lines are not necessary
                    while(j < k && num[k] == num[k-1]) k--;
                    k--
                }
            }
            while(i < num.length - 2 && num[i] == num[i+1]) i++;
            i++;
        }
        return ans;
    }
}
