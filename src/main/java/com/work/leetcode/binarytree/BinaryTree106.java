package com.work.leetcode.binarytree;

//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。
//
// 示例 1:
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
//
// 示例 2:
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
//
// 提示:
// 1 <= inorder.length <= 3000
// postorder.length == inorder.length
// -3000 <= inorder[i], postorder[i] <= 3000
// inorder 和 postorder 都由 不同 的值组成
// postorder 中每一个值都在 inorder 中
// inorder 保证是树的中序遍历
// postorder 保证是树的后序遍历


import java.util.HashMap;

public class BinaryTree106 {
    /**
     先序遍历：对任一子树，先访问根，然后遍历其左子树，最后遍历其右子树。
     中序遍历：对任一子树，先遍历其左子树，然后访问根，最后遍历其右子树。
     后序遍历：对任一子树，先遍历其左子树，然后遍历其右子树，最后访问根。

     若知道后序遍历结果，那么最后一个元素即是根节点
     若知道根节点和中序遍历结果，那么可以用根节点将中序遍历结果进行拆分

            3
         /    \
       9       20
      / \     / \
     6   8   15  7
     inorder = [6, 9, 8, 3, 15, 20, 7]
     postorder = [6, 8, 9, 15, 7, 20, 3]

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> valueIndexMap = new HashMap();
        for(int i = 0; i < inorder.length; i++) {
            valueIndexMap.put(inorder[i], i);
        }
        return buildTree(inorder, postorder,
                0, inorder.length - 1,
                0, postorder.length - 1,
                valueIndexMap);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder,
                              int inLeftIndex, int inRightIndex,
                              int postLeftIndex, int postRightIndex,
                              HashMap<Integer, Integer> valueIndexMap) {
        if (inLeftIndex > inRightIndex) {
            return null;
        }
        // 找到根节点的值
        int rootValue = postorder[postRightIndex];
        // 找到根节点的索引
        int rootIndex = valueIndexMap.get(rootValue);
        // 左子树节点数量
        int leftSize = rootIndex - inLeftIndex;
        // 构建根节点
        TreeNode root = new TreeNode(rootValue);
        // 左子树中序遍历序列起始索引
        int leftNextInLeftIndex = inLeftIndex;
        // 左子树中序遍历序列结束索引
        int leftNextInRightIndex = inLeftIndex + leftSize - 1;
        // 左子树后序遍历序列起始索引
        int leftNextPostLeftIndex = postLeftIndex;
        // 左子树后序遍历序列结束索引
        int leftNextPostRightIndex = postLeftIndex + leftSize - 1;
        // 构建左子树
        root.left = buildTree(inorder, postorder,
                leftNextInLeftIndex, leftNextInRightIndex,
                leftNextPostLeftIndex, leftNextPostRightIndex,
                valueIndexMap);
        // 右子树中序遍历序列起始索引
        int rightNextInLeftIndex = rootIndex + 1;
        // 右子树中序遍历序列结束索引
        int rightNextInRightIndex = inRightIndex;
        // 右子树后序遍历序列起始索引
        int rightNextPostLeftIndex = postLeftIndex + leftSize;
        // 右子树后序遍历序列结束索引
        int rightNextPostRightIndex = postRightIndex - 1;
        // 构建右子树
        root.right = buildTree(inorder, postorder,
                rightNextInLeftIndex, rightNextInRightIndex,
                rightNextPostLeftIndex, rightNextPostRightIndex,
                valueIndexMap);
        return root;
    }

}
