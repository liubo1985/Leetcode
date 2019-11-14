

class TimeMap {

    Map<String, TreeMap<Integer, String>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)){
            TreeMap<Integer, String> temp = new TreeMap<>();
            temp.put(timestamp, value);
            map.put(key, temp);
        }else {
            map.get(key).put(timestamp,value);
        }
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)){
            return "";
        }
        TreeMap<Integer, String> temp = map.get(key);
        Integer clostKey = temp.floorKey(timestamp);
        if (clostKey == null){
            return "";
        }
        return temp.get(clostKey);
    }
}


/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */