package CC150.RemoveDuplicatesfromSortedList2;

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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode pre = head;
        ListNode cur = head.next;

        boolean currentDup = false;
        while(cur != null){
            //test if next node is same as current node, if true, remove next node, mark dup flag true
            if(cur.next != null && cur.next.val == cur.val){
                ListNode next = cur.next;
                cur.next = next.next;
                currentDup = true;
            }
            //if next node is not equal to current node, check if dup flag is true, if yes, remove current node
            else if(currentDup == true){
                pre.next = cur.next;
                cur = cur.next;

                currentDup = false;
            }
            //if next node is not equal to current node and dup flag is also flase, which means current node is unique
            else{
                pre = cur;
                cur = cur.next;

            }

        }
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
