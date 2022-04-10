package com.work.leetcode.binarytree;

// 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
// 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
// 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
// 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
//
// 示例 1：
// 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
// 输出：true
//
// 示例 2：
// 输入：root1 = [1,2,3], root2 = [1,3,2]
// 输出：false
//

import java.util.ArrayList;
import java.util.List;

public class BinaryTree872 {

    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtil.arrToTree(new Integer[]{3,5,1,6,2,9,8,null,null,7,4});
        TreeNode root2 = BinaryTreeUtil.arrToTree(new Integer[]{3,5,1,6,7,4,2,null,null,null,null,null,null,9,8});
        BinaryTreePrintUtil.print(root1);
        BinaryTreePrintUtil.print(root2);
        System.out.println(new BinaryTree872().leafSimilar(root1, root2));

//        TreeNode root1 = BinaryTreeUtil.arrToTree(new Integer[]{1,2,3});
//        TreeNode root2 = BinaryTreeUtil.arrToTree(new Integer[]{1,3,2});
//        BinaryTreePrintUtil.print(root1);
//        BinaryTreePrintUtil.print(root2);
//        System.out.println(new BinaryTree872().leafSimilar(root1, root2));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        order(root1, result1);
        order(root2, result2);
        if (result1.size() != result2.size()) {
            return false;
        }
        boolean isSimilar = true;
        for (int i = 0; i < result1.size(); i++) {
            if (result1.get(i).intValue() != result2.get(i).intValue()) {
                isSimilar = false;
                break;
            }
        }
        return isSimilar;
    }

    private void order(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        order(node.left, result);
        if (node.left == null && node.right == null) {
            result.add(node.val);
        }
        order(node.right, result);
    }
}

/*

            3
         /     \
      5           1
    /   \       /   \
  6       2   9       8
         / \
        7   4
            3
         /     \
      5           1
    /   \       /   \
  6       7   4       2
                     / \
                    9   8

 */
