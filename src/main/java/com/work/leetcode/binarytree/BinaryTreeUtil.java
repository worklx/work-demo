package com.work.leetcode.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树遍历
 * @author chenlx2
 */
public class BinaryTreeUtil {

    /**
     * 层序遍历打印
     * @param node
     */
    public static void levelOrderPrintNext(TreeNode node) {
        if (node == null) {
            return;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(node);
        while (!linkedList.isEmpty()) {
            TreeNode temp = linkedList.remove();
            if (temp.next == null) {
                System.out.print(temp.val + "-->" + temp.next + " ");
            } else {
                System.out.print(temp.val + "-->" + temp.next.val + " ");
            }
            if (temp.left != null) {
                linkedList.add(temp.left);
            }
            if (temp.right != null) {
                linkedList.add(temp.right);
            }
        }
    }

    /**
     * 数组转二叉树
     * https://leetcode-cn.com/circle/article/htJ97s/
     * @param array
     * @return
     */
    public static TreeNode arrToTree(Integer[] array) {
        if(array.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for(int i = 1; i < array.length; i++){
            TreeNode node = queue.peek();
            if(isLeft){
                if(array[i] != null){
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            }else {
                if(array[i] != null){
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
//        TreeNode root = arrToTree(arr, 1);
//        return root;
    }

    private static TreeNode arrToTree(Integer[] arr, int index) {
        if (index > arr.length) {
            return null;
        }
        Integer value = arr[index - 1];
        if(value == null){
            return null;
        }
        TreeNode node = new TreeNode(value);
        node.left = arrToTree(arr, index * 2);
        node.right = arrToTree(arr, index * 2 + 1);
        return node;
    }

    public static int[] transfer(Integer[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}
