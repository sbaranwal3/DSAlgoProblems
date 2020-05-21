package challenge.leetcode.may;

/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.



Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?



Constraints:

The number of elements of the BST is between 1 to 10^4.
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */

public class KthSmallestElementInABST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int count;
    static int result;

    public static int kthSmallest(TreeNode root, int k) {
        kthInorder(root, k);
        return result;
    }

    static void kthInorder(TreeNode root, int k) {
        if (root.left != null)
            kthInorder(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        if (root.right != null)
            kthInorder(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        int k = 3;
        System.out.println("Kth smallest element in the BST is: " + kthSmallest(root, k));
    }
//                    5
//                   / \
//                  3   6
//                 / \
//               2   4
//              /
//             1
}
