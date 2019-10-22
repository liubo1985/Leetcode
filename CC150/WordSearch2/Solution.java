package CC150.WordSearch2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bliu on 7/17/2016.
 */

public class Solution {
    class TrieNode{
        String s;
        boolean isString;
        HashMap<Character, TrieNode> map;
        public TrieNode(){
            s = "";
            isString = false;
            map = new HashMap<Character, TrieNode>();
        }
    }

    class Trie{
        TrieNode root;
        public Trie(TrieNode root){
            this.root = root;
        }

        public void insert(String s){
            TrieNode now = root;
            for(int i = 0; i < s.length(); i++){
                if(!now.map.containsKey(s.charAt(i))){
                    now.map.put(s.charAt(i), new TrieNode());
                }
                now = now.map.get(s.charAt(i));
            }
            now.isString = true;
            now.s = s;

        }
p
    }

    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, 1, 0, -1};

    public void search(char[][] board, int x, int y, TrieNode root, List<String> ans){
        if(root.isString){
            if(!ans.contains(root.s))
                ans.add(root.s);
        }
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == '#' || root == null){
            return;
        }
        if(root.map.containsKey(board[x][y])){
            for(int i = 0; i < 4; i++){
                char cha = board[x][y];
                board[x][y] = '#';
                search(board, x + dx[i], y + dy[i], root.map.get(cha), ans);
                board[x][y] = cha;
            }
        }
        return;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if(words == null || words.length == 0){
            return res;
        }
        Trie tree = new Trie(new TrieNode());
        for(String word : words){
            tree.insert(word);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                search(board, i, j, tree.root, res);
            }
        }
        return res;
    }
}
