package org.example.dsa2;

public class InsertNodeInLinkedList {
    /**
     * The first argument A is the head of a linked list.
     *
     * The second argument B is an integer which denotes the value of the new node
     *
     * The third argument C is an integer which denotes the position of the new node
     * @param args
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
        ListNode node = new InsertNodeInLinkedList().solve(node1, 0, 2);
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

    public ListNode solve(ListNode A, int B, int C) {
        ListNode node = new ListNode(B);
        if (null == A) {
            return node;
        }
        if (C == 0) {
            node.next = A;
            return node;
        } else {
            ListNode temp = A;
            for (int i = 1 ; i <= C-1; i++) {
                if (null != temp.next) {
                    temp = temp.next;
                }
            }
            ListNode next = temp.next;
            temp.next = node;
            node.next = next;
            return A;
        }
    }
}
