package com.CC150.ReverseNodesinKGroup;

/**
 * Created by bliu on 3/17/16.
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while(head.next != null){
            head = reverseList(head, k);
        }
        return dummy.next;
    }

    public ListNode reverseList(ListNode head, int k){
        ListNode next = head;
        for(int i = 0; i < k; i++){
            if(next.next == null){
                return next;
            }
            next = next.next;
        }
        next = next.next;

        //head -> l1 -> l2 -> l3 -> l4 -> next
        //head <- l1 <- l2 <- l3 <- l4 <- next
        ListNode pre = head;
        ListNode cur = head.next, l1 = cur;

        for(int i = 0; i < k; i++){
            ListNode curNext = cur.next;
            cur.next = pre;

            pre = cur;
            cur = curNext;

        }
        head.next = pre;
        l1.next = next;
        return l1;
    }

    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
    }
}