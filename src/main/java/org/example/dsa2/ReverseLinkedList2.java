package org.example.dsa2;

public class ReverseLinkedList2 {
    /**
     * Reverse a linked list A from position B to C.
     *
     * NOTE: Do it in-place and in one-pass.
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
        ListNode node = new ReverseLinkedList2().reverseBetween(node1,2, 5);
        printNode(node);
    }

    public ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode currNode = A, prevNode = null;
        int i;

        // Move currNode to the position m
        for (i = 1; i < B; i++) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        // Store pointers to the start
        // and end of the reversed segment
        ListNode revHead = currNode;
        ListNode revTail = null;

        // Reverse the linked list from position m to n
        ListNode nextNode;
        while (i <= C) {
            nextNode = currNode.next;
            currNode.next = revTail;
            revTail = currNode;
            currNode = nextNode;
            i++;
        }

        // Connect the reversed segment back to the list
        if (prevNode != null) {
            prevNode.next = revTail;
        }
        else {
            A = revTail;
        }
        revHead.next = currNode;

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
