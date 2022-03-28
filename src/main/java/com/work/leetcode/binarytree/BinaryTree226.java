package com.work.leetcode.binarytree;

/**
 * @author chenlx2
 */
public class BinaryTree226 {

    /**
     * 226. 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     * invertTree
     * @param args
     */
    public static void main(String[] args) {
        Integer[] arr = {4,2,7,1,3,6,9};
        TreeNode root = BinaryTreeUtil.arrToTree(arr);
//        root = preOrder(root); // 前序遍历符合
        root = inOrder(root); // 中序遍历不符合 为什么不符合？
//        root = postOrder(root); // 后序遍历符合
        BinaryTreePrintUtil.print(root);
        // 4,7,2,9,6,3,1

        // 前序遍历 先操作根节点，然后操作左子树，最后操作右子树
        // 先操作根节点，把左子树和右子树翻转
        // 然后操作左子树，此时左子树即最初的右子树，把左子树完成翻转
        // 最后操作右子树，此时右子树即最初的左子树，把右子树完成翻转

        // 后序遍历 先操作左子树，然后操作右子树，最后操作根节点
        // 先操作左子树，把左子树完成翻转
        // 然后操作右子树，把右子树完成翻转
        // 最后操作根节点，把左子树和右子树翻转

        // 中序遍历，先操作左子树，然后操作根节点，最后操作右子树
        // 先操作左子树，把左子树完成翻转
        // 然后操作根节点，把左子树和右子树翻转
        // 最后操作右子树，此时的右子树即完成翻转后的左子树，
        // 再翻转右子树即把完成翻转后的左子树再次翻转，恢复成了初始的左子树
        // 所以中序遍历，实际上只是完了根节点的左子树和右子树翻转
    }

    /**
     * 前序遍历：先根节点，然后左子树，最后右子树
     * @param node
     */
    public static TreeNode preOrder(TreeNode node) {
        // 递的结束条件
        if (node == null) {
            // 终止时处理办法
            return null;
        }
        // 当前节点需要做的事情
        nodeNeedTodo(node);
        // 让当前节点的左子节点重复当前节点
        preOrder(node.left);
        // 让当前节点的右子节点重复做当前节点
        preOrder(node.right);
        return node;
    }

    /**
     * 中序遍历：先左子树，然后根节点，最后右子树
     * @param node
     */
    public static TreeNode inOrder(TreeNode node) {
        // 递的结束条件
        if (node == null) {
            // 终止时处理办法
            return null;
        }
        // 让当前节点的左子节点重复当前节点
        inOrder(node.left);
        // 当前节点需要做的事情
        nodeNeedTodo(node);
        // 让当前节点的右子节点重复做当前节点
        inOrder(node.right);
        return node;
    }

    /**
     * 后序遍历：先左子树，然后右子树，最后根节点
     * @param node
     */
    public static TreeNode postOrder(TreeNode node) {
        // 递的结束条件
        if (node == null) {
            // 终止时处理办法
            return null;
        }
        // 让当前节点的左子节点重复当前节点
        postOrder(node.left);
        // 让当前节点的右子节点重复做当前节点
        postOrder(node.right);
        // 当前节点需要做的事情
        nodeNeedTodo(node);
        return node;
    }

    /**
     * 实现左子节点和右子节点对换
     */
    private static void nodeNeedTodo(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
