package com.CC150.AddTwoNumbers;

/**
 * Created by bliu on 3/5/16.
 */


public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode next = head;
        int sum = 0;

        while(l1 != null && l2 != null){
            sum = carry + l1.val + l2.val;
            next.next = new ListNode(sum%10);
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
            next = next.next;
        }

        while(l1 != null){
            sum = carry + l1.val;
            next.next = new ListNode(sum%10);
            carry = sum/10;
            l1 = l1.next;
            next = next.next;
        }

        while(l2 != null){
            sum = carry + l2.val;
            next.next = new ListNode(sum%10);
            carry = sum/10;
            l2 = l2.next;
            next = next.next;
        }

        if(carry != 0)
            next.next = new ListNode(carry);

        head = head.next;
        return head;

    }
}
