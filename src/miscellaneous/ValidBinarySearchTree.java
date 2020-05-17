package miscellaneous;

/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidBinarySearchTree {
    public static boolean isValidBST(TreeNode root) {
        return bstValidator(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean bstValidator(TreeNode root, long minValue, long maxValue) {
        if (root == null)
            return true;
        if (minValue >= root.val || maxValue <= root.val)
            return false;
        return bstValidator(root.left, minValue, root.val) && bstValidator(root.right, root.val, maxValue);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);
        System.out.println("Is the given tree a BST? " + isValidBST(root));
        System.out.println(37<<3);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }

}
