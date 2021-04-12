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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        result.addAll(this.getElements(root1));
        result.addAll(this.getElements(root2));
        Collections.sort(result);
        return result;
    }
    
    private List<Integer> getElements(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        
        return result;
    }
}
