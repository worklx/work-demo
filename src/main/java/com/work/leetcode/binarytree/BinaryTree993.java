package com.work.leetcode.binarytree;

// 二叉树的堂兄弟节点
//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
// 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
// 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
//
// 示例 1：
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
//
//
// 示例 2：
//输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
//
//
// 示例 3：
//输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false
//
// 提示：
// 二叉树的节点数介于 2 到 100 之间。
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。


public class BinaryTree993 {
    int xNodeVal;
    int yNodeVal;
    int xNodeDept;
    int yNodeDept;
    TreeNode xNodeParent;
    TreeNode yNodeParent;

    /**
     * 1.需要分别计算两个节点的深度，和父节点
     * 1.1 若深度不同，则不是堂兄弟节点
     * 1.2.若深度相同，则判断父节点是否相同
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        this.xNodeVal = x;
        this.yNodeVal = y;
        dept(root, 0, null);
        return xNodeDept == yNodeDept && xNodeParent != yNodeParent;
    }

    /**
     * 计算节点的深度
     *
     * @param root
     * @return
     */
    private void dept(TreeNode root, int dept, TreeNode lastNode) {
        if (root == null) {
            return;
        }
        if (root.val == xNodeVal) {
            xNodeDept = dept;
            xNodeParent = lastNode;
        }
        if (root.val == yNodeVal) {
            yNodeDept = dept;
            yNodeParent = lastNode;
        }
        dept(root.left, dept + 1, root);
        dept(root.right, dept + 1, root);
    }

    /**
     * 计算节点的深度
     *
     * @param node
     * @return
     */
    public void nodeDept(TreeNode node, int dept) {
        if (node == null) {
            return;
        }
        if (node.val == xNodeVal) {
            xNodeDept = dept;
        }
        if (node.val == yNodeVal) {
            yNodeDept = dept;
        }
        nodeDept(node.left, dept + 1);
        nodeDept(node.right, dept + 1);
    }

    /**
     * 目标节点的深度
     *
     * @param node
     * @return
     */
    int target;
    int targetDept = -1;
    public int targetNodeDept(TreeNode root, int target) {
        this.target = target;
        nodeDept1(root, 0);
        return targetDept;
    }

    public void nodeDept1(TreeNode node, int dept) {
        if (node == null) {
            return;
        }
        if (node.val == target) {
            targetDept = dept + 1;
        }
        nodeDept1(node.left, dept + 1);
        nodeDept1(node.right, dept + 1);
    }

    /**
     * 二叉树的深度
     * @param root
     * @return
     */
    public int treeDept(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(treeDept(root.left), treeDept(root.right)) + 1;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4};
        TreeNode root = BinaryTreeUtil.arrToTree(arr);
        BinaryTreePrintUtil.print(root);
        System.out.println(new BinaryTree993().treeDept(root));
        System.out.println(new BinaryTree993().targetNodeDept(root, 5));
    }
}

/*

      1
    /   \
  2       3
 /
4


      1
    /   \
  2       3
   \       \
    4       5

      1
    /   \
  2       3
   \
    4

 */
