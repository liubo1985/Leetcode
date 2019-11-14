package CC150.RemoveDuplicatesFromSortedList2;

/**
 * Created by bliu on 5/12/16.
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        head = dummy;

        //compare the next two nodes, if equal, using while statement remove them
        while(head.next != null && head.next.next != null){
            if(head.next.val == head.next.next.val){
                int val = head.next.val;
                while(head.next != null && head.next.val == val){
                    head.next = head.next.next;
                }

            }
            else{
                head = head.next;
            }
        }
        return dummy.next;
    }

    public class ListNode {
           int val;
           ListNode next;
           ListNode(int x) { val = x; }
    }
}
