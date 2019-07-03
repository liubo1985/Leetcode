package CC150.RemoveDuplicatesFromSortedList;

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
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        head = dummy;

        ListNode next = head.next;
        ListNode nonDup = head;
        while(next != null){
            if(next.val == nonDup.val){
                next = next.next;
            }
            else{
                nonDup.next = next;
                nonDup = next;
            }
        }
        //Do not forget put null to the tail
        nonDup.next = null;
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
