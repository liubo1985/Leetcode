package CC150.BalancedBinaryTree;

/**
 * Created by bliu on 5/15/16.
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
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return findHeight(root) != -1;
    }

    public int findHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
    }
}