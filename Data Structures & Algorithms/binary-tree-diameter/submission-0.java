/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNodeight;
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
    public int MAX;
    public int diameterOfBinaryTree(TreeNode root) {
      MAX = 0;
      dfs(root);
      return MAX;
    }

    public int dfs(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        MAX = Math.max(MAX, right + left);
        return Math.max(right,left) + 1;
    }
}
