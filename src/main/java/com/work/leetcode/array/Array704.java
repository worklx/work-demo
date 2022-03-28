package com.work.leetcode.array;

/**
 * @author chenlx2
 */
public class Array704 {
    /**
     * 704. 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     * 示例 1:
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * 示例 2:
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     * 提示：
     * · 你可以假设 nums 中的所有元素是不重复的。
     * · n 将在 [1, 10000]之间。
     * · nums 的每个元素都将在 [-9999, 9999]之间。
     * @param args
     */
    public static void main(String[] args) {
        // 有序且升序，就考虑二分查找，况且没有重复元素
        // 二分查找主要就是如何确定边界，因为元素个数可能是奇数也可能是偶数

    }

    public int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 定义target在左闭右闭的区间里，[left, right]
        // 当left==right，区间[left, right]依然有效，所以用 <=
        while (left <= right) {
            // 防止溢出等同于(left + right)/2
            // left + ((right - left) / 2)
            int middle = left + ((right - left) >> 1);
            if (nums[middle] > target) {
                // target 在左区间，所以[left, middle - 1]
                right = middle - 1;
            } else if (nums[middle] < target) {
                // target 在右区间，所以[middle + 1, right]
                left = middle + 1;
            } else {
                // nums[middle] == target
                // 数组中找到目标值，直接返回下标
                return middle;
            }
        }
        // 未找到目标值
        return -1;
    }

    public int search2(int[] nums, int target) {
        int left = 0;
        // 定义target在左闭右开的区间里，即：[left, right)
        int right = nums.length;
        // 因为left == right的时候，在[left, right)是无效的空间，所以使用 <
        while (left < right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] > target) {
                // target 在左区间，在[left, middle)中
                right = middle;
            } else if (nums[middle] < target) {
                // target 在右区间，在[middle + 1, right)中
                left = middle + 1;
            } else {
                // nums[middle] == target
                // 数组中找到目标值，直接返回下标
                return middle;
            }
        }
        // 未找到目标值
        return -1;
    }

}
