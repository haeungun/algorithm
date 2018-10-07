/**
 * 출처: https://leetcode.com/problems/single-number
 */

// Solution 1
class Solution1 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        return this.findByBinary(nums);
    }
    
    private int findByBinary(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        
        int m = 0;
        while (l < r) {
            m = (l + r) / 2;
            System.out.println(l + "," + r);
            System.out.println(m + "->" + nums[m]);
            if (m % 2 == 0) {
                if (nums[m] == nums[m - 1]) {
                    r = m;
                } else if (nums[m] == nums[m + 1]) {
                    l = m;
                } else {
                    return nums[m];
                }
            } else {
                if (nums[m] == nums[m - 1]) {
                    l = m + 1; 
                } else if (nums[m] == nums[m + 1]) {
                    r = m - 1;
                } else {
                    return nums[m];
                }
            }
        }
        
        return nums[(l + r) / 2];
    }
}

// Solution 2
class Solution2 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i += 2) {
            if (nums[i] != nums[i + 1])
                return nums[i];
        }
        return nums[nums.length-1];
    }
}
