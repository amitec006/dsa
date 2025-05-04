package org.example.dsa2;

public class PrintLinkedList {
    public void solve(ListNode A) {
        ListNode temp = A;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
