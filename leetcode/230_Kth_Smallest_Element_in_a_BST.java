/** 
 * 출처: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
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
    
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> l = this.makeTreeToSortedList(root);
        return l.get(k - 1);
    }
    
    private List<Integer> makeTreeToSortedList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            result.add(node.val);
            
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
        
        Collections.sort(result);
        return result;
    }
}
