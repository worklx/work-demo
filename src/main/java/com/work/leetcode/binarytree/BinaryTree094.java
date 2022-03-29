package com.work.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
/**
给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 

示例 1： 
输入：root = [1,null,2,3]
输出：[1,3,2]

示例 2：
输入：root = []
输出：[]

示例 3：
输入：root = [1]
输出：[1]

提示：
树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

 * @author chenlx2
 */
public class BinaryTree094 {

    public static void main(String[] args) {
        Integer[] arr = {1,null,2,3};
        TreeNode root = BinaryTreeUtil.arrToTree(arr);
        BinaryTreePrintUtil.print(root);
        System.out.println(new BinaryTree094().inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    /**
     * 中序遍历：先左子树，然后根节点，最后右子树
     * @param node
     */
    private void inOrder(TreeNode node, List<Integer> result) {
        // 递的结束条件
        if (node == null) {
            // 终止时处理办法
            return;
        }
        // 让当前节点的左子节点重复当前节点
        inOrder(node.left, result);
        // 当前节点需要做的事情
        nodeNeedTodo(node, result);
        // 让当前节点的右子节点重复做当前节点
        inOrder(node.right, result);
    }

    /**
     * 节点需要做的
     * @param node
     */
    private void nodeNeedTodo(TreeNode node, List<Integer> result) {
        result.add(node.val);
    }

    /**
     * 中序遍历：先左子树，然后根节点，最后右子树
     * @param node
     */
    public void inOrder(TreeNode node) {
        // 递的结束条件
        if (node == null) {
            // 终止时处理办法
            return;
        }
        // 让当前节点的左子节点重复当前节点
        inOrder(node.left);
        // 当前节点需要做的事情
        nodeNeedTodo(node);
        // 让当前节点的右子节点重复做当前节点
        inOrder(node.right);
    }

    /**
     * 节点需要做的
     * @param node
     */
    private void nodeNeedTodo(TreeNode node) {
        System.out.print(node.val + " ");
    }
}
