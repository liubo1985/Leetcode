
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<Integer>();
        deque.offer(0);
        result[0]= nums[0];
        for(int i = 1; i < nums.length; i++){
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }
            if(!deque.isEmpty() && (i - deque.peekFirst()) == k){
                deque.removeFirst();
            }
            deque.offer(i);

            if(i + 1 >= k){
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        return result;
    }
}