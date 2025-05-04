package org.example.dsa2;

public class RemoveDuplicatesFromSortedLinkedList {
    /**
     * Given a sorted linked list, delete all duplicates such that each element appears only once.
     */

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode node6 = new ListNode(5);
        node5.next = node6;
       // ListNode node7 = new ListNode(6);
       // node6.next = node7;
        printNode(node1);
        ListNode node = new RemoveDuplicatesFromSortedLinkedList().deleteDuplicates(node1);
        printNode(node);
    }

    public ListNode deleteDuplicates(ListNode A) {
        ListNode temp = A;
        while (temp != null) {
            ListNode next = temp.next;
            if (next != null && temp.val == next.val) {
                while (next != null && temp.val == next.val) {
                    next = next.next;
                }
                temp.next = next;
            } else {
                temp = temp.next;
            }
        }
        return A;
    }

    private static void printNode(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.print(temp.val+ " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

}
