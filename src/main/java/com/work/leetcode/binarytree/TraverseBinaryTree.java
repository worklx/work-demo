package com.work.leetcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树遍历
 *
 * 深度优先遍历：
 * 对每一个可能的分支路径深入到不能再深入为止，而且每个结点只能访问一次。
 * 要特别注意的是，二叉树的深度优先遍历又可以细分为先序遍历、中序遍历、后序遍历：
 * 先序遍历：对任一子树，先访问根，然后遍历其左子树，最后遍历其右子树。
 * 中序遍历：对任一子树，先遍历其左子树，然后访问根，最后遍历其右子树。
 * 后序遍历：对任一子树，先遍历其左子树，然后遍历其右子树，最后访问根。
 *
 * 广度优先遍历：
 * 又叫层次遍历，从上往下对每一层依次访问，在每一层中，从左往右（也可以从右往左）访问结点，访问完一层就进入下一层，直到没有结点可以访问为止。
 * @author chenlx2
 */
public class TraverseBinaryTree {

    /**
     * 深度优先-递归前序遍历：先根节点，然后左子树，最后右子树
     * @param node
     */
    public void preOrder(TreeNode node) {
        // 递的结束条件
        if (node == null) {
            // 终止时处理办法
            return;
        }
        // 当前节点需要做的事情
//        System.out.print(node.val + " ");
        nodeNeedTodo(node);
        // 让当前节点的左子节点重复当前节点
        preOrder(node.left);
        // 让当前节点的右子节点重复做当前节点
        preOrder(node.right);
    }

    /**
     * 深度优先-递归中序遍历：先左子树，然后根节点，最后右子树
     * @param node
     */
    public void inOrder(TreeNode node) {
        // 递的结束条件
        if (node == null) {
            // 终止时处理办法
            return;
        }
        // 让当前节点的左子节点重复当前节点
        inOrder(node.left);
        // 当前节点需要做的事情
//        System.out.print(node.val + " ");
        nodeNeedTodo(node);
        // 让当前节点的右子节点重复做当前节点
        inOrder(node.right);
    }

    /**
     * 深度优先-递归后序遍历：先左子树，然后右子树，最后根节点
     * @param node
     */
    public void postOrder(TreeNode node) {
        // 递的结束条件
        if (node == null) {
            // 终止时处理办法
            return;
        }
        // 让当前节点的左子节点重复当前节点
        postOrder(node.left);
        // 让当前节点的右子节点重复做当前节点
        postOrder(node.right);
        // 当前节点需要做的事情
//        System.out.print(node.val + " ");
        nodeNeedTodo(node);
    }

    /**
     * 节点需要做的
     * @param node
     */
    private void nodeNeedTodo(TreeNode node) {
        System.out.print(node.val + " ");
    }

    /**
     * 深度优先-递归前序遍历：先根节点，然后左子树，最后右子树
     * @param root
     */
    public ArrayList<Integer> preOrderReturnResult(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    /**
     * 深度优先-递归中序遍历：先左子树，然后根节点，最后右子树
     * @param root
     */
    public ArrayList<Integer> inOrderReturnResult(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    /**
     * 深度优先-递归后序遍历：先左子树，然后右子树，最后根节点
     * @param root
     */
    public ArrayList<Integer> postOrderReturnResult(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    /**
     * 深度优先-递归前序遍历：先根节点，然后左子树，最后右子树
     * @param node
     */
    public void preOrder(TreeNode node, ArrayList<Integer> result) {
        // 递的结束条件
        if (node == null) {
            // 终止时处理办法
            return;
        }
        // 当前节点需要做的事情
        nodeNeedTodo(node, result);
        // 让当前节点的左子节点重复当前节点
        preOrder(node.left, result);
        // 让当前节点的右子节点重复做当前节点
        preOrder(node.right, result);
    }

    /**
     * 深度优先-递归中序遍历：先左子树，然后根节点，最后右子树
     * @param node
     */
    public void inOrder(TreeNode node, ArrayList<Integer> result) {
        // 递的结束条件
        if (node == null) {
            // 终止时处理办法
            return;
        }
        // 让当前节点的左子节点重复当前节点
        inOrder(node.left, result);
        // 当前节点需要做的事情
        nodeNeedTodo(node, result);
        // 让当前节点的右子节点重复做当前节点
        inOrder(node.right, result);
    }

    /**
     * 深度优先-递归后序遍历：先左子树，然后右子树，最后根节点
     * @param node
     */
    public void postOrder(TreeNode node, ArrayList<Integer> result) {
        // 递的结束条件
        if (node == null) {
            // 终止时处理办法
            return;
        }
        // 让当前节点的左子节点重复当前节点
        postOrder(node.left, result);
        // 让当前节点的右子节点重复做当前节点
        postOrder(node.right, result);
        // 当前节点需要做的事情
        nodeNeedTodo(node, result);
    }

    /**
     * 节点需要做的
     * @param node
     */
    private void nodeNeedTodo(TreeNode node, ArrayList<Integer> result) {
        result.add(node.val);
    }

    /**
     * 深度优先-迭代遍历
     * 需要利用 Stack(栈) 的 LIFO(后进先出)的特性：
     * @param root
     */
    public ArrayList<Integer> deepOrder1(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 将 root 节点放入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            // 弹出栈顶元素
            TreeNode node = stack.pop();
            // 入栈顺序：先放左节点，后放右节点
            // 出栈顺序：先出右节点，后出左节点
            if (node.left != null) {
                // 放入弹出的栈顶元素的左子节点
                stack.push(node.left);
            }
            if (node.right != null) {
                // 放入弹出的栈顶元素的右子节点
                stack.push(node.right);
            }
            result.add(node.val);
        }
        return result;
    }

    /**
     * 深度优先-迭代遍历
     * 需要利用 Stack(栈) 的 LIFO(后进先出)的特性：
     * @param root
     */
    public ArrayList<Integer> deepOrder2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 将 root 节点放入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            // 弹出栈顶元素
            TreeNode node = stack.pop();
            // 入栈顺序：先放右节点，后放左节点
            // 出栈顺序：先出左节点，后出右节点
            if (node.right != null) {
                // 放入弹出的栈顶元素的右子节点
                stack.push(node.right);
            }
            if (node.left != null) {
                // 放入弹出的栈顶元素的左子节点
                stack.push(node.left);
            }
            result.add(node.val);
        }
        return result;
    }

    /**
     * 深度优先-迭代前序遍历：先根节点，然后左子树，最后右子树
     * 需要先放入 根节点
     * 然后不断的放入左子节点，直至左子末节点
     * 然后弹出栈顶的 左子末节点
     * 继续遍历栈顶节点的右子节点
     * @param root
     */
    public ArrayList<Integer> deepPreOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
//                nodeNeedTodo(cur);
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return result;
    }

    public ArrayList<Integer> deepInOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
//                nodeNeedTodo(cur);
                cur = cur.right;
            }
        }
        return result;
    }

    public ArrayList<Integer> deepPostOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode lastVisited = null;

        while (null != cur) {
            stack.push(cur);
            cur = cur.left;
        }

        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur.right == null || lastVisited == cur.right) {
//                nodeNeedTodo(cur);
                lastVisited = cur;
            } else {
                stack.push(cur);
                cur = cur.right;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
        return result;
    }

    /**
     * 广度优先-层序遍历
     * 需要利用 Queue(队列) 的 FIFO(先进先出)的特性：
     * 首先将 A 节点放入队列中，queue(A)
     * 将 A 节点弹出，同时将 A 的子节点 B、C 放入队列中，此时 B 在队列首，C 在队列尾，queue(B,C)
     * 将 B 节点弹出，同时将 B 的子节点 D、E 放入队列中，此时 C 在队列首，E 在队列尾，queue(C,D,E)
     * 将 C 节点弹出，同时将 C 的子节点 F、G 放入队列中，此时 D 在队列首，E 在队列尾，queue(D,E,F,G)
     * 将 D 节点弹出，同时将 D 的子节点 H、I 放入队列中，此时 E 在队列首，I 在队列尾，queue(E,F,G,H,I)
     * ........
     * 以此往下，最终遍历完成
     * @param root
     */
    public ArrayList<Integer> levelOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 将 root 节点放入队列
        queue.offer(root);
        while (!queue.isEmpty()) {
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
            // 当前节点需要做的事情
            result.add(node.val);
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7,8,9};
        TreeNode root = BinaryTreeUtil.arrToTree(arr);
        BinaryTreePrintUtil.print(root);
        System.out.print("深度优先-递归前序遍历：");
        new TraverseBinaryTree().preOrder(root);
        System.out.println();
        System.out.print("深度优先-递归中序遍历：");
        new TraverseBinaryTree().inOrder(root);
        System.out.println();
        System.out.print("深度优先-递归后序遍历：");
        new TraverseBinaryTree().postOrder(root);
        System.out.println();
        System.out.print("深度优先-递归前序遍历结果：" + new TraverseBinaryTree().preOrderReturnResult(root));
        System.out.println();
        System.out.print("深度优先-递归中序遍历结果：" + new TraverseBinaryTree().inOrderReturnResult(root));
        System.out.println();
        System.out.print("深度优先-递归后序遍历结果：" + new TraverseBinaryTree().postOrderReturnResult(root));
        System.out.println();
        System.out.print("深度优先-迭代遍历1结果：" + new TraverseBinaryTree().deepOrder1(root));
        System.out.println();
        System.out.print("深度优先-迭代遍历2结果：" + new TraverseBinaryTree().deepOrder2(root));
        System.out.println();
        System.out.print("广度优先-层序遍历结果：" + new TraverseBinaryTree().levelOrder(root));
        System.out.println();
    }
}
