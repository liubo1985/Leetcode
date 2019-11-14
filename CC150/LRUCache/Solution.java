package CC150.LengthofLastWord;

/**
 * Created by bliu on 4/12/16.
 */
public class LRUCache {

    private int size;
    private int capacity;
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> map;

    /*
     * @param capacity: An integer
     */
    public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        size = 0;
        map = new HashMap<Integer, ListNode>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        moveToTail(node);

        return node.value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (map.containsKey(key)){
            ListNode node = map.get(key);
            node.value = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToTail(node);
            return;
        }
        ListNode newNode = new ListNode(key, value);
        //size++;
        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
            size--;
        }
        map.put(key, newNode);
        size++;
        moveToTail(newNode);
    }

    private void moveToTail(ListNode node){
        node.prev = tail.prev;
        tail.prev = node;
        node.prev.next = node;
        node.next = tail;
    }

    class ListNode{
        int key;
        int value;
        ListNode prev;
        ListNode next;

        public ListNode(int key, int value){
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }
}