package challenge.leetcode.august;

/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */

public class SumOfLeftLeaves {

    private static int sum=0;
    private static void sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if(isLeft && root.right==null && root.left==null){
            sum+= root.val;
            return;
        }
        if(root.left!=null)
            sumOfLeftLeaves(root.left, true);
        if(root.right!=null)
            sumOfLeftLeaves(root.right, false);
    }
    public static int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        sumOfLeftLeaves(root, false);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("Sum of left leaves of the given treeNode is: "+sumOfLeftLeaves(root));
    }
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
