package com.work.leetcode.binarytree;


public class BinaryTree104 {

    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        TreeNode root = BinaryTreeUtil.arrToTree(arr);
        BinaryTreePrintUtil.print(root);
        System.out.println(new BinaryTree104().maxDepth(root));
    }

    /**
     * 104. 二叉树的最大深度
     从根节点分析：
     1）如果根节点就是空节点，则最大深度就是 0
     2）如果根节点的左子节点且右子节点是空节点，那么最大深度就是 1
     3）如果根节点的左子节点不为空，右子节点为空，则计算左子树的最大深度
     4）如果根节点的右子节点不为空，左子节点为空，则计算右子树的最大深度
     5）如果根节点的左子节点和右子节点都不是空节点，则需要依次计算左子树和右子树的最大深度，取两者最大值
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
//        if (root.left != null && root.right != null) {
//            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//        }
//        if (root.left != null && root.right == null) {
//            return maxDepth(root.left) + 1;
//        }
//        if (root.left == null && root.right != null) {
//            return maxDepth(root.right) + 1;
//        }
        // root.left 不为空，则需要计算 左子树最大深度 maxDepth(root.left)
        // root.right 不为空，则需要计算 右子树最大深度 maxDepth(root.right)
//        int maxLeft;
//        int maxRight;
//        if (root.left != null) {
//            maxLeft = maxDepth(root.left);
//        }
//        if (root.right != null) {
//            maxRight = maxDepth(root.right);
//        }
//        return Math.max(maxLeft, maxRight) + 1;
        // maxLeft 和 maxRight 需要初始化
        // 初始化赋值什么比较好呢？可以先赋值一个很小的值，然后分别和 maxDepth() 结果比较取最大值
//        int maxLeft = Integer.MIN_VALUE;
//        int maxRight = Integer.MIN_VALUE;
//        if (root.left != null) {
//            maxLeft = Math.max(maxDepth(root.left), maxLeft);
//        }
//        if (root.right != null) {
//            maxRight = Math.max(maxDepth(root.right), maxRight);
//        }
//        return Math.min(maxLeft, maxRight) + 1;

//        int max = Integer.MIN_VALUE;
//        if (root.left != null) {
//            max = Math.max(maxDepth(root.left), max);
//        }
//        if (root.right != null) {
//            max = Math.max(maxDepth(root.right), max);
//        }
//        return max + 1;
        // 若不加 if (root.left != null) 会怎么样？若 root.left == null 为怎么样？
        // maxDepth(root.left) 会再递归一次, 会直接返回 1
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return Math.max(maxLeft, maxRight) + 1;
//        else {
//            int leftDepth = maxDepth(root.left);
//            int rightDepth = maxDepth(root.right);
//            return Math.max(leftDepth, rightDepth) + 1;
//        }
    }

}
