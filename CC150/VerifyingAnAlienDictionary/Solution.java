class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length==1){
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i), i);
        }
        for(int i=1;i<words.length;i++){
            int index = 0;
            boolean indexOut = false;
            if(index>words[i-1].length()-1){
                continue;
            }
            if(index>words[i].length()-1){
                return false;
            }
            while(map.get(words[i].charAt(index))==map.get(words[i-1].charAt(index))){
                index++;
                System.out.println(index);
                if(index>words[i-1].length()-1){
                    indexOut=true;
                    break;
                }
                if(index>words[i].length()-1){
                    return false;
                }
            }
            if(indexOut){
                continue;
            }
            if(map.get(words[i].charAt(index))<map.get(words[i-1].charAt(index))){
                return false;
            }
        }
        return true;
    }
}