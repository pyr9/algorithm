package com.pyr.jingDongWuLiu;

import java.util.HashMap;

/**
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 * <p>
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: s = "aabb"
 * 输出: -1
 */
public class FirstUniqChar {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int loveleetcode = firstUniqChar("loveleetcode");
        System.out.println(loveleetcode);
    }
}

/**
 * 我们可以对字符串进行两次遍历。
 * <p>
 * 在第一次遍历时，我们使用哈希映射统计出字符串中每个字符出现的次数。在第二次遍历时，我们只要遍历到了一个只出现一次的字符，那么就返回它的索引，否则在遍历结束后返回 −1-1−1。
 * <p>
 * 时间复杂度：O(n)，其中 n 是字符串 s 的长度。我们需要进行两次遍历。
 * <p>
 * 空间复杂度：O(∣Σ∣)，其中 Σ 是字符集，在本题中 s 只包含小写字母，因此O(∣Σ∣) <= 26。我们需要 O(∣Σ∣) 的空间存储哈希映射。
 */