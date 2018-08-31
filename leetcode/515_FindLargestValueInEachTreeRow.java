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
 
    Map<Integer, Integer> map = new HashMap<>();

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        
        if (root == null) return ret;
        
        map.put(0, root.val);
        this.dfs(root, 0);
        
        for (int i = 0; i < map.size(); i++) {
            ret.add(map.get(i));
        }
        
        return ret;
    }
    
    public void dfs(TreeNode node, int layer) {      
        if (node.left == null && node.right == null) return;
        layer++;
        
        int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
        if (node.left != null) left = node.left.val;
        if (node.right != null) right = node.right.val;
        
        int val = map.getOrDefault(layer, Integer.MIN_VALUE);
        int child = Math.max(left, right);
        map.put(layer, Math.max(val, child));
        
        if (node.left != null) this.dfs(node.left, layer);
        if (node.right != null) this.dfs(node.right, layer);
    }
}
