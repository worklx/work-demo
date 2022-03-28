package com.work.leetcode.binarytree;

/**
 * @author chenlx2
 */
public class BinaryTree654 {

    /**
     * 654.构造最大二叉树
     * 给定一个不含重复元素的整数数组，一个以此数组构建的最大二叉树：
     * 1）二叉树的根是数组中最大的元素
     * 2）左子树是通过数组中最大值左边部分构造出的最大二叉树
     * 3）右子树是通过数组中最大值右边部分构造出的最大二叉树
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {3,2,1,6,0,5};
        TreeNode root = constructMaximumBinaryTree(arr);
        BinaryTreePrintUtil.print(root);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private static TreeNode constructMaximumBinaryTree(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return null;
        }
        // 找到数组索引[leftIndex,rightIndex]范围内最大的值
        int maxValue = nums[0];
        // 找到最大值的索引值
        int maxValueIndex = leftIndex;
        for(int i = leftIndex; i <= rightIndex; i++) {
            if(nums[i] > maxValue) {
                maxValue = nums[i];
                maxValueIndex = i;
            }
        }
        // 构建根节点
        TreeNode root = new TreeNode(nums[maxValueIndex]);
        // 构建根节点左子树
        root.left = constructMaximumBinaryTree(nums, leftIndex, maxValueIndex - 1);
        // 构建根节点右子树
        root.right = constructMaximumBinaryTree(nums, maxValueIndex + 1, rightIndex);
        return root;
    }

    private static int findMaxValueIndex(int[] nums, int leftIndex, int rightIndex) {
        // 找到数组索引[leftIndex,rightIndex]范围内最大的值
        int maxValue = nums[0];
        // 找到最大值的索引值
        int maxValueIndex = leftIndex;
        for(int i = leftIndex; i <= rightIndex; i++) {
            if(nums[i] > maxValue) {
                maxValue = nums[i];
                maxValueIndex = i;
            }
        }
        return maxValueIndex;
    }

//    public static TreeNode constructMaximumBinaryTree(int[] nums) {
//        if(nums == null || nums.length == 0) {
//            return null;
//        }
//        // 找到数组中的最大值
//        int maxValue = nums[0];
//        // 找到最大值的索引
//        int maxValueIndex = 0;
//        for(int i = 0; i < nums.length; i++) {
//            if(nums[i] > maxValue) {
//                maxValue = nums[i];
//                maxValueIndex = i;
//            }
//        }
//        // 根据最大值的索引拆分数组
//        int[] leftArr = new int[maxValueIndex];
//        int[] rightArr = new int[nums.length - 1 - maxValueIndex];
//        for(int i = 0; i < maxValueIndex; i++) {
//            leftArr[i] = nums[i];
//        }
//        for(int i = maxValueIndex + 1, j = 0; i < nums.length; i++, j++) {
//            rightArr[j] = nums[i];
//        }
//        // 构建根节点
//        TreeNode root = new TreeNode(maxValue);
//        // 构建根节点左子树
//        root.left = constructMaximumBinaryTree(leftArr);
//        // 构建根节点右子树
//        root.right = constructMaximumBinaryTree(rightArr);
//        return root;
//    }
//
//    public static TreeNode constructMaximumBinaryTree(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return null;
//        }
//        // 找到数组最大值
//        Integer maxValue = null;
//        // 找到数组最大值左侧数组
//        int[] leftArr = null;
//        // 找到数组最大值右侧数组
//        int[] rightArr = null;
//        // 构建根节点
//        TreeNode root = new TreeNode(maxValue);
//        // 构建左子树
//        root.left = constructMaximumBinaryTree(leftArr);
//        // 构建右子树
//        root.right = constructMaximumBinaryTree(rightArr);
//        return root;
//    }
}