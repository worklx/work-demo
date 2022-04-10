package com.work.leetcode.binarytree;

// 单值二叉树
// 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
// 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
//
// 示例 1：
// 输入：[1,1,1,1,1,null,1]
// 输出：true
//
// 示例 2：
// 输入：[2,2,2,5,2]
// 输出：false
//
// 提示：
// 给定树的节点数范围是 [1, 100]。
// 每个节点的值都是整数，范围为 [0, 99] 。

public class BinaryTree965 {

    boolean isUnival = true;
    int val;
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        val = root.val;
        order(root);
        return isUnival;
    }

    private void order(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val != val) {
            isUnival = false;
        }
        order(node.left);
        order(node.right);
    }

    public static void main(String[] args) {
        Integer[] arr = {2,2,2,5,2};
        TreeNode root = BinaryTreeUtil.arrToTree(arr);
        BinaryTreePrintUtil.print(root);
        System.out.println(new BinaryTree965().isUnivalTree(root));
    }

}
