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
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        if (A == null || A.length == 0){
            return new TreeNode(0);
        }
        // monitonic stack
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i <= A.length; i++){
            TreeNode right = i == A.length ? new TreeNode(Integer.MAX_VALUE) : new TreeNode(A[i]);
            while (!stack.isEmpty()) {

                if (right.val > stack.peek().val) {
                    TreeNode cur = stack.pop();
                    if (stack.isEmpty()){
                        right.left = cur;
                    } else {
                        if (stack.peek().val > right.val){ // 如果前一个node比后一个node的值大，则把当前node加入下一个node的
                            //左子树，反之当前node加入前一个node的右子树
                            right.left = cur;
                        } else {
                            TreeNode left = stack.peek();
                            left.right = cur;
                        }
                    }
                } else {
                    break;
                }
            }
            stack.push(right);
        }
        return stack.peek().left;
    }
}