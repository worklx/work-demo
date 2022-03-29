package com.work.leetcode.binarytree;

public class BinaryTree101 {
    /**
     * 101. 对称二叉树
     * 给你一个二叉树的根节点，检查它是否轴对称
     * @param args
     */
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private static boolean check(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }
}
