/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    int pos = 1;
    public String serialize(ArrayList<DirectedGraphNode> nodes) {
        if (nodes == null || nodes.size() == 0){
            return "";
        }
        String res = dfs(nodes.get(0));
        return res;
    }
    public UndirectedGraphNode deserialize(String data) {
        if (data == null || data.length() == 0){
            return null;
        }
        return decode(data);
    }

    public String dfs(DirectedGraphNode node){
        if (node == null){
            return "";
        }
        String res = "";
        res += "[";
        res += node.label;
        for (int i = 0; i < node.neighbors.size(); i++){
            res += dfs(node.neighbors.get(i));
        }
        res += "]";
        return res;
    }

    public UndirectedGraphNode decode(String data){
        int number = 0;
        while(data.charAt(pos) >= '0' && data.charAt(pos) <= '9'){
            number = number * 10 + data.charAt(pos) - '0';
            pos++;
        }
        UndirectedGraphNode root = new UndirectedGraphNode(number);
        while(pos < data.length()){
            if (data.charAt(pos) == '['){
                pos++;
                root.neighbors.add(decode(data));
            } else if (data.charAt(pos) == ']'){
                pos++;
                return root;
            }
        }
        return null;
    }
}