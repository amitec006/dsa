package org.example.dsa2;

public class RemoveNthNodeFromList {
    /**
     * Given a linked list A, remove the B-th node from the end of the list and return its head.
     * For example, given linked list: 1->2->3->4->5, and B = 2.
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     *
     * NOTE: If B is greater than the size of the list, remove the first node of the list.
     *
     * Try doing it using constant additional space.
     */

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode node6 = new ListNode(6);
        node5.next = node6;
        ListNode node7 = new ListNode(7);
        node6.next = node7;
        printNode(node1);
        ListNode node = new RemoveNthNodeFromList().removeNthFromEnd(node1,20);
        printNode(node);
    }

    public ListNode removeNthFromEnd(ListNode A, int B){
        ListNode fast = A;
        ListNode slow = A;

        for (int i = 0; i < B; i++) {
            if (fast == null) {
                A = A.next;
                return A;
            }
            fast = fast.next;
        }

        if (fast == null) {
            A = A.next;
            return A;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
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
