public class Trie {

    class TrieNode{
        char ch;
        Map<Character, TrieNode> map = new HashMap<Character, TrieNode>();;
        boolean isString;
        String str;
        TrieNode(char ch){
            this.ch = ch;

            isString = false;
            str = "";
        }
        TrieNode(){

        }
    }

    TrieNode root;
    public Trie() {
        // do intialization if necessary
        root = new TrieNode();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        if (word == null || word.length() == 0){
            return;
        }
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++){
            char cur = word.charAt(i);
            if (curNode.map.containsKey(cur)){
                curNode = curNode.map.get(cur);
            } else {
                TrieNode newNode = new TrieNode(cur);
                curNode.map.put(cur, newNode);
                curNode = newNode;
            }

        }
        curNode.isString = true;
        curNode.str = word;
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        if (word == null || word.length() == 0){
            return false;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if (cur.map.containsKey(ch)){
                cur = cur.map.get(ch);
            } else {
                return false;
            }
        }
        return cur.isString;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        if (prefix == null || prefix.length() == 0){
            return false;
        }
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if (cur.map.containsKey(ch)){
                cur = cur.map.get(ch);
            } else {
                return false;
            }
        }
        return true;
    }
}