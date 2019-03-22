package CC150.ReverseLinkedList2;

/**
 * Created by bliu on 5/17/16.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        ListNode pre = head;
        for(int i = 1; i < m; i++){
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode next = pre.next.next;
        for(int i = 0; i < n - m; i++){
            ListNode temp = next.next;
            next.next = start;
            start = next;
            next = temp;
        }
        pre.next.next = next;
        pre.next = start;
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
