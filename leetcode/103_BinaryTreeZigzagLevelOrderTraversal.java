/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        
        if (root == null) return ret;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                if (leftToRight) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
                
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            
            ret.add(list);
            leftToRight = !leftToRight;
        }
        
        return ret;
    }
}
