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
    public int preOrder(TreeNode node, int depth) {
        if(node == null) {
            return depth;
        }
        depth = Math.max(preOrder(node.left, depth), preOrder(node.right, depth));
        return depth + 1;
    }
    public int maxDepth(TreeNode root) {
        return preOrder(root, 0);
    }
}
