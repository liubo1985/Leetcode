public class Trie {

    class Node{
        String s;
        boolean isString;
        Map<Character, Node> map;
        Node(){
            s = new String();
            isString = false;
            map = new HashMap<Character, Node>();
        }
    }

    Node root;

    public Trie() {
        // do intialization if necessary
        root = new Node();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        Node current = root;
        for (int i = 0; i < word.length(); i++){
            if (!current.map.containsKey(word.charAt(i))){
                current.map.put(word.charAt(i), new Node());
            }
            current = current.map.get(word.charAt(i));
        }
        current.isString = true;
        current.s = word;
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        if (word == null || word.length() == 0){
            return true;
        }
        Node current = root;
        for (int i = 0; i < word.length(); i++){
            if (!current.map.containsKey(word.charAt(i))){
                return false;
            }
            current = current.map.get(word.charAt(i));
        }
        return current.isString;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        if (prefix == null || prefix.length() == 0){
            return true;
        }
        Node current = root;
        for (int i = 0; i < prefix.length(); i++){
            if (!current.map.containsKey(prefix.charAt(i))){
                return false;
            }
            current = current.map.get(prefix.charAt(i));
        }
        return true;
    }
}