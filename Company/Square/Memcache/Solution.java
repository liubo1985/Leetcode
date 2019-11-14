public class Memcache {

    class Entity{
        int expired;
        int value;
        Entity(int expired, int value){
            this.expired = expired;
            this.value = value;
        }
    }

    Map<Integer, Entity> map;

    public Memcache() {
        // do intialization if necessary
        map = new HashMap<Integer, Entity>();
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: An integer
     */
    public int get(int curtTime, int key) {
        // write your code here
        if (!map.containsKey(key)){
            return Integer.MAX_VALUE;
        }
        Entity entity = map.get(key);
        if (entity.expired < curtTime && entity.expired != -1){
            return Integer.MAX_VALUE;
        }
        System.out.println(entity.value);

        return entity.value;
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param value: An integer
     * @param ttl: An integer
     * @return: nothing
     */
    public void set(int curtTime, int key, int value, int ttl) {
        // write your code here
        Entity entity = null;
        int expired;
        if (map.containsKey(key)){
            entity = map.get(key);
            entity.value = value;
            entity.expired = ttl == 0 ? -1 : curtTime + ttl - 1;
        } else {
            expired = ttl == 0 ? -1 : curtTime + ttl - 1;
            //System.out.println(expired + " " + value);

            entity = new Entity(expired, value);
            map.put(key, entity);
        }
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: nothing
     */
    public void delete(int curtTime, int key) {
        // write your code here
        if (!map.containsKey(key)){
            return;
        }
        map.remove(key);
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int incr(int curtTime, int key, int delta) {
        // write your code here
        if (!map.containsKey(key)){
            return Integer.MAX_VALUE;
        }
        if (get(curtTime, key) == Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        Entity entity = map.get(key);
        entity.value += delta;
        return entity.value;
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int decr(int curtTime, int key, int delta) {
        // write your code here
        if (!map.containsKey(key)){
            return Integer.MAX_VALUE;
        }
        if (get(curtTime, key) == Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        Entity entity = map.get(key);
        entity.value -= delta;
        return entity.value;
    }
}