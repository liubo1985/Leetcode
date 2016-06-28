package CC150.BinaryTreeMaximumPathSum;

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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private class ClassWrapper{
        private int singlePass;
        private int maxPath;
        private ClassWrapper(int singlePass, int maxPath){
            this.singlePass = singlePass;
            this.maxPath = maxPath;
        }
    }

    public int maxPathSum(TreeNode root) {
        ClassWrapper result = helper(root);
        return result.maxPath;
    }

    public ClassWrapper helper(TreeNode root){
        if(root == null){
            return new ClassWrapper(0, Integer.MIN_VALUE);
        }
        //devide
        ClassWrapper left = helper(root.left);
        ClassWrapper right = helper(root.right);

        //Conquer
        //every single path must contain its root node
        int single = Math.max(left.singlePass, right.singlePass) + root.val;
        //if single path value is less than 0, toss it, not need it
        single = single > 0 ? single : 0;

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePass + right.singlePass + root.val);

        return new ClassWrapper(single, maxPath);
    }
}