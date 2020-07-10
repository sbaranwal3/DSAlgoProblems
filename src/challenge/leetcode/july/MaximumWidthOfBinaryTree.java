package challenge.leetcode.july;

/*
Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:

Input:

           1
         /   \
        3     2
       / \     \
      5   3     9

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:

Input:

          1
         /
        3
       / \
      5   3

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:

Input:

          1
         / \
        3   2
       /
      5

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:

Input:

          1
         / \
        3   2
       /     \
      5       9
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


Note: Answer will in the range of 32-bit signed integer.
 */

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        Queue<Pair<TreeNode, Integer>> Q = new LinkedList<>();
        Q.add(new Pair<>(root, 0));
        int maxWidth = 0;
        while (!Q.isEmpty()) {
            int n = Q.size();
            int start = Q.peek().getValue();
            Pair<TreeNode, Integer> pair = null;
            TreeNode node;
            for (int i = 0; i < n; i++) {
                pair = Q.poll();
                node = pair.getKey();
                if (node.left != null)
                    Q.add(new Pair<>(node.left, 2 * pair.getValue() + 1));
                if (node.right != null)
                    Q.add(new Pair<>(node.right, 2 * pair.getValue() + 2));
            }
            int end = pair.getValue();
            maxWidth = Math.max(maxWidth, end - start + 1);
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        System.out.println("Width of binary tree is: " + widthOfBinaryTree(root));
    }
}
