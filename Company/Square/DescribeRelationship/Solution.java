import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;


public class FindRelationship {
    class Node {
        String name;
        Node left;
        Node right;
        Node(String name){
            this.name = name;
            left = null;
            right = null;
        }
    }
    private Map<String, List<Node>> map = new HashMap<>();
    private Map<String, Node> nodes = new HashMap<>();

    public List<String> parse(String relationships){
        String[] relationship = relationships.split("\n");
        List<String> res = new ArrayList<>();

        for (int i = 0; i < relationship.length; i++){

            String[] memebers = relationship[i].split(",");

            if (!nodes.containsKey(memebers[0])){
                nodes.put(memebers[0], new Node(memebers[0]));
            }
            if (!nodes.containsKey(memebers[1])){
                nodes.put(memebers[1], new Node(memebers[1]));
            }
            if (!nodes.containsKey(memebers[2])){
                nodes.put(memebers[2], new Node(memebers[2]));
            }
            nodes.get(memebers[0]).left = nodes.get(memebers[1]);
            nodes.get(memebers[0]).right= nodes.get(memebers[2]);

            List<Node> child = new ArrayList<>();
            if (!map.containsKey(memebers[1])){

                child.add(nodes.get(memebers[0]));
                map.put(memebers[1], child);
            } else {
                child = map.get(memebers[1]);
                child.add(nodes.get(memebers[0]));
                map.put(memebers[1], child);
            }
            if (!map.containsKey(memebers[2])){
                child.add(nodes.get(memebers[0]));
                map.put(memebers[2], child);
            } else {
                child = map.get(memebers[2]);
                child.add(nodes.get(memebers[0]));
                map.put(memebers[2], child);
            }
            String str = nodes.get(memebers[0]).name + " is child of " + nodes.get(memebers[1]).name + " and " + nodes.get(memebers[2]).name;
            res.add(str);
        }
        return res;
    }

    public String findOutChild(String name1, String name2){
        if (map.containsKey(name1)){
            List<Node> children = map.get(name1);
            for (Node node : children){
                if (node.name.equals(name2)){
                    return "child";
                }
            }
        } else {
            if (nodes.containsKey(name1)){
                if(nodes.get(name1).left.name.equals(name2) || nodes.get(name1).right.name.equals(name2)){
                    return "child";
                }
            }
        }
        return "Unknown";
    }

    public String findOutParent(String name1, String name2){
        if (!nodes.containsKey(name1) || !nodes.containsKey(name2)){
            return "Unknown";
        }
        Node node = nodes.get(name1);
        if (node.left.name.equals(name2) || node.right.name.equals(name2)){
            return "parent";
        }
        node = nodes.get(name2);
        if (node.left.name.equals(name1) || node.right.name.equals(name1)){
            return "parent";
        }
        return "Unknown";
    }

    public String findOutAncestor(String name1, String name2){
        if (!nodes.containsKey(name1)){
            return "Unknown";
        }
        Node node = nodes.get(name1);
        //System.out.println(node.name);

        int level = 1;
        Queue<Node> q = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        q.offer(node);
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                Node cur = q.poll();
                //set.add(cur);
                if (cur.name.equals(name2)){
                    if (level == 2){
                        System.out.println(level);
                        return "Parent";
                    }
                    if (level > 2){
                        System.out.println(level);
                        return "Ancestor";
                    }
                }
                if (cur.left != null ){
                    System.out.println(cur.left.name);

                    q.offer(cur.left);
                }
                if (cur.right != null ){
                    System.out.println(cur.right.name);

                    q.offer(cur.right);
                }
            }
            level++;
            System.out.println();

        }

        // find offsprings
        q = new LinkedList<>();
        q.offer(node);
        level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node cur = q.poll();
                if (cur.name.equals(name2)){
                    if (level == 2){
                        return "Child";
                    }
                    if (level > 2){
                        System.out.println(level);
                        return "Offspring";
                    }
                }
                List<Node> children = map.get(cur.name);
                for (Node child : children){
                    q.offer(child);
                }
            }
            level++;
        }
        return "Unknown";
    }

    public static void main(String[] args) {
        FindRelationship sol = new FindRelationship();
        // "Chris,Tom,Anne\nJerry,Tim,Daphne"
        String str = "Chris,Tom,Anne\nJerry,Tim,Daphne\nTom,A,B\nAnne,Jackson,Lucy\nTim,B,Lily\nDaphne,Bill,W\nA,C,D\nB,E,F\nLucy,C,G\nLily,H,G\nBill,I,J\nW,L,M";
        List<String> res = sol.parse(str);
        for (String list : res){
            System.out.println(list);
        }
        // find out child
        System.out.println(sol.findOutChild("Chris", "Tom"));
        // find out parent
        System.out.println(sol.findOutParent("Chris", "Tom"));
        // find out ancestor
        System.out.println(sol.findOutAncestor("Chris", "G"));
        // find out offspring
        System.out.println(sol.findOutAncestor("D","Anne"));
    }
}
