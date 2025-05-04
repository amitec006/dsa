package org.example.dsa2;

public class ReverseLinkedList {
    public static void main(String[] args) {
        /**
         * A = 1 -> 2 -> 3 -> 4 -> 5 -> NULL
         * 5 -> 4 -> 3 -> 2 -> 1 -> NULL
         */
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;


        System.out.println(new ReverseLinkedList().reverseList(node1));
    }

    public ListNode reverseList(ListNode A) {
        ListNode curr = A, prev = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
