package CC150.RotateList;

/**
 * Created by bliu on 4/14/16.
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x;
            }

    public ListNode rotateRight(ListNode head, int k) {
        if(k ==0 || head == null)
            return head;


        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        ListNode fast = head.next;
        ListNode slow = head.next;
        int counter = 0;

        //check if k is greater than lenght of list, if yes, calculate reminder
        for(int i = 0; i < k; i++){
            fast = fast.next;
            counter++;
            if(fast == null){
                fast = head.next;
                k = k % counter;
                for(int j = 0; j < k; j++)
                    fast = fast.next;
                break;
            }
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = dummy.next;
        head.next = slow.next;
        slow.next = null;

        return head.next;
    }
}
