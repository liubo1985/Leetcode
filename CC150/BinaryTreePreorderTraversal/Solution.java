package CC150.BinaryTreePreorderTraversal;

/**
 * Created by bliu on 5/16/16.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if(root == null){
            return results;
        }
        stack.push(root);

        while(!stack.empty()){
            TreeNode top = stack.pop();
            results.add(top.val);
            if(top.right != null){
                stack.push(top.right);
            }
            if(top.left != null){
                stack.push(top.left);
            }
        }
        return results;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


// Solution 2
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        traveseTree(root, res);
        return res;
    }
    public void traveseTree(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        traveseTree(root.left, res);
        traveseTree(root.right, res);
    }