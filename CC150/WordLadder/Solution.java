public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here

        if (dict == null) {
            return 0;
        }

        if (start.equals(end)) {
            return 1;
        }

        dict.add(start);
        dict.add(end);

        HashSet<String> hash = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        hash.add(start);

        int length = 1;
        while(!queue.isEmpty()) {    		//开始bfs
            length++;
            int size = queue.size();		//当前步数的队列大小
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord: getNextWords(word, dict)) {	//得到新单词
                    if (hash.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }

                    hash.add(nextWord);
                    queue.offer(nextWord);			//存入队列继续搜索
                }
            }
        }
        return 0;
    }

    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {					//枚举当前替换字母
            for (int i = 0; i < word.length(); i++) {		//枚举替换位置
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {		//如果dict中包含新单词，存入nextWords
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;							//构造当前单词的全部下一步方案
    }

    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

}