package com.pyr.jingDongWuLiu;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 */

public class Merge2SortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        int[] rs = new int[m + n];
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                rs[index++] = nums2[p2++];
            } else if (p2 == n) {
                rs[index++] = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                rs[index++] = nums1[p1++];
            } else {
                rs[index++] = nums2[p2++];
            }

        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = rs[i];
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] array2 = new int[]{2, 4, 7};

        merge(array1, 3, array2, 3);
        Arrays.stream(array1).forEach(System.out::println);
    }
}

/**
 * 使用双指针方法。这一方法将两个数组看作队列，每次从两个数组头部取出比较小的数字放到结果中
 * <p>
 * 时间复杂度：O(m+n)O(m+n)O(m+n)。
 * 指针移动单调递增，最多移动 m+nm+nm+n 次，因此时间复杂度为 O(m+n)O(m+n)O(m+n)。
 * <p>
 * 空间复杂度：O(m+n)O(m+n)O(m+n)。
 * 需要建立长度为 m+nm+nm+n 的中间数组 sorted\textit{sorted}sorted。
 */