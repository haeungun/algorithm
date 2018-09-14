/**
 * 출처: https://leetcode.com/problems/longest-increasing-subsequence/description/
 */


class Solution {

    // O(n2) solution
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) 
                    lis[i] = Math.max(lis[i], lis[j] + 1);
            }
            max = Math.max(max, lis[i]);
        }
        
        return max;
    }
    
}
