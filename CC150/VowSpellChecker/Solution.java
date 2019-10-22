class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        if (queries == null || queries.length == 0){
            return null;
        }
        Set<String> originSet = new HashSet<String>(Arrays.asList(wordlist));
        Map<String, String> caseMap = new HashMap();
        Map<String, String> vowMap = new HashMap();
        String[] res = new String[queries.length];

        for (String word : wordlist){
            String lowcase = word.toLowerCase();
            String vowelcase = lowcase.replaceAll("[aeiou]", "#");
            if (!caseMap.containsKey(lowcase)){
                caseMap.put(lowcase, word);
            }
            if (!vowMap.containsKey(vowelcase)){
                vowMap.put(vowelcase, word);
            }
        }

        for (int i = 0; i < queries.length; i++){
            String lowcase = queries[i].toLowerCase();
            String vowel = lowcase.replaceAll("[aeiou]", "#");
            if (originSet.contains(queries[i])) {
                res[i] = queries[i];
            } else if (caseMap.containsKey(lowcase)){
                res[i] = caseMap.get(lowcase);
            } else if (vowMap.containsKey(vowel)){
                res[i] = vowMap.get(vowel);
            } else {
                res[i] = "";
            }
        }
        return res;
    }
}