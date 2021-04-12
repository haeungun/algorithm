/**
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
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
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        this.inorder(root1);
        this.inorder(root2);
        
        Collections.sort(l);
        return l;
    }
    
    private void inorder(TreeNode node) {
        if (node == null) return;
        
        this.inorder(node.left);
        l.add(node.val);
        this.inorder(node.right);
    }
}
