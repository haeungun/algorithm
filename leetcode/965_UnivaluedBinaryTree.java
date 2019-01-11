/*
 * 출처: https://leetcode.com/problems/univalued-binary-tree/
 */
 
class Solution {
    
    public boolean isUnivalTree(TreeNode root) {
        int val = root.val;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.val != val) return false;
            if (node.left != null) q.add(node.left);
            if (node.right !=  null) q.add(node.right);
            val = node.val;
        }
        
        return true;
    }
}
