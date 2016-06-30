package CC150.CloneGraph;

/**
 * Created by bliu on 6/30/16.
 */

import java.util.*;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }

        //get all nodes in the graph, use BFS
        List<UndirectedGraphNode> nodes = getNodes(node);

        //deep copy all nodes in the hashmap
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        for(UndirectedGraphNode mem : nodes){
            if(!map.containsKey(mem)){
                map.put(mem, new UndirectedGraphNode(mem.label));
            }
        }

        //add node's neighbors
        for(UndirectedGraphNode mem : nodes){
            UndirectedGraphNode newMem = map.get(mem);
            for(UndirectedGraphNode neighbor : mem.neighbors){
                newMem.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    public List<UndirectedGraphNode> getNodes(UndirectedGraphNode node){
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();

        queue.offer(node);
        set.add(node);

        while(!queue.isEmpty()){
            UndirectedGraphNode head = queue.poll();
            for(UndirectedGraphNode neighbor : head.neighbors){
                if(!set.contains(neighbor)){
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }
}

