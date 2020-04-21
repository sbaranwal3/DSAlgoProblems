package challenge.leetcode.days.thirty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  Construct Binary Search Tree from Preorder Traversal
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node,
any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.
Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)



Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

Note:

1 <= preorder.length <= 100
The values of preorder are distinct.
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {

    //TreeNode class
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        return buildTree(preorder, 0, n - 1);
    }

    //Method to pass tree with indices passed
    private static TreeNode buildTree(int[] preorder, int l, int r) {
        if (l > r)
            return null;
        TreeNode root = new TreeNode(preorder[l]);
        if (l == r)
            return root;
        int index = l + 1;
        while (index <= r && preorder[index] < preorder[l])
            index++;
//The above index signifies the point from which right node of the root is constructed and before which left node is constructed
        root.left = buildTree(preorder, l + 1, index - 1);
        root.right = buildTree(preorder, index, r);

        return root;

    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = bstFromPreorder(preorder);
        System.out.println("The bst form of preOrder traversal is: ");
        printInorder(root);
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
