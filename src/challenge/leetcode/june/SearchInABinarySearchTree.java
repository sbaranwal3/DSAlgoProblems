package challenge.leetcode.june;

/*
Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

For example,

Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2
You should return this subtree:

      2
     / \
    1   3
In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.

Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.
 */

public class SearchInABinarySearchTree {
    //Recursive
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        else if (root.val > val) // root.val > val which means our node is in the left subtree
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val); // root.val < val which means our node is in the right subtree
    }

    //Iterative
    public static TreeNode searchBSTApproach2(TreeNode root, int val) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val == val)
                return curr;
            if (curr.val > val) curr = curr.left;
            else curr = curr.right;
        }
        return curr;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println("Root using iterative approah is: ");
        printInorder(searchBSTApproach2(root, 2));
        System.out.println("Root using recursive approach is: ");
        printInorder(searchBST(root, 2));
    }

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printInorder(node.left);
        printInorder(node.right);
    }
}



