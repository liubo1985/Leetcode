public class Solution {
    /**
     * @param nums: the given array
     * @param k: the given k
     * @return: the k most frequent elements
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        // Write your code here
        Map<Integer, Integer> hashmap = new HashMap<>();
        PriorityQueue<Element> queue = new PriorityQueue<Element>(
                new Comparator<Element>() {
                    public int compare(Element e1, Element e2) {
                        return e1.freq - e2.freq;
                    }
                });
        for (int i = 0; i < nums.length; i++) {
            if (!hashmap.containsKey(nums[i])) {
                hashmap.put(nums[i], 1);
            } else {
                hashmap.put(nums[i], hashmap.get(nums[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            Element ele = new Element((int)entry.getKey(), (int)entry.getValue());
            if (queue.size() < k) {
                queue.offer(ele);
            } else if (queue.peek().freq < ele.freq) {
                queue.poll();
                queue.offer(ele);
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        while (!queue.isEmpty()){
            ans.add(queue.poll().num);
        }
        return ans;
    }

    class Element{
        int num;
        int freq;
        public Element(int num, int freq){
            this.num = num;
            this.freq = freq;
        }

    }
}