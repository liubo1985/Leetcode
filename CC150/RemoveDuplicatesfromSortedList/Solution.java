package CC150.RemoveDuplicatesfromSortedList;

/**
 * Created by bliu on 4/27/2016.
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
        ListNode cur = head;
        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                cur.next = cur.next.next;

            }
            else{
                cur = cur.next;
            }
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
