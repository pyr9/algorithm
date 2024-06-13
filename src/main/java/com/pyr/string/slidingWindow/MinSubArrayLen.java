package com.pyr.string.slidingWindow;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int curSum = 0;

        int sLength = nums.length;
        if (sLength == 0) {
            return 0;
        }
        while (right < sLength) {
            curSum += nums[right];
            while (curSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                curSum -= nums[left];
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

/**
 * 左右双指针（L，R）在起始点，R向右逐位滑动循环
 * <p>
 * ——每次滑动过程中
 * <p>
 * 窗内元素满足条件，L向右缩小窗口，并更新最优结果
 * 窗内元素不满足条件，R向右扩大窗口
 * ——R到达结尾
 *
 *
 *
 *
 * 1. 初始化 left, right,  currentResult, bestResult
 * 2. while (右指针没有到达结尾) {
 *      加入right对应元素的值，更新currentResult
 *      while (currentResult 满足要求) {
 *         1》更新最优结果 bestResult
 *         2》移除left对应元素的值
 *         3》窗口缩小，left右移 left++;
 *     }
 *     窗口扩大 right右移 right++;
 *    }
 * 3. 返回bestResult
 */