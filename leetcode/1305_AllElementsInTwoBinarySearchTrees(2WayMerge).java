/**
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/submissions/
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
        List<Integer> l = this.inorder(root1, new ArrayList<>());
        List<Integer> r = this.inorder(root2, new ArrayList<>());

        int n = l.size();
        int m = r.size();
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < n && j < m) {
            int x = l.get(i);
            int y = r.get(j);
            
            if (x <= y) {
                result.add(x);
                i++;
            }
            
            if (y < x) {
                result.add(y);
                j++;
            } 
        }
        
        while (i < n) {
            result.add(l.get(i++));
        }
        
        while(j < m) {
            result.add(r.get(j++));
        }
        return result;
    }
    
    private List<Integer> inorder(TreeNode node, List<Integer> l) {
        if (node == null) return l;
        
        this.inorder(node.left, l);
        l.add(node.val);
        this.inorder(node.right, l);
        return l;
    }
}
