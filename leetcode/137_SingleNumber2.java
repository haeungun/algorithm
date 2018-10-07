/**
 * 출처: https://leetcode.com/problems/single-number-ii
 */


class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i+=3) {
            if (nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 1])
                continue;
            else
                return nums[i];
        }
        return nums[nums.length - 1];
    }
}
