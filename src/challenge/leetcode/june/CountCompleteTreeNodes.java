package challenge.leetcode.june;

/*
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input:
    1
   / \
  2   3
 / \  /
4  5 6
 */

public class CountCompleteTreeNodes {
    static int count = 0;

    public static int countNodes(TreeNode root) {
        if (root == null)
            return count;
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }

    public static int countNodesApproach2(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode left = root, right = root;
        int hLeft =0, hRight = 0;
        while (left!=null){
            hLeft++;
            left = left.left;
        }
        while(right!=null){
            hRight++;
            right = right.right;
        }
        if(hLeft == hRight)
            return (1<<hLeft)-1;
        return 1+ countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
     //   System.out.println("No. of nodes in the tree is: " + countNodes(root));
        System.out.println("No. of nodes in the tree using Approach 2 is: " + countNodesApproach2(root));
    }

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

}


