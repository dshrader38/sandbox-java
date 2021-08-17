package com.shrader.algorithms.solutions;


public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void print(ListNode listNode) {
        StringBuilder sb = new StringBuilder();

        while (listNode != null) {
            sb.append(listNode.val);

            if( listNode.next != null) {
                sb.append(",");
            }

            listNode = listNode.next;
        }

        System.out.println(sb);
    }
}

