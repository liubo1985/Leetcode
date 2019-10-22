public class Solution {
    /**
     * @param s: a string
     * @param excludewords: a dict
     * @return: the most frequent word
     */
    public String frequentWord(String s, Set<String> excludewords) {
        // Write your code here
        if (s == null || s.length() == 0){
            return s;
        }

        s = processing(s);
        Map<String, Integer> hashmap = new HashMap<>();
        String[] splits = s.split("\\s+");
        for (String word : splits){
            hashmap.put(word, hashmap.getOrDefault(word, 0) + 1);
        }
        String res = "";
        int frequent = 0;
        for (Map.Entry<String, Integer> ele : hashmap.entrySet()){
            String key = ele.getKey();
            if (excludewords.contains(key)){
                continue;
            }

            if (ele.getValue() > frequent){
                res = key;
                frequent = ele.getValue();
            }

            if (ele.getValue() == frequent && res.compareTo(key) > 0){
                res = key;
                frequent = ele.getValue();
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