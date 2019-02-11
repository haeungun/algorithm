/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 */

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length;
        
        while (l < r) {
            int m = l + (r - l) / 2;
            if ((m % 2 == 0 && m + 1 < nums.length && nums[m] == nums[m + 1]) ||
                (m % 2 == 1 && m - 1 >= 0 && nums[m] == nums[m - 1])) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        return nums[l];
    }
}
