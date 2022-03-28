package com.work.leetcode.binarytree;

/**
 * @author chenlx2
 */
public class BinaryTree114 {

    /**
     * 114. 将二叉树展开为列表
     * @param args
     */
    public static void main(String[] args) {
        Integer[] arr = {1,2,5,3,6,4,7};
        TreeNode root = BinaryTreeUtil.arrToTree(arr);
        flatten(root);
        BinaryTreePrintUtil.print(root);
    }

    public static void flatten(TreeNode node) {
        // 递的结束条件
        if (node == null) {
            // 终止时处理办法
            return;
        }
        // 先左子树拉平
        flatten(node.left);
        // 后右子树拉平
        flatten(node.right);
        // 最后根节点拉平
        nodeNeedTodo(node);
    }

    /**
     * 实现节点的拉平
     * 1.左子树变成右子树
     * 2.原右子树变成原左子树的右子树最右末端节点的右子树
     */
    private static void nodeNeedTodo(TreeNode node) {
        // 保存初始左子树
        TreeNode initLeft = node.left;
        // 保存初始右子树
        TreeNode initRight = node.right;

        // 移除左子树
        node.left = null;
        // 将原左子树变成右子树
        node.right = initLeft;

        // 遍历获取节点新右子树最末端的右子节点
        TreeNode temp = node;
        while (temp.right != null) {
            temp = temp.right;
        }
        // 初始右子树变成新右子树的右子树
        temp.right = initRight;
    }
}

/*
1,2,5,3,4,6,7
1,2,5,9,3,9,6,9,9,9,4,9,7

    1
  2   5
3  4 6 7
                 让左子节点拉平   让右子节点拉平
    1
  2   5
   3    6
    4    7
                 让根节点拉平
    1
  2
   3
    4
     5
      6
       7
1
 2
  3
   4
    5
     6
      7





 */
