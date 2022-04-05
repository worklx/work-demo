package com.work.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

// 二叉树的所有路径
//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//
// 叶子节点 是指没有子节点的节点。
//
// 示例 1：
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
//
//
// 示例 2：
//输入：root = [1]
//输出：["1"]
//
// 提示：
// 树中节点的数目在范围 [1, 100] 内
// -100 <= Node.val <= 100
//


public class BinaryTree257 {

    /**
     * 需要返回结果，递归需要辅助函数，辅助数据结构存放遍历结果
     *
     * @param root
     * @return
     */
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> result = new ArrayList<>();
//        binaryTreePaths(root, "", result);
//        return result;
//    }
//
//    /**
//     * 当遍历到某个节点时，此节点需要做什么？
//     * 1.若节点为空需要怎么处理？
//     * 2.若节点不为空，但左子树和右子树都为空需要怎么处理？
//     * 3.若左子树不为空，左子树需要怎么处理？
//     * 4.若右子树不为空，右子树需要怎么处理？
//     *
//     * @param node
//     * @param path
//     * @param result
//     * @return
//     */
//    private List<String> binaryTreePaths(TreeNode node, String path, List<String> result) {
//        // 节点需要做什么？
//        if (node == null) {
//            return result;
//        }
//        path = path + node.val;
//        if (node.left == null && node.right == null) {
//            result.add(path);
//            return result;
//        }
//        path = path + "->";
//        binaryTreePaths(node.left, path, result);
//        binaryTreePaths(node.right, path, result);
//        return result;
//    }

    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePaths(root, "");
        return result;
    }

    private void binaryTreePaths(TreeNode node, String path) {
        // 节点需要做什么？
        if (node == null) {
            return;
        }
        path = path + node.val;
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }
        path = path + "->";
        binaryTreePaths(node.left, path);
        binaryTreePaths(node.right, path);
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,null,5};
        TreeNode root = BinaryTreeUtil.arrToTree(arr);
        BinaryTreePrintUtil.print(root);
        System.out.println(new BinaryTree257().binaryTreePaths(root));
    }
}

/*
      1
    /   \
  2       3
   \
    5


 */