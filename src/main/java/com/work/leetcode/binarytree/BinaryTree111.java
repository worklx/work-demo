package com.work.leetcode.binarytree;

public class BinaryTree111 {
    public static void main(String[] args) {
        BinaryTreePrintUtil.print(BinaryTreeUtil.arrToTree(new Integer[]{3,9,20,null,null,15,7}));
        BinaryTreePrintUtil.print(BinaryTreeUtil.arrToTree(new Integer[]{2,null,3,null,4,null,5,null,6}));
    }
    /**
     *
     * 111. 二叉树的最小深度
     从根节点分析：
     1）如果根节点就是空节点，则最小深度就是 0
     2）如果根节点的左子节点且右子节点是空节点，那么最小深度就是 1
     3）如果根节点的左子节点不为空，右子节点为空，则计算左子树的最小深度
     4）如果根节点的右子节点不为空，左子节点为空，则计算右子树的最小深度
     5）如果根节点的左子节点和右子节点都不是空节点，则需要依次计算左子树和右子树的最小深度，取两者最小值
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
//        if (root.left != null && root.right != null) {
//            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
//        }
//        if (root.left != null && root.right == null) {
//            return minDepth(root.left) + 1;
//        }
//        if (root.left == null && root.right != null) {
//            return minDepth(root.right) + 1;
//        }
       // root.left 不为空，则需要计算 左子树最小深度 minDepth(root.left)
       // root.right 不为空，则需要计算 右子树最小深度 minDepth(root.right)
//       int minLeft;
//       int minRight;
//       if (root.left != null) {
//           minLeft = minDepth(root.left);
//       }
//       if (root.right != null) {
//           minRight = minDepth(root.right);
//       }
//       return Math.min(minLeft, minRight) + 1;
       // minLeft 和 minRight 需要初始化
       // 初始化赋值什么比较好呢？可以先赋值一个很大的值，然后分别和 minDepth() 结果比较取最小值
//        int minLeft = Integer.MAX_VALUE;
//        int minRight = Integer.MAX_VALUE;
//        if (root.left != null) {
//            minLeft = Math.min(minDepth(root.left), minLeft);
//        }
//        if (root.right != null) {
//            minRight = Math.min(minDepth(root.right), minRight);
//        }
//        return Math.min(minLeft, minRight) + 1;

        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepth(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }
        return min + 1;
    }
}
