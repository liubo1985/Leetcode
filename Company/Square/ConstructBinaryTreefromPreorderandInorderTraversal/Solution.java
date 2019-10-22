/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (preorder.length != inorder.length){
            return null;
        }
        return build(preorder, 0, preorder.length -1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build (int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if (inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int position = find(inorder, inStart, inEnd, preorder[preStart]);

        TreeNode left = build(preorder, preStart + 1, preStart + position - inStart, inorder, inStart, position - 1);
        TreeNode right = build(preorder, preEnd - (inEnd - position) + 1, preEnd, inorder, position + 1, inEnd);
        root.left = left;
        root.right = right;
        return root;

    }

    public int find(int[] inorder, int start, int end, int target){
        int i;
        for (i = start; i <= end; i++){
            if (inorder[i] == target){
                break;
            }
        }
        return i;
    }
}