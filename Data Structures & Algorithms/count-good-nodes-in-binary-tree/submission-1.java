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
    public int goodNodes(TreeNode root) {
        return findGoodNodes(root, Integer.MIN_VALUE);
    }

    public int findGoodNodes(TreeNode node, int maxInPath) {
        if(node == null) {
            return 0;
        }
        
        if(node.val < maxInPath) {
            return findGoodNodes(node.left, maxInPath) + findGoodNodes(node.right, maxInPath);
        } else {
            return 1 + findGoodNodes(node.left, node.val) + findGoodNodes(node.right, node.val);
        }
    }
}
