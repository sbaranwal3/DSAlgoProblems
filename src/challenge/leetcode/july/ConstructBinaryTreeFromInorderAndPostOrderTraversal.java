package challenge.leetcode.july;

/*
Given inorder(Left, Root, Right) and postorder(Left, Right, Root) traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */

public class ConstructBinaryTreeFromInorderAndPostOrderTraversal {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if (n == 0) return null;
        return buildTreeRec(inorder, 0, n, postorder, 0, n);
    }

    public static TreeNode buildTreeRec(int[] inorder, int i1, int i2, int[] postorder, int p1, int p2) {
        if (i1 >= i2 || p1 >= p2) return null;
        TreeNode root = new TreeNode(postorder[p2 - 1]);
        int it = 0;
        for (int i = i1; i < i2; i++) {
            if (postorder[p2 - 1] == inorder[i]) {
                it = i;
                break;
            }
        }
        int diff = it - i1;
        root.left = buildTreeRec(inorder, i1, i1 + diff, postorder, p1, p1 + diff);
        root.right = buildTreeRec(inorder, i1 + diff + 1, i2, postorder, p1 + diff, p2 - 1);
        return root;
    }


    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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
