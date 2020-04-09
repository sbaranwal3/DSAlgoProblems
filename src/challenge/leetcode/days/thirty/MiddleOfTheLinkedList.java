package challenge.leetcode.days.thirty;

public class MiddleOfTheLinkedList {

    /**
     * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
     *
     * If there are two middle nodes, return the second middle node.
     *
     *
     *
     * Example 1:
     *
     * Input: [1,2,3,4,5]
     * Output: Node 3 from this list (Serialization: [3,4,5])
     * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
     * Note that we returned a ListNode object ans, such that:
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
     * Example 2:
     *
     * Input: [1,2,3,4,5,6]
     * Output: Node 4 from this list (Serialization: [4,5,6])
     * Since the list has two middle nodes with values 3 and 4, we return the second one.
     *
     *
     * Note:
     *
     * The number of nodes in the given list will be between 1 and 100.
     */

    /**
     * Definition for singly-linked list.
     **/

      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }


      //Mid node logic through two pointers
    public static ListNode middleNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        if(head != null){
            //Traverse until fastPointer becomes null & print the slowPointer at that time
            while(fastPointer != null && fastPointer.next != null){
                fastPointer = fastPointer.next.next;
                slowPointer = slowPointer.next;
            }
        }
        return slowPointer;

    }

        public static void main(String [] args)
        {
//            LinkedList newList = new LinkedList<>();
//            for(int i=5; i>0; i--){
//                newList.push(i);
//            }
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);

            ListNode midNode = middleNode(head);
            printMidNodeAndValues(midNode);
        }

    private static void printMidNodeAndValues(ListNode midNode) {
        System.out.println("Middle element and it's values are: ");
          while(midNode!=null){
              System.out.println(midNode.val);
              midNode = midNode.next;
          }
    }
}
