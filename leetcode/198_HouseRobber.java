/**
 * 출처: https://leetcode.com/problems/house-robber/
 */

class Solution {
    
    private int[] memo;
    
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0] >= nums[1] ? nums[0] : nums[1];
        
        this.memo = new int[nums.length];
        this.memo[0] = nums[0];
        this.memo[1] = nums[1];
        this.memo[2] = this.memo[0] + nums[2];
        
        for (int i = 3; i < nums.length; i++) {
            this.memo[i] = Math.max(
                this.memo[i - 2] + nums[i],
                this.memo[i - 3] + nums[i]
            );
        }
        
        return Math.max(memo[nums.length - 1], memo[nums.length - 2]);
    }
}
