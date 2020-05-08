package challenge.leetcode.may;

/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.



Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false


Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
 */
public class CousinsInBinaryTree {
    public static boolean isCousins(TreeNode root, int x, int y) {
        if (x == root.val || y == root.val)
            return false;

        return sameLevel(root, x, y) && !isSameParent(root, x, y);
    }

    private static boolean sameLevel(TreeNode root, int x, int y) {
        return getLevel(root, x) == getLevel(root, y);
    }

    private static boolean isSameParent(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        if (root.left != null && root.right != null && ((root.left.val == x && root.right.val == y) || (root.right.val == x && root.left.val == y)))
            return true;
        return isSameParent(root.left, x, y) || isSameParent(root.right, x, y);
    }

    static int getLevelUtil(TreeNode root, int data, int level) {
        if (root == null)
            return 0;

        if (root.val == data)
            return level;

        int downlevel = getLevelUtil(root.left, data, level + 1);
        if (downlevel != 0)
            return downlevel;

        downlevel = getLevelUtil(root.right, data, level + 1);
        return downlevel;
    }

    /* Returns level of given data value */
    static int getLevel(TreeNode root, int data) {
        return getLevelUtil(root, data, 0);
    }

    static TreeNode xParent = null;
    static TreeNode yParent = null;
    static int xDepth = -1, yDepth = -1;
    public static boolean isCousinsApproach2(TreeNode root, int x, int y) {
        findDepthAndParent(root, x, y, 0, null);
        return xDepth == yDepth && xParent != yParent;
    }
    public static void findDepthAndParent(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null){
            return;
        }
        if(root.val == x){
            xParent = parent;
            xDepth = depth;
        }else if(root.val == y){
            yParent = parent;
            yDepth = depth;
        } else {
            findDepthAndParent(root.left, x, y, depth + 1, root);
            findDepthAndParent(root.right, x, y, depth + 1, root); }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        int x = 5, y = 4;
        System.out.println("Are nodes " + x + " & " + y + " cousins? " + isCousins(root, x, y));
        System.out.println("Are nodes " + x + " & " + y + " cousins using Approach2? " + isCousinsApproach2(root, x, y));
    }
}


// Definition for a binary tree node.
class TreeNode {
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