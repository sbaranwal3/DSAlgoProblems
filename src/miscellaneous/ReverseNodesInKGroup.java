package miscellaneous;
/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes
is not a multiple of k then left-out nodes in the end should be:
1. be as is
2. be reversed

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesInKGroup {

    //Approach for scenario1
    public static ListNode reverseKGroupApproach1(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode fast = head;

        while (fast != null) {
            int count = k;
            while (fast != null && count-- > 1) {
                fast = fast.next;
            }
            if (fast == null) {
                break;
            }
            ListNode next = fast.next;
            fast.next = null; // cut
            ListNode newH = reverse(head); // reverse
            cur.next = newH; // connect to prev sub list
            cur = head; // set the cur
            head = next; // reset the head of sub list
            fast = next; // reset the tail of sub list
        }
        cur.next = head; // the last sub list may not have k nodes
        return dummy.next;
    }
    public static ListNode reverse(ListNode head) {
        ListNode newH = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newH;
            newH = head;
            head = next;
        }
        return newH;
    }



    //Approach for scenario 2
    public static ListNode reverseKGroupApproach2(ListNode head, int k)
    {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

            int count = 0;

            /* Reverse first k nodes of linked list */
            while (count < k && current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }
                   /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
            if (next != null) {
                head.next = reverseKGroupApproach2(next, k);
            }

        // prev is now head of input list
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
//        ListNode reversed = reverseKGroupApproach1(listNode, 3);
//        printList(reversed);
        ListNode reversedApproach2 = reverseKGroupApproach2(listNode, 3);
        printList(reversedApproach2);
    }

    static void printList(ListNode head)
    {
        ListNode temp = head;
        while (temp != null)
        {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}

//Definition for singly-linked list.
 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
