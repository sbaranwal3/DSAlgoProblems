package miscellaneous;
/*
Given a linked list and two integers M and N. Traverse the linked list such that you retain M nodes then delete next N nodes,
 continue the same till the end of the linked list.
 For example, an input of M = 2, N = 2 Linked List: 1->2->3->4->5->6->7->8 should return Linked List: 1->2->5->6
 */

public class DeleteNNodesAfterMNodesInALinkedList {
    /**
     * Definition for singly-linked list.
     **/

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void skipMdeleteN(ListNode head, int M, int N){
        ListNode current = head;
        ListNode t;
        int count;

        // The main loop that traverses
        // through the whole list
        while(current!=null){
            // Skip M nodes
            for(count=1; count<M && current!=null; count++)
                current=current.next;
            // If we reached end of list, then return
            if(current==null)
                return;

            // Start from next node and delete N nodes
            t=current.next;
            for (count=1; count<=N && t!=null; count++){
                t = t.next;
            }
            // Link the previous list with remaining nodes
            current.next = t;

            // Set current pointer for next iteration
            current = t;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        System.out.println("Linked List before removal is: ");
        printList(head);
        skipMdeleteN(head, 2,2);
        System.out.println("Linked List after removal is: ");
        printList(head);

    }

    /* Function to print linked list */
    static void printList( ListNode head)
    {
        ListNode temp = head;
        while (temp != null)
        {
            System.out.printf("%d ", temp.val);
            temp = temp.next;
        }
        System.out.printf("\n");
    }
}
