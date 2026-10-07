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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, long lBound, long hBound) {
        if(lBound >= root.val || root.val >= hBound) {
            return false;
        }
        boolean isValid = true;

        if(root.left != null) {
            isValid = isValid && isValid(root.left, lBound, root.val);
        }

        if(root.right != null) {
            isValid = isValid && isValid(root.right, root.val, hBound);
        }

        return isValid;
    }
}
