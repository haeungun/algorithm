/**
 * 출처: https://leetcode.com/problems/range-sum-of-bst/
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
    public int rangeSumBST(TreeNode root, int L, int R) {
        return sum(root, 0, L, R);
    }
    
    private int sum(TreeNode node, int result, int L, int R) {
        if (node.val >= L && node.val <= R) result += node.val;
        if (node.left != null) result += sum(node.left, 0, L, R);
        if (node.right != null) result += sum(node.right, 0, L, R);
        return result;
    }
}
