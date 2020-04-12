package challenge.leetcode.days.thirty;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */

public class DiameterOfBinaryTree {

    // Definition for a binary tree node.
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    static int diameter=0;
    private static int maxHeight(TreeNode root){
        if(root==null)
            return 0;
        int left = maxHeight(root.left);
        int right = maxHeight(root.right);
        diameter = Math.max(left+right,diameter);
        return Math.max(left,right)+1;

    }
    public static int diameterOfBinaryTree(TreeNode root) {
        maxHeight(root);
        return diameter ;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        System.out.println("Diameter of the given binary tree is: "+diameterOfBinaryTree(treeNode));

    }

}
