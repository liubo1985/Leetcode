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
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // write your code here

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> buffer = new ArrayList<>();
        preorderTraversal(root, 0, target, res, buffer);
        return res;
    }

    // preorder travesal， 记录当层的level， 把所有从root到从current层
    public void preorderTraversal(TreeNode root, int level, int target, List<List<Integer>> res, List<Integer> buffer) {
        if (root == null){
            return;
        }
        int temp = target;
        buffer.add(root.val);
        for (int i = level; i >= 0; i--){
            temp -= buffer.get(i);
            if (temp == 0){
                List<Integer> cache = new ArrayList<>();
                for (int j = i; j <= level; j++){
                    cache.add(buffer.get(j));
                }
                res.add(cache);
            }
        }
        preorderTraversal(root.left, level + 1, target, res, buffer);
        preorderTraversal(root.right, level + 1, target, res, buffer);
        buffer.remove(buffer.size() - 1);
    }
}