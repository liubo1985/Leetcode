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
     * @param root: the root
     * @return: the second minimum value in the set made of all the nodes' value in the whole tree
     */
    public int findSecondMinimumValue(TreeNode root) {
        // Write your code here
        if (root == null){
            return -1;
        }
        int secMin = Integer.MAX_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if (cur.val != root.val){
                secMin = Math.min(secMin, cur.val);
            }
            if (cur.left != null){
                q.offer(cur.left);
            }
            if (cur.right != null){
                q.offer(cur.right);
            }
        }
        return secMin == Integer.MAX_VALUE ? -1 : secMin;
    }
}