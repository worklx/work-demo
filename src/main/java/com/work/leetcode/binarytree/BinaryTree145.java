package com.work.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。

 示例 1：
 输入：root = [1,null,2,3]
 输出：[3,2,1]

 示例 2：
 输入：root = []
 输出：[]

 示例 3：
 输入：root = [1]
 输出：[1]

 提示：
 树中节点的数目在范围 [0, 100] 内
 -100 <= Node.val <= 100

 进阶：递归算法很简单，你可以通过迭代算法完成吗？

 * @author chenlx2
 */
public class BinaryTree145 {

    public static void main(String[] args) {
        Integer[] arr = {1,null,2,3};
        TreeNode root = BinaryTreeUtil.arrToTree(arr);
        BinaryTreePrintUtil.print(root);
        System.out.println(new BinaryTree145().postorderTraversal(root));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    /**
     * 后序遍历：先左子树，然后右子树，最后根节点
     * @param node
     */
    public void postOrder(TreeNode node, List<Integer> result) {
        // 递的结束条件
        if (node == null) {
            // 终止时处理办法
            return;
        }
        // 让当前节点的左子节点重复当前节点
        postOrder(node.left, result);
        // 让当前节点的右子节点重复做当前节点
        postOrder(node.right, result);
        // 当前节点需要做的事情
        nodeNeedTodo(node, result);
    }

    /**
     * 节点需要做的
     * @param node
     */
    private void nodeNeedTodo(TreeNode node, List<Integer> result) {
        result.add(node.val);
    }

    /**
     * 后序遍历：先左子树，然后右子树，最后根节点
     * @param node
     */
    public void postOrder(TreeNode node) {
        // 递的结束条件
        if (node == null) {
            // 终止时处理办法
            return;
        }
        // 让当前节点的左子节点重复当前节点
        postOrder(node.left);
        // 让当前节点的右子节点重复做当前节点
        postOrder(node.right);
        // 当前节点需要做的事情
        nodeNeedTodo(node);
    }

    /**
     * 节点需要做的
     * @param node
     */
    private void nodeNeedTodo(TreeNode node) {
        System.out.print(node.val + " ");
    }
}
