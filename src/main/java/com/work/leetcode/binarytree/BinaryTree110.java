package com.work.leetcode.binarytree;

//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//
// 示例 1：
//输入：root = [3,9,20,null,null,15,7]
//输出：true
//
//
// 示例 2：
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
//
// 示例 3：
//输入：root = []
//输出：true
//
// 提示：
// 树中的节点数在范围 [0, 5000] 内
// -10⁴ <= Node.val <= 10⁴

public class BinaryTree110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
