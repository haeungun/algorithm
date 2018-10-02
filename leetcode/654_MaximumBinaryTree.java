/**
 * 출처: https://leetcode.com/problems/maximum-binary-tree/
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length < 1) return null;
        
        int maxIdx = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (maxValue < nums[i]) {
                maxIdx = i;
                maxValue = nums[i];
            }
        }
        
        TreeNode root = new TreeNode(maxValue);
        TreeNode left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIdx));
        TreeNode right;
        if (maxIdx == nums.length - 1) 
            right = null;
        else 
            right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIdx + 1, nums.length));
        
        root.left = left;
        root.right = right;
        return  root;
    }
}
