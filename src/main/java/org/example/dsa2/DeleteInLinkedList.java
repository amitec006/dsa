package org.example.dsa2;

public class DeleteInLinkedList {
    /**
     * The first argument A is the head of a linked list.
     *
     * The second arguement B is an integer.
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
        printNode(node1);
        ListNode node = new DeleteInLinkedList().solve(node1, 1);
        printNode(node);
    }

    private static void printNode(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.print(temp.val+ " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public ListNode solve(ListNode A, int B) {
        if (A == null) {
            return A;
        }
        if (B == 0) {
            A = A.next;
            return A;
        }
        ListNode node = A;
        ListNode prev = null;
        for(int i = 0; i < B; i++) {
            prev = node;
            node = node.next;
        }
        prev.next = node.next;
        return A;
    }
}
