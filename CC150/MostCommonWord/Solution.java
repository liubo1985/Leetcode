

public class Solution {
    /**
     * @param paragraph:
     * @param banned:
     * @return: nothing
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        //
        if (paragraph == null || paragraph.length() == 0){
            return paragraph;
        }

        paragraph = processing(paragraph);
        Set<String> excludedWords = new HashSet<>();
        for (int i = 0; i < banned.length; i++){
            excludedWords.add(banned[i]);
        }
        Map<String, Integer> hashmap = new HashMap<>();
        String[] splits = paragraph.split("\\s+");

        String res = "";
        int frequent = 0;
        for (String word : splits){
            if (!excludedWords.contains(word)){
                hashmap.put(word, hashmap.getOrDefault(word, 0) + 1);
                int curFreq = hashmap.get(word);
                if (curFreq > frequent){
                    res = word;
                    frequent = curFreq;
                }

                if (curFreq == frequent && res.compareTo(word) > 0){
                    res = word;
                    frequent = curFreq;
                }
            }
        }
        return res;
    }

    public String processing(String s){
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++){
            char ch = array[i];
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
                array[i] = Character.toLowerCase(ch);
            } else {
                array[i] = ' ';
            }
        }
        return String.valueOf(array);
    }
}