package com.work.leetcode.binarytree;

// 二叉树的直径
//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//
// 示例 :
//给定二叉树
//
//           1
//         / \
//        2   3
//       / \
//      4   5
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。


public class BinaryTree543 {
    /**
     * 二叉树的直径
     * 需要分别计算每棵子树的二叉树的直径，然后比较大小，取最大值
     * 每棵子树的二叉树的直径可以拆分为：左子树的最长边 + 右子树的最长边 + 2(根节点到左子树根节点 + 根节点到右子树根节点)
     * 而边又等于深度 - 1 ，深度 = 根节点到最远叶子节点的最长路径上的节点数
     * 比如根节点2的左子树 4 的深度是 3，边为 2 ，右子树 0 的深度是 3，边为 2，则根节点 2 的直径 = 2 + 2 + 2 = 3 + 3
     * 即二叉树的直径 = 左子树深度 + 右子树深度
     *
     * @param root
     * @return
     */
    int maxLength;
    public int diameterOfBinaryTree(TreeNode root) {
        maxLength = 0;
        dept(root);
        return maxLength;
    }

    /**
     * 计算树的深度
     * @param root
     * @return
     */
    private int dept(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int deptLeft = dept(root.left);
        int deptRight = dept(root.right);
        maxLength = Math.max(maxLength, deptLeft + deptRight);
        return Math.max(deptLeft, deptRight) + 1;
    }

    public static void main(String[] args) {
        Integer[] arr = {4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2};
        TreeNode root = BinaryTreeUtil.arrToTree(arr);
        BinaryTreePrintUtil.print(root);
        System.out.println(new BinaryTree543().diameterOfBinaryTree(root));
    }
}

/*
                        9
                    /       \
                   3            2
                             /     \
                          4           0
                        /           /
                      5           8
                     /           /
                    7           1

              4
           /     \
        -7         -3
                /       \
             -9          -3
           /    \        /
        9        -7    -4
      /         /   \
    6          -6    -6
  /   \       /      /
0       6    5      9
 \     /           /
  -1  -4          -2


 */
