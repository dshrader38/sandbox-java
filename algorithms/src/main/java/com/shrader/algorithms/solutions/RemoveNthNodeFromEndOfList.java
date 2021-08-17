package com.shrader.algorithms.solutions;

import java.util.HashMap;
import java.util.Map;


public class RemoveNthNodeFromEndOfList {

    public RemoveNthNodeFromEndOfList() {
        ListNode n0 = new ListNode(1);

        ListNode n1 = new ListNode(2);
        n0.next = n1;

        ListNode n2 = new ListNode(3);
        n1.next = n2;

        ListNode n3 = new ListNode(4);
        n2.next = n3;

        ListNode n4 = new ListNode(5);
        n3.next = n4;

        ListNode.print(n0);

        ListNode single1 = new ListNode(38);
        removeNthNodeFromEndOfList(single1, 1);
    }

    public ListNode removeNthNodeFromEndOfList(ListNode head, int targetIndex) {
        ListNode first = head;
        ListNode second = head;

        // let's move the second pointer to point to the target index
        for (int i = 0; i < targetIndex; i++) {

            // check to see if next node is null, something might not be right
            if (second.next == null) {
                // if target index is greater than the size of the linked list...
                if ((targetIndex - 1) >= i) {
                    // ...delete the head node and exit
                    head = head.next;
                }
                return head;
            }

            // move the 2nd pointer
            second = second.next;
        }

        // increment both pointers
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }

        // first is now pointing to the node BEFORE the nth node, so "delete" the nth node
        first.next = first.next.next;

        return head;
    }
}

