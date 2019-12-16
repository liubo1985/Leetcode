public class Solution {
    /**
     * @param words: a set of stirngs
     * @param target: a target string
     * @param k: An integer
     * @return: output all the strings that meet the requirements
     */

    class Trie {
        class Node{
            String str;
            boolean isString;
            Map<Character, Node> map;
            Node(){
                this.str = str;
                this.isString = false;
                this.map = new HashMap<>();
            }
        }

        Node root;
        Trie(){
            root = new Node();
        }

        public void insert(String str){

            Node cur = root;
            for (char ch : str.toCharArray()){
                if (!cur.map.containsKey(ch)){
                    cur.map.put(ch, new Node());
                }
                cur = cur.map.get(ch);
            }
            cur.str = str;
            cur.isString = true;
        }
    }

    public List<String> kDistance(String[] words, String target, int k) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0){
            return res;
        }
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++){
            trie.insert(words[i]);
        }
        int[] dp = new int[target.length() + 1];
        for (int i = 0; i <= target.length(); i++){
            dp[i] = i;
        }
        dfs(words, target, k, trie.root, dp, res);
        return res;

    }

    public void dfs(String[] words, String target, int k, Trie.Node cur, int[] dp, List<String> res){
        if (cur.isString){
            if (dp[target.length()] <= k){
                res.add(cur.str);
            }
        }
        int[] dpNext = new int[target.length() + 1];
        for (char ch : cur.map.keySet()){

            dpNext[0] = dp[0] + 1;
            for (int j = 1; j <= target.length(); j++){
                // f[i][j] = min(f[i - 1][j] + 1, f[i - 1][j - 1] + 1, f[i - 1][j - 1] + 1)
                dpNext[j] = Math.min(Math.min(dpNext[j - 1], dp[j]), dp[j- 1]) + 1;
                char c = target.charAt(j - 1);
                if (c == ch){
                    // case : equal
                    dpNext[j] = Math.min(dpNext[j], dp[j - 1]);
                }
            }
            dfs(words, target, k, cur.map.get(ch), dpNext, res);
        }
    }
}