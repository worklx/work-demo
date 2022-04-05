package com.work.leetcode.binarytree;

//给定二叉树的根节点 root ，返回所有左叶子之和。
//
// 示例 1：
//输入: root = [3,9,20,null,null,15,7]
//输出: 24
//解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//
// 示例 2:
//输入: root = [1]
//输出: 0
//
// 提示:
// 节点数在 [1, 1000] 范围内
// -1000 <= Node.val <= 1000


public class BinaryTree404 {

    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, 0);
    }

    /**
     * 当遍历到某个节点时，此节点需要做什么？
     * 1.若节点为空，结束遍历
     * 2.若节点不为空
     * 2.1）若节点的左子节点不为空，且左子节点是叶子节点，则该左子节点是左叶子节点
     * 2.2）若节点的左子节点不为空，但左子节点不是叶子节点，则继续遍历左子节点
     * 2.3）若节点的右子节点不为空，且右子节点是叶子节点，则结束遍历
     * 2.4）若节点的右子节点不为空，但右子节点不是叶子节点，则继续遍历右子节点
     *
     * @param root
     * @param sum
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        if (root.left == null && root.right == null) {
            return sum;
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                // 左子节点是叶子节点
                sum = sum + root.left.val;
            } else {
                // 左子节点不是叶子节点，继续遍历左子节点
                sum = sumOfLeftLeaves(root.left, sum);
            }
        }
        if (root.right != null) {
            if (root.right.left == null && root.right.right == null) {
                // 右子节点是叶子节点，结束遍历
                return sum;
            } else {
                // 右子节点不是叶子节点，继续遍历右子节点
               sum = sumOfLeftLeaves(root.right, sum);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Integer[] arr = {-9,-3,2,null,4,4,0,-6,null,-5};
        TreeNode root = BinaryTreeUtil.arrToTree(arr);
        BinaryTreePrintUtil.print(root);
        System.out.println(new BinaryTree404().sumOfLeftLeaves(root));
    }
}

/*

      3
    /   \
  9       20
         / \
        15  7

      3
    /   \
  9       20
 / \     / \
13  23  15  7

 */