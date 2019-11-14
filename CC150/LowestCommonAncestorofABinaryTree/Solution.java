package CC150.LowestCommonAncestorofABinaryTree;

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        //devide
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //conquer
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        return null;

    }
}


    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here
        if (root == null || A == null || B == null){
            return null;
        }
        ArrayList<ParentTreeNode> pathA = getRootPath(root, A);
        ArrayList<ParentTreeNode> pathB = getRootPath(root, B);
        int sizeA = pathA.size() - 1;
        int sizeB = pathB.size() - 1;

        while (sizeA >= 0 && sizeB >= 0){
            if (pathA.get(sizeA) != pathB.get(sizeB)){
                break;
            }
            sizeA--;
            sizeB--;
        }
        return pathA.get(sizeA + 1);
    }

    public List<ParentTreeNode> getRootPath(ParentTreeNode root, ParentTreeNode des){
        ParentTreeNode parent = des.parent;
        List<ParentTreeNode> res = new ArrayList<ParentTreeNode>();
        res.add(des);
        while(parent != null){
            parent = parent.parent;
            res.add(parent);


        }
        return res;
    }

    public int maxPathSum2(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        int max = root.val + Math.max(0, Math.max(left, right));
        return max;
    }