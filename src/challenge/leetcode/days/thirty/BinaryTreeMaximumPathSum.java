package challenge.leetcode.days.thirty;
/*
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

public class BinaryTreeMaximumPathSum {

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


    //Approach 1
    public static int maxPathSum(TreeNode root) {
        AtomicInteger h = new AtomicInteger(Integer.MIN_VALUE);
        return mpSum(root, h);
    }

    public static int mpSum(TreeNode root, AtomicInteger h) {
        if (root == null)
            return Integer.MIN_VALUE;
        AtomicInteger h1 = new AtomicInteger(Integer.MIN_VALUE);
        AtomicInteger h2 = new AtomicInteger(Integer.MIN_VALUE);
        int d1 = mpSum(root.left, h1);
        int d2 = mpSum(root.right, h2);

        h.set(Math.max(Math.max(h1.get(),h2.get()),0)+ root.val);

        return Math.max(Math.max(d1, d2), Math.max(h1.get(), 0) + Math.max(h2.get(), 0) + root.val);
    }


    //Approach 2
    static int max_sum;
    public static int maxPathSumApproach2(TreeNode root) {
        max_sum = Integer.MIN_VALUE;
        maxGain(root);
        return max_sum;
    }

    static int maxGain(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        int sum = root.val + leftGain + rightGain;
        max_sum = Math.max(max_sum, sum);
        return root.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println("Max path sum is: " + maxPathSum(treeNode));
        System.out.println("Max path sum using approach2 is: "+maxPathSumApproach2(treeNode));
    }
}
