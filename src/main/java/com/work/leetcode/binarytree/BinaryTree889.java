package com.work.leetcode.binarytree;

//给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵
//树的后序遍历，重构并返回二叉树。
//
// 如果存在多个答案，您可以返回其中 任何 一个。
//
// 示例 1：
//输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
//
// 示例 2:
//输入: preorder = [1], postorder = [1]
//输出: [1]
//
// 提示：
// 1 <= preorder.length <= 30
// 1 <= preorder[i] <= preorder.length
// preorder 中所有值都 不同
// postorder.length == preorder.length
// 1 <= postorder[i] <= postorder.length
// postorder 中所有值都 不同
// 保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历


public class BinaryTree889 {

    /*
     * 先序遍历：对任一子树，先访问根，然后遍历其左子树，最后遍历其右子树。
     * 中序遍历：对任一子树，先遍历其左子树，然后访问根，最后遍历其右子树。
     * 后序遍历：对任一子树，先遍历其左子树，然后遍历其右子树，最后访问根。
     *
              1
            /   \
          2       3
         / \     / \
        4   5   6   7
      前序：[1, 2, 4, 5, 3, 6, 7]
      后序：[4, 5, 2, 6, 7, 3, 1]
     *
     * 前序遍历序列：[根节点，[左子树]，[右子树]]
     * 后序遍历序列：[[左子树]，[右子树]，根节点]
     *
     */

    public TreeNode constructFromPrePost(
            int[] preorder, int[] postorder,
            int preStart, int preEnd,
            int postStart, int postEnd) {
        // 根节点值
        int rootValue = preorder[preStart];
        // 根节点索引
        int rootIndex = preStart;
        // 计算左子树 leftSize
        int leftSize = 0;
        for (int i = postStart; i < postEnd; i++) {
            if (postorder[i] == preorder[rootIndex + 1]) {
                leftSize = i - postStart + 1;
            }
        }
        // 构建根节点
        TreeNode root = new TreeNode(rootValue);
        // 左子树 preStart
        int leftPreStart = rootIndex + 1;
        // 左子树 preEnd
        int leftPreEnd = leftPreStart + leftSize - 1;
        // 左子树 postStart
        int leftPostStart = postStart;
        // 左子树 postEnd
        int leftPostEnd = leftPostStart + leftSize - 1;
        // 构建左子树
        root.left = constructFromPrePost(preorder, postorder, leftPreStart, leftPreEnd, leftPostStart, leftPostEnd);
        // 右子树 preStart
        int rightPreStart = preStart + leftSize + 1;
        // 右子树 preEnd
        int rightPreEnd = preEnd;
        // 右子树 postStart
        int rightPostStart = postStart + leftSize;
        // 右子树 postEnd
        int rightPostEnd = postEnd - 1;
        // 构建右子树
        root.right = constructFromPrePost(preorder, postorder, rightPreStart, rightPreEnd, rightPostStart, rightPostEnd);
        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructFromPrePost(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7};
        TreeNode root = BinaryTreeUtil.arrToTree(arr);
        BinaryTreePrintUtil.print(root);
        System.out.println(new TraverseBinaryTree().preOrderReturnResult(root));
        System.out.println(new TraverseBinaryTree().postOrderReturnResult(root));
    }
}