package challenge.leetcode.august;

/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */

public class ReorderList {

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null, curr = slow, tmp;
        while (curr != null) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        ListNode n1 = head, n2 = prev;
        while (n2.next != null) {
            tmp = n1.next;
            n1.next = n2;
            n1 = tmp;

            tmp = n2.next;
            n2.next = n1;
            n2 = tmp;
        }
    }

    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
