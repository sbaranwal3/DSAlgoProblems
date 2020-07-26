package challenge.leetcode.july;

/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null)
            return result;
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            int n = Q.size();
            List<Integer> nodes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = Q.poll();
                nodes.add(node.val);
                if (node.left != null)
                    Q.add(node.left);
                if (node.right != null)
                    Q.add(node.right);
            }
            if (result.size() % 2 != 0)
                Collections.reverse(nodes);
            result.add(nodes);
        }
        return result;
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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("Level order reverse traversal of tree is: ");
        List<List<Integer>> result = zigzagLevelOrder(root);
        for (List<Integer> level : result)
            System.out.println(Arrays.toString(level.toArray()));
    }

}
