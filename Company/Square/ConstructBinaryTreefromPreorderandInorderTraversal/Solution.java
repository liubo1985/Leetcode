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

//对于给定的前序遍历preorder和中序遍历inorder，首先我们不难发现，这棵树的根结点其实就是preorder[0]。
// 由于preorder和inorder是对同一棵树的遍历，我们可以知道preorder[0]在inorder中一定也存在，不妨设preorder[0]==inorder[k]。
//
//由于inorder是中序遍历，所以k左边的就是根节点左子树的中序遍历、k右边的就是根节点右子树的中序遍历。
//
//并且，由于我们已经知道了根节点左子树的节点数（与中序遍历长度相同），不妨设为l，我们可以知道preorder从1到l+1就是根节点左子树的前序遍历，
// 剩下的最后一部分就是根节点右子树的前序遍历。
//
//也就是说，我们可以计算出左子树、右子树的前序遍历和中序遍历，从而可以用分治的思想，将规模较大的问题分解成为两个较小的问题，
// 然后递归的进行处理，还原左子树和右子树，最后连通根节点一起组成一棵完整的树。

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