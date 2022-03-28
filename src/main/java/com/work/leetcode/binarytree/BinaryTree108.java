package com.work.leetcode.binarytree;

/**
 * 108. 将有序数字转换为二叉搜索树
 * 二分搜索树（英语：Binary Search Tree），也称为 二叉查找树 、二叉搜索树 、有序二叉树或排序二叉树。满足以下几个条件：
 * 若它的左子树不为空，左子树上所有节点的值都小于它的根节点。
 * 若它的右子树不为空，右子树上所有的节点的值都大于它的根节点。
 * @author chenlx2
 */
public class BinaryTree108 {

    public static void main(String[] args) {
        BinaryTree108 demo = new BinaryTree108();
        Integer[] arr = {1,2,3,4,5,6,7};
        TreeNode root = BinaryTreeUtil.arrToTree(arr);
        BinaryTreePrintUtil.print(root);
        BinaryTreePrintUtil.print(demo.sortedArrayToBST(BinaryTreeUtil.transfer(arr)));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null) {
            return null;
        }
        // 因数组是有序的，可以先找到中间值的索引，即数组中间位置
        // 元素总数量奇数个，中间索引 = nums.length/2;     ==>  (nums.length+1)/2  向下取整
        // 元素总数量偶数个，中间索引 = nums.length/2 + 1; ==>  (nums.length+1)/2
        // 找到中间值的索引
        int midValueIndex = (nums.length + 1) / 2;
        // 找到中间值
        int midValue = nums[midValueIndex];

        // 根据中间值的索引拆分数组 [0,midValueIndex-1] [midValueIndex+1, nums.length-1]
        int[] leftArr = new int[midValueIndex];
        int[] rightArr = new int[nums.length - 1 - midValueIndex];

        // 中间值作为根节点
        TreeNode root = new TreeNode(midValue);
        // 构建根节点左子树
        root.left = sortedArrayToBST(leftArr);
        // 构建根节点右子树
        root.right = sortedArrayToBST(rightArr);
        return root;
    }
}
/*
1,2,3,4,5,6,7

      4
    /   \
  2       6
 / \     / \
1   3   5   7
 */