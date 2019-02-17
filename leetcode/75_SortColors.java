/**
 * https://leetcode.com/problems/sort-colors/submissions/
 * 
 * https://en.wikipedia.org/wiki/Dutch_national_flag_problem
 */

class Solution {
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    // three way partition
    // one-pass algorithm
    public void sortColors(int[] nums) {
        int a = 0;
        int b = 0;
        int n = nums.length - 1;
        
        while (b <= n) {
            if (nums[b] == 0) {
                swap(nums, a, b);
                a++;
                b++;
            } else if (nums[b] == 2) {
                swap(nums, b, n);
                n--;
            } else {
                b++;
            }
        }
    }
}
