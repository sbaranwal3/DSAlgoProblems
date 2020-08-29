package challenge.leetcode.august;

/*
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */

public class PathSumIII {

    public static int pathSumCal(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int res = 0;
        if (root.val == sum) res++;
        res += pathSumCal(root.left, sum - root.val);
        res += pathSumCal(root.right, sum - root.val);
        return res;
    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return pathSum(root.left, sum) + pathSumCal(root, sum) + pathSum(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(-3);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(3);
        treeNode.left.left.right = new TreeNode(2);
        treeNode.left.right.right = new TreeNode(1);
        treeNode.left.left.left.left = new TreeNode(3);
        treeNode.left.left.left.right = new TreeNode(-2);
        int sum = 8;
        System.out.println("Number of paths that sum to "+sum+" are: "+pathSum(treeNode, sum));
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
}
