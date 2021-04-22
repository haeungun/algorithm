/**
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/submissions/
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
    
    public int maxLevelSum(TreeNode root) {
        int maxLevel = 0;
        int currLevel = 1;

        List<TreeNode> levels = new ArrayList<>();
        levels.add(root);
        
        Queue<List<TreeNode>> queue = new LinkedList();
        queue.add(levels);

        int maxValue = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            List<TreeNode> currNodes = queue.poll();
            int currValue = currNodes.stream().mapToInt(n -> n.val).sum();
            if (maxValue < currValue) {
                maxValue = currValue;
                maxLevel = currLevel;
            }

            List<TreeNode> nextNodes = new ArrayList<>();
            currNodes.stream().forEach(node -> {
                if (node.left != null) nextNodes.add(node.left);
                if (node.right != null) nextNodes.add(node.right);
            });
            if (nextNodes.size() > 0) queue.add(nextNodes);
            currLevel++;
        }

        return maxLevel;
    }
}
