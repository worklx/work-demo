package com.work.leetcode.binarytree;

//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。
//
// 示例 1:
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
//
// 示例 2:
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
//
// 提示:
// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder 和 inorder 均 无重复 元素
// inorder 均出现在 preorder
// preorder 保证 为二叉树的前序遍历序列
// inorder 保证 为二叉树的中序遍历序列

import java.util.HashMap;

public class BinaryTree105 {
    /**
    先序遍历：对任一子树，先访问根，然后遍历其左子树，最后遍历其右子树。
    中序遍历：对任一子树，先遍历其左子树，然后访问根，最后遍历其右子树。
    后序遍历：对任一子树，先遍历其左子树，然后遍历其右子树，最后访问根。

    若知道先序遍历结果，那么第一个元素即是根节点
    若知道后序遍历结果，那么最后一个元素即是根节点
    若知道根节点和中序遍历结果，那么可以用根节点将中序遍历结果进行拆分

          3
        /   \
      9       20
     / \     / \
    6   8   15  7
    preorder = [3, 9, 6, 8, 20, 15, 7]
    inorder = [6, 9, 8, 3, 15, 20, 7]

     preorder 的第一个元素 3 是根节点的值 rootValue = 3
     元素 3 在 inorder 中的索引是 3  rootIndex = 3
     左子树的个数的值等于 rootIndex leftSize = 3
     右子树的个数的值等于 inorder.size - 1 - rootIndex  rightSize = 3
     preorder 的 [0 + 1 , leftSize + 1] 范围是 [9,6,8] 是左子树的前序遍历
     inorder 的 [0, leftSize] 范围是 [6,9,8] 是左子树的中序遍历

     preorder 的 [rootIndex + 1, preorder.length - 1] 范围是 [20,15,7] 是右子树的前序遍历
     inorder 的 [rootIndex + 1, inorder.length - 1] 范围是 [15,20,7] 是右子树的中序遍历
     重复上述过程
    */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> valueIndexMap = new HashMap();
        for(int i = 0; i < inorder.length; i++) {
            valueIndexMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, valueIndexMap);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preLeftIndex, int preRightIndex, int inLeftIndex, int inRightIndex, HashMap<Integer, Integer> valueIndexMap) {
        // 找到根节点的值
        int rootValue = preorder[preLeftIndex];
        // 找到根节点的索引
        int rootIndex = valueIndexMap.get(rootValue);
        // 构建根节点
        TreeNode root = new TreeNode(rootValue);
        // 构建左子树
        root.left = buildTree(preorder, inorder, preLeftIndex + 1, preLeftIndex + 1 + rootIndex - inLeftIndex, inLeftIndex, rootIndex - 1, valueIndexMap);
        // 构建右子树
        root.right = buildTree(preorder, inorder, rootIndex +1, preRightIndex, rootIndex + 1, inRightIndex, valueIndexMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length == 1 && inorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        // 找到根节点
        int rootValue = preorder[0];
        // 找到根节点在中序遍历中的索引
        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
            }
        }
        // 计算左子树和右子树节点数量
        int leftSize = rootIndex;
        int rightSize = inorder.length - 1 - rootIndex;
        // 构建根节点
        TreeNode root = new TreeNode(rootValue);
        // 构建根节点左子树
        if (leftSize > 0) {
            // 如果左子树个数只有 1 个
            int[] leftPreorder = new int[leftSize];
            int[] leftInorder = new int[leftSize];
            for (int i = 1, j = 0; i <= leftSize; i++, j++) {
                // 得到左子树的前序遍历 从 preorder 第 2 个元素开始，取 leftSize 个元素
                // 如果左子树个数只有 1 个，取 1 个元素放入，实际是根节点
                leftPreorder[j] = preorder[i];
            }
            for (int i = 0, j = 0; i < leftSize; i++, j++) {
                // 得到左子树的中序遍历 从 inorder 第 0 个元素开始，取 leftSize 个元素
                // 如果左子树个数只有 1 个，取 1 个元素放入，实际是根节点
                leftInorder[j] = inorder[i];
            }
            root.left = buildTree(leftPreorder, leftInorder);
        }
        // 构建根节点右子树
        if (rightSize > 0) {
            // 如果右子树个数只有 1 个
            int[] rightPreorder = new int[rightSize];
            int[] rightInorder = new int[rightSize];
            for (int i = rootIndex + 1, j = 0; i < preorder.length; i++, j++) {
                // 得到右子树的前序遍历 从 preorder 第 rootIndex + 1 元素开始，直至结束
                // 如果右子树个数只有 1 个，取 1 个元素放入，实际是根节点
                rightPreorder[j] = preorder[i];
            }
            for (int i = rootIndex + 1, j = 0; i < inorder.length; i++, j++) {
                // 得到右子树的中序遍历 从 inorder 第 rootIndex + 1 元素开始，直至结束
                // 如果右子树个数只有 1 个，取 1 个元素放入，实际是根节点
                rightInorder[j] = inorder[i];
            }
            root.right = buildTree(rightPreorder, rightInorder);
        }
        return root;
    }


    public static void main(String[] args) {
        Integer[] arr = {3,9,20,6,8,15,7};
        TreeNode root = BinaryTreeUtil.arrToTree(arr);
        BinaryTreePrintUtil.print(root);
//        System.out.println(new TraverseBinaryTree().preOrderReturnResult(root));
//        System.out.println(new TraverseBinaryTree().inOrderReturnResult(root));
//        int[] preorder = {3, 9, 6, 8, 20, 15, 7};
//        int[] inorder = {6, 9, 8, 3, 15, 20, 7};
//        BinaryTreePrintUtil.print(new BinaryTree105().buildTree(preorder, inorder));

//        int[] preorder = {3, 9, 6, 8, 20};
//        int[] inorder = {6, 9, 8, 3, 20};
//        BinaryTreePrintUtil.print(new BinaryTree105().buildTree(preorder, inorder));

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        BinaryTreePrintUtil.print(new BinaryTree105().buildTree(preorder, inorder));
    }
}
