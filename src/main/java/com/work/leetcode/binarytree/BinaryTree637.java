package com.work.leetcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 二叉树的层平均值
// 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10⁻⁵ 以内的答案可以被接受。
//
// 示例 1：
// 输入：root = [3,9,20,null,null,15,7]
// 输出：[3.00000,14.50000,11.00000]
// 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
// 因此返回 [3, 14.5, 11] 。
//
// 示例 2:
// 输入：root = [3,9,20,15,7]
// 输出：[3.00000,14.50000,11.00000]

public class BinaryTree637 {

    public List<Double> averageOfLevels(TreeNode root) {
        return levelOrder(root);
    }

    public ArrayList<Double> levelOrder(TreeNode root) {
        ArrayList<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 将 root 节点放入队列
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 弹出队首元素
                TreeNode node = queue.poll();
                if (node.left != null) {
                    // 放入弹出的队首元素的左子节点
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    // 放入弹出的队首元素的右子节点
                    queue.offer(node.right);
                }
                sum = sum + node.val;
            }
            result.add(sum/size);
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] arr = {3,9,20,15,7};
        TreeNode root = BinaryTreeUtil.arrToTree(arr);
        BinaryTreePrintUtil.print(root);
        System.out.println(new BinaryTree637().averageOfLevels(root));
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
 / \
15  7

 */
