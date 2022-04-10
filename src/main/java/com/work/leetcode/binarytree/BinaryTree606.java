package com.work.leetcode.binarytree;

// 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
// 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
//
// 示例 1:
// 输入: 二叉树: [1,2,3,4]
//       1
//     /   \
//    2     3
//   /
//  4
//
// 输出: "1(2(4))(3)"
// 解释: 原本将是“1(2(4)())(3())”，
// 在你省略所有不必要的空括号对之后，
// 它将是“1(2(4))(3)”。
//
// 示例 2:
// 输入: 二叉树: [1,2,3,null,4]
//       1
//     /   \
//    2     3
//     \
//      4
//
// 输出: "1(2()(4))(3)"
// 解释: 和第一个示例相似，
// 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。


public class BinaryTree606 {

    String result = "";
    public String tree2str(TreeNode root) {
        preOrder(root);
        return result;
    }

    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        result += node.val;
        if (node.left == null && node.right == null) {
           return;
        }
        if (node.right == null) {
            // 遍历左子树前加左括号
            result += "(";
            preOrder(node.left);
            // 遍历左子树后加右括号
            result += ")";
            preOrder(node.right);
        } else {
            // 遍历左子树前加左括号
            result += "(";
            preOrder(node.left);
            // 遍历左子树后加右括号
            result += ")";
            // 遍历右子树前加左括号
            result += "(";
            preOrder(node.right);
            // 遍历右子树后加右括号
            result += ")";
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,null,4};
        TreeNode root = BinaryTreeUtil.arrToTree(arr);
        BinaryTreePrintUtil.print(root);
        System.out.println(new BinaryTree606().tree2str(root));
    }
}
