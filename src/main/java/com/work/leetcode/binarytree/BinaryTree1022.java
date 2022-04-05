package com.work.leetcode.binarytree;

//从根到叶的二进制数之和
//给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
// 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
// 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
// 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
//
// 示例 1：
//输入：root = [1,0,1,0,1,0,1]
//输出：22
//解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
//
// 示例 2：
//输入：root = [0]
//输出：0
//
// 提示：
// 树中的节点数在 [1, 1000] 范围内
// Node.val 仅为 0 或 1


import java.util.ArrayList;
import java.util.List;

public class BinaryTree1022 {

//    private List<String> binaryTreePaths(TreeNode node, String path, List<String> result) {
//        if (node == null) {
//            return result;
//        }
//        path = path + node.val;
//        if (node.left == null && node.right == null) {
//            result.add(path);
//            return result;
//        }
//        binaryTreePaths(node.left, path, result);
//        binaryTreePaths(node.right, path, result);
//        return result;
//    }
//
//    public int sumRootToLeaf(TreeNode root) {
//        List<String> result = new ArrayList<>();
//        binaryTreePaths(root, "", result);
//        System.out.println(result);
//        int sum = 0;
//        for (String value: result) {
//            sum = sum + Integer.valueOf(value, 2);
//        }
//        return sum;
//    }

    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        binaryTreePaths(root, "");
        return sum;
    }

    private void binaryTreePaths(TreeNode node, String path) {
        if (node == null) {
            return;
        }
        path = path + node.val;
        if (node.left == null && node.right == null) {
            sum = sum + Integer.valueOf(path, 2);
            return;
        }
        binaryTreePaths(node.left, path);
        binaryTreePaths(node.right, path);
    }

    public static void main(String[] args) {
        Integer[] arr = {1,0,1,0,1,0,1};
        TreeNode root = BinaryTreeUtil.arrToTree(arr);
        BinaryTreePrintUtil.print(root);
        System.out.println(new BinaryTree1022().sumRootToLeaf(root));
    }
}

/*
      1
    /   \
  0       1
 / \     / \
0   1   0   1

 */