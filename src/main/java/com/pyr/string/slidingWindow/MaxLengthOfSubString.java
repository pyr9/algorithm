package com.pyr.string.slidingWindow;

import java.util.HashMap;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class MaxLengthOfSubString {
    public static int maxLengthOfSubString(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            right = Math.max(right, i - left + 1);
        }
        return right;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = maxLengthOfSubString(s);
        System.out.println(i);
    }
}

/**
 * 左右双指针（L，R）在起始点，R向右逐位滑动循环
 * <p>
 * ——每次滑动过程中
 * <p>
 * 窗内元素满足条件，R向右扩大窗口，并更新最优结果
 * 窗内元素不满足条件，L向右缩小窗口
 * ——R到达结尾
 *
 *
 *
 * 1. 初始化 left, right,  currentResult, bestResult
 * 2. while (右指针没有到达结尾) {
 *      加入right对应元素的值，更新currentResult
 *      while (currentResult 不满足要求) {
 *         1 窗口缩小，left右移 left++;
 *     }
 *     1》更新最优结果 bestResult
 *     2》窗口扩大 right右移 right++;
 *    }
 * 3. 返回bestResult
 */