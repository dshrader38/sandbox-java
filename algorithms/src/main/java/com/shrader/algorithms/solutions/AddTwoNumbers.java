package com.shrader.algorithms.solutions;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/
public class AddTwoNumbers {
    public AddTwoNumbers() {
        ListNode l1 = new ListNode( 2, null );
        l1.next = new ListNode( 4 );
        l1.next.next = new ListNode( 3 );

        while( l1.next != null ) {
            System.out.println( l1.val );
            l1 = l1.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
