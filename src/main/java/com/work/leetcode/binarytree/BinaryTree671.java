package com.work.leetcode.binarytree;

// 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
// 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
// 更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。
// 给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。
// 如果第二小的值不存在的话，输出 -1 。
//
// 示例 1：
// 输入：root = [2,2,5,null,null,5,7]
// 输出：5
// 解释：最小的值是 2 ，第二小的值是 5 。
//
// 示例 2：
// 输入：root = [2,2,2]
// 输出：-1
// 解释：最小的值是 2, 但是不存在第二小的值。


public class BinaryTree671 {

    /**
     * 非空特殊二叉树，根节点不会为空
     * 若根节点无子节点，不存在第二小的值
     * 若根节点有子节点，则必然有两个子节点
     * 1）若左子节点和右子节点均无子节点，那么左子节点和右子节点种较大值且比根节点值大即为第二小值
     * 2）若左子节点无字节点，右子节点有子节点，且必然有两个子节点，但右子节点必然是较小值
     *
     * @param root
     * @return
     */
    int minVal = -1;
    int rootValue;
    public int findSecondMinimumValue(TreeNode root) {
        rootValue = root.val;
        order(root);
        return minVal;
    }

    private void order(TreeNode node) {
        if (node == null) {
            return;
        }
        if (minVal != -1 && node.val > minVal) {
            return;
        }
        if (node.val > rootValue) {
            minVal = node.val;
        }
        order(node.left);
        order(node.right);
    }

    public static void main(String[] args) {
        Integer[] arr = {1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1};
        TreeNode root = BinaryTreeUtil.arrToTree(arr);
        BinaryTreePrintUtil.print(root);
        System.out.println(new BinaryTree671().findSecondMinimumValue(root));
    }
}
