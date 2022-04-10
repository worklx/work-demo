package com.work.leetcode.binarytree;

// 合并二叉树
// 给你两棵二叉树： root1 和 root2 。
// 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。
// 合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
// 返回合并后的二叉树。
// 注意: 合并过程必须从两个树的根节点开始。
//
// 示例 1：
//输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
//输出：[3,4,5,5,4,null,7]
//
// 示例 2：
//输入：root1 = [1], root2 = [1,2]
//输出：[2,2]

public class BinaryTree617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) {
            return root2;
        }
        if(root2 == null) {
            return root1;
        }
        // 根节点值
        int rootVal = root1.val + root2.val;
        // 构造根节点
        TreeNode root = new TreeNode(rootVal);
        // 构造左子树
        root.left = mergeTrees(root1.left, root2.left);
        // 构造右子树
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2, TreeNode root3) {
        if (root2 == null && root3 == null) {
            return root1;
        }
        if (root1 == null && root3 == null) {
            return root2;
        }
        if (root1 == null && root2 == null) {
            return root3;
        }
        if (root1 != null && root2 != null && root3 == null) {
            TreeNode merged = new TreeNode(root1.val + root2.val);
            merged.left = mergeTrees(root1.left, root2.left, null);
            merged.right = mergeTrees(root1.right, root2.right, null);
            return merged;
        }
        if (root1 != null && root2 == null && root3 != null) {
            TreeNode merged = new TreeNode(root1.val + root3.val);
            merged.left = mergeTrees(root1.left, null, root3.left);
            merged.right = mergeTrees(root1.right, null, root3.right);
            return merged;
        }
        if (root1 == null && root2 != null && root3 != null) {
            TreeNode merged = new TreeNode(root2.val + root3.val);
            merged.left = mergeTrees(null, root2.left, root3.left);
            merged.right = mergeTrees(null, root2.right, root3.right);
            return merged;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val + root3.val);
        merged.left = mergeTrees(root1.left, root2.left, root3.left);
        merged.right = mergeTrees(root1.right, root2.right, root3.right);
        return merged;
    }

    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtil.arrToTree(new Integer[]{1,3,2,5});
        TreeNode root2 = BinaryTreeUtil.arrToTree(new Integer[]{2,1,3,null,4,null,7});
        TreeNode root3 = BinaryTreeUtil.arrToTree(new Integer[]{3,4,5,5,4,null,7});
        BinaryTreePrintUtil.print(root1);
        System.out.println();
        BinaryTreePrintUtil.print(root2);
        System.out.println();
        BinaryTreePrintUtil.print(root3);
        System.out.println();
        BinaryTreePrintUtil.print(new BinaryTree617().mergeTrees(root1, root2));
        System.out.println();
        BinaryTreePrintUtil.print(new BinaryTree617().mergeTrees(root1, root2, root3));
    }
}
