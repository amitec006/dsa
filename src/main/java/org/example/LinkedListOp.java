package org.example;

import org.example.dsa2.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedListOp {
    public static void main(String[] args) {
        //String str = "70888,2417,136,95979,93360,55711,80569,64649,19693,90763,23586,18259,15715,8892,1366,8309,66170,19072,14992,91483,97245,48005,33421,71066,13466,30368,64109,16774,75716,46089,16630,48154,54068,90749,79857,23699,36068,16539,75467,70069,8531,74888,45046,63364,1700,46827,66181,84044,5470,16145,15859,61819,39245,44618,56957,32737,83232,88394,10435,99447,74729,63209,41291,56117,73824,43939,87646,77242,23936,57145,19369,29799,7593,65583,90142,66660,16156,99084,69776,63866,76482,7229,73722,1848,80838,37809,49241,4559,40342,12830,72173,45910,13158,40251,52829,56422,80268,34148,49616,79998,42949,3770,43284,53760,13135,56608,25722,51506,84685,31359,83992,12095,93927,34882,54470,87060,52071,71099,40354,66851,76124,31100,30348,37187,65467,7775,58378,96237,39193,91903,11685,42785,71378,55261,60362,62463,389,19420,18059,94095,91510,38628,67099,76089,10315,88611,48118,80494,39632,98663,81366,87389,57555,96965,17183,59294,64328,14262,69012,89099,22182,73908,35167,24098,75015,2370,27693,46661,46956,91649,80784,68281,49911,11740,12379,21962,87504,80061,78154,63654,95841,245,63383,41278,43194,52888,20102,76552,493,25758,68442,64127,54866,51204,92989,45057,85637,73353,20860,94896,74531,52433,3209,79314,40753,66086,29240,88625,73365,6066,69506,48732,61435,79205,39653,1764,36241,9813,21121,67872,75627,84313,6396,69385,88992,3534,45344,13503,36587,61298,21976,7298,8715,50540,55222,73593,40675,60290,41040,80879,22426,2560,34718,45137,20573,90360,84414,71537,65944,40413,82801,71238,16033,77831,50779,65066,12781,39890,454,7258,85753,37502,39871,68602,7810,3952,38776,847,49197,51600,65349,30946,7616,52554,89823,44612,31655";
        String str = "1,2,3,4,5";
        String[] arr = str.split(",");
        System.out.println("Length: "+arr.length);
        ListNode node = new ListNode(Integer.parseInt(arr[0]));
        ListNode head = node;
        for(int i = 1; i < arr.length; i++) {
            head.next = new ListNode(Integer.parseInt(arr[i]));
            head = head.next;
        }

        print(node);
        //node = removeDuplicates(node);
        //node = removeNthNodeFromEnd(node, 1);
        //node = reverseKGroup(node,1);
        node = reverseBetween(node, 2,4);
        print(node);

        /*System.out.println(isPalindrome(node));
        print(node);
        node = reverse(node);
        System.out.println("After reversing linkedlist");
        print(node);*/

        /*//print insert delete palindrome reverse

        node = insert(node, 7, 0);
        System.out.println("After inserting data at 0th index");
        print(node);

        node = insert(node, 7, 1);
        System.out.println("After inserting data at 1st index");
        print(node);

        node = insert(node, 7, 10);
        System.out.println("After inserting data at 10th index");
        print(node);

        node = insert(node, 7, 10000);
        System.out.println("After inserting data at 10000th index");
        print(node);

        node = delete(node,  0);
        System.out.println("After deleting data at 0th index");
        print(node);

        node = delete(node,  1);
        System.out.println("After deleting data at 1st index");
        print(node);

        node = delete(node, 10);
        System.out.println("After deleting data at 10th index");
        print(node);

        node = delete(node,  10000);
        System.out.println("After deleting data at 10000th index");
        print(node);
*/


    }

    public static int longestPalindromeList(ListNode head) {
        if (head == null) return 0;

        ListNode prev = null, curr = head;
        int maxLength = 1;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            // Check for odd-length palindrome
            maxLength = Math.max(maxLength, 2 * countCommon(prev, next) + 1);

            // Check for even-length palindrome
            maxLength = Math.max(maxLength, 2 * countCommon(curr, next));

            prev = curr;
            curr = next;
        }

        return maxLength;
    }

    // Helper function to count common elements in two lists
    private static int countCommon(ListNode a, ListNode b) {
        int count = 0;
        while (a != null && b != null && a.val == b.val) {
            count++;
            a = a.next;
            b = b.next;
        }
        return count;
    }


    public static ListNode reverseBetween(ListNode head, int B, int C) {
        if (head == null || B == C) return head; // No reversal needed

        ListNode prev = null, curr = head;

        // Move `curr` to the B-th node and track the (B-1)th node (`beforeB`)
        for (int i = 1; curr != null && i < B; i++) {
            prev = curr;
            curr = curr.next;
        }

        ListNode beforeB = prev; // Node before B
        ListNode start = curr; // First node of the sublist to reverse

        // Reverse nodes from B to C
        ListNode next = null, prevReversed = null;
        for (int i = B; curr != null && i <= C; i++) {
            next = curr.next;
            curr.next = prevReversed;
            prevReversed = curr;
            curr = next;
        }

        // Connect the reversed portion with the remaining list
        if (beforeB != null) {
            beforeB.next = prevReversed; // Connect (B-1)th node to new head
        } else {
            head = prevReversed; // If B == 1, update head to new start
        }

        start.next = curr; // Connect last node of reversed part to remaining list

        return head;
    }


    public static ListNode reverseKGroup(ListNode head, int B) {
        if (head == null || B == 1) return head; // No need to reverse

        ListNode prev = null, curr = head, next = null;
        int count = 0;

        // Count the number of nodes in the list
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Reverse first B nodes if we have enough nodes to reverse
        if (count < B) return head; // No need to reverse if nodes are less than B

        curr = head;
        for (int i = 0; i < B && curr != null; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 'head' is now the last node of the reversed segment, connect it to the next reversed segment
        if (next != null) {
            head.next = reverseKGroup(next, B);
        }

        return prev; // New head of the reversed list
    }

    private static ListNode removeNthNodeFromEnd(ListNode head, int n) {
        ListNode first = head, second = head;
        if (n == 0) {
            return head;
        }

        // Move first pointer N steps ahead
        for (int i = 0; i < n; i++) {
            if (null != first.next) {
                first = first.next;
            } else {
                first = null;
                break;
            }
        }

        // If first becomes null, it means we need to remove the head
        if (first == null) {
            return head.next;
        }

        // Move both pointers until first reaches the end
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the Nth node from end
        second.next = second.next.next;

        return head;
    }

    private static ListNode removeDuplicates(ListNode node) {
        if (node == null) return null;
        Set<Integer> seen = new HashSet<>();
        ListNode current = node;
        seen.add(current.val);
        while (current.next != null) {
            if (seen.contains(current.next.val)) {
                current.next = current.next.next; // Skip duplicate
            } else {
                seen.add(current.next.val);
                current = current.next;
            }
        }
        return node;
    }

    public static ListNode reverse(ListNode node){
        ListNode curr = node, prev = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static boolean isPalindrome(ListNode node) {
        ListNode head1 = node;
        ListNode head2 = node;
        if (head1.next == null){
            return true;
        }
        int count = 0;
        while (head2.next != null && head2.next.next != null) {
            head1 = head1.next;
            head2 = head2.next.next;
            count++;
        }

        head2 = head1;

        head2 = reverse(head2);
        head1 = node;
        while (count >= 0) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
            count--;
        }
        return true;
    }

    public static ListNode delete(ListNode node, int index) {
        ListNode head = node;
        if (head == null) return head;
        if (index == 0) {
            return head.next;
        } else {
            for (int i = 0; i < index-1; i++) {
                if (head.next != null) {
                    head = head.next;
                }
            }
        }
        if (head.next != null) {
            head.next = head.next.next;
        }
        return node;
    }

    public static ListNode insert(ListNode node, int data, int index) {
        ListNode temp = new ListNode(data);
        ListNode head = node;
        if (head == null) return head;
        if (index == 0) {
            temp.next = head;
            return temp;
        } else {
            for (int i = 0; i < index-1; i++) {
                if (head.next != null) {
                    head = head.next;
                }
            }
        }

        if (head.next != null) {
            temp.next = head.next;
            head.next = temp;
        } else {
            head.next = temp;
        }
        return node;
    }

    public static void print(ListNode node) {
       ListNode temp = node;
       while (temp != null) {
           System.out.print(temp.val);
           System.out.print(" -> ");
           temp = temp.next;
       }
        System.out.print(" NULL ");
        System.out.println();
    }
}