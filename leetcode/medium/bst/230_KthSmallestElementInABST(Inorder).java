/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<Integer> l = new ArrayList<>();
    
    public int kthSmallest(TreeNode root, int k) {
        this.inorder(root);
        return l.get(k - 1);
    }
    
    private void inorder(TreeNode node) {
        if (node == null) return;
        
        this.inorder(node.left);
        this.l.add(node.val);
        this.inorder(node.right);
    }
}
