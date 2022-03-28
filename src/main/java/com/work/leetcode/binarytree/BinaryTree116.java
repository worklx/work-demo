package com.work.leetcode.binarytree;

/**
 * @author chenlx2
 */
public class BinaryTree116 {

    /**
     * 116.完美二叉树，填充每个节点的下一个右侧指针
     * 让每一层相邻的节点两两相连
     * @param args
     */
    public static void main(String[] args) {
        Integer[] arr = {4,2,7,1,3,6,9};
        TreeNode root = BinaryTreeUtil.arrToTree(arr);
        root = connectNode(root);
        BinaryTreeUtil.levelOrderPrintNext(root);
    }

    public static TreeNode connectNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        connectNode(node.left, node.right);
        return node;
    }

    private static void connectNode(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        // 需要节点做的事情
        nodeNeedTodo(node1, node2);
        // 左子树的左子节点指向右子节点
        connectNode(node1.left, node1.right);
        // 右子树的左子节点指向右子节点
        connectNode(node2.left, node2.right);
        // 左子树的右子节点指向右子树的左子节点
        connectNode(node1.right, node2.left);
    }

    /**
     * 让 node1 next 指向 node2.left
     */
    private static void nodeNeedTodo(TreeNode node1, TreeNode node2) {
        node1.next = node2;
    }

    /*
     * 若只通过一个节点，只能解决节点的左子节点指向右子节点（即必须是同父节点内）
     * 左子树最右侧节点和右子树最左节点没有办法实现连接
     */
    public static TreeNode connectNode2(TreeNode node) {
        // 递的结束条件
        if (node == null || node.left == null) {
            // 终止时处理办法
            return null;
        }
        // 当前节点需要做的事情
        nodeNeedTodo(node);
        // 让当前节点的左子节点重复当前节点
        connectNode2(node.left);
        // 让当前节点的右子节点重复做当前节点
        connectNode2(node.right);
        return node;
    }

    /**
     * 让左子节点指向右子节点
     */
    private static void nodeNeedTodo(TreeNode node) {
        System.out.println(node.val);
        node.left.next = node.right;
    }
}
/*
4,2,7,1,3,6,9

      4
  2  -->  7
1-->3   6-->9


 */