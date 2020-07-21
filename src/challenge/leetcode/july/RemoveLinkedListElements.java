package challenge.leetcode.july;

/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 */

public class RemoveLinkedListElements {

    //Recursive
    public static ListNode removeElementsApp2(ListNode head, int val) {
        if (head == null) return null;
        ListNode prev = null, curr = head;
        while (curr != null) {
            if (curr.val == val) {
                if (prev == null) head = curr.next;
                else prev.next = curr.next;
            } else
                prev = curr;
            curr = curr.next;
        }
        return head;
    }

    //Iterative
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode ret = removeElements(head.next, val);
        if (head.val == val)
            return ret;
        head.next = ret;
        return head;
    }

    /**
     * Definition for singly-linked list.
     **/

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        ListNode node = removeElements(head, 6);
        System.out.println("List after removing elements with val is: ");
        printList(node);
    }

    /* Function to print linked list */
    static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.printf("%d ", temp.val);
            temp = temp.next;
        }
        System.out.printf("\n");
    }
}
