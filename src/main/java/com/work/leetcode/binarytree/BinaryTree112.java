package com.work.leetcode.binarytree;

//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
// targetSum 。如果存在，返回 true ；否则，返回 false 。
//
// 叶子节点 是指没有子节点的节点。
//
// 示例 1：
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
//解释：等于目标和的根节点到叶节点路径如上图所示。
//
//
// 示例 2：
//输入：root = [1,2,3], targetSum = 5
//输出：false
//解释：树中存在两条根节点到叶子节点的路径：
//(1 --> 2): 和为 3
//(1 --> 3): 和为 4
//不存在 sum = 5 的根节点到叶子节点的路径。
//
// 示例 3：
//输入：root = [], targetSum = 0
//输出：false
//解释：由于树是空的，所以不存在根节点到叶子节点的路径。
//
// 提示：
// 树中节点的数目在范围 [0, 5000] 内
// -1000 <= Node.val <= 1000
// -1000 <= targetSum <= 1000


public class BinaryTree112 {

    /**
     * 当遍历到某个节点时 ，此节点需要做什么？
     * 1.首先判断当前节点是空节点，若是空节点， 则不存在路径；
     * 2.其次判断节点是否有子节点，若没有子节点，则判断节点值是否等于目标值；
     * 3.若存在左子树，则继续遍历左子树，但是遍历左子树的 targetSum 应该是多少？targetSum = targetSum - root.val；
     * 4.若存在右子树，则继续遍历右子树，同理遍历右子树的 targetSum 也是 targetSum - root.val；
     * 5.只要左子树或右子树满足即可
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        Integer[] arr = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = BinaryTreeUtil.arrToTree(arr);
        BinaryTreePrintUtil.print(root);
    }
}

/*

                5
             /     \
          4           8
        /           /   \
      11          13      4
     / \                   \
    7   2                   1

       1
      / \
     2   3

 */