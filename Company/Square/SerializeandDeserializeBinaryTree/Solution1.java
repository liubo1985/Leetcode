public class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null){
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        for (int i = 0; i < queue.size(); i++){
            TreeNode cur = queue.get(i);
            if (cur == null){
                continue;
            }

            queue.add(cur.left);
            queue.add(cur.right);
        }
        while(queue.get(queue.size() - 1) == null){
            queue.remove(queue.size() - 1);
        }

        sb.append("{");
        for (int i = 0; i < queue.size(); i++){
            if (queue.get(i) == null){
                sb.append("#");
                sb.append(",");
            }else {
                TreeNode cur = queue.get(i);
                sb.append(cur.val);
                sb.append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data.equals("{}")){
            return null;
        }
        String[] vars = data.substring(1, data.length() - 1).split(",");
        List<TreeNode> queue = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.valueOf(vars[0]));
        queue.add(root);
        int index = 0;
        boolean rightNode = false;
        for (int i = 1; i < vars.length; i++){

            if (!vars[i].equals("#")){
                TreeNode cur = new TreeNode(Integer.valueOf(vars[i]));
                if (!rightNode){
                    queue.get(index).left = cur;
                } else {
                    queue.get(index).right = cur;
                }
                queue.add(cur);
            }
            if (rightNode){
                index++;
            }
            rightNode = !rightNode;
        }
        return root;
    }
}