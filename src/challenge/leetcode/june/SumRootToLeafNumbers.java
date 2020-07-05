package challenge.leetcode.june;

/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
 */

public class SumRootToLeafNumbers {
    private static int result;

    public static int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        findSum(root, 0);
        return result;
    }

    private static void findSum(TreeNode root, int val) {
        int curr = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            result += curr;
            return;
        }
        if (root.left != null)
            findSum(root.left, curr);
        if (root.right != null)
            findSum(root.right, curr);
    }


    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println("Sum of root to leaf numbers is: " + sumNumbers(root));
    }
}
