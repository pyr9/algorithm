package com.pyr.jingdong;

/**
 * 「外观数列」是一个数位字符串序列，由递归公式定义：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是 countAndSay(n-1) 的行程长度编码。
 * <p>
 * <p>
 * 行程长度编码（RLE）是一种字符串压缩方法，其工作原理是通过将连续相同字符（重复两次或更多次）替换为字符重复次数（运行长度）和字符的串联。例如，要压缩字符串 "3322251" ，我们将 "33" 用 "23" 替换，将 "222" 用 "32" 替换，将 "5" 用 "15" 替换并将 "1" 用 "11" 替换。因此压缩后字符串变为 "23321511"。
 * <p>
 * 给定一个整数 n ，返回 外观数列 的第 n 个元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * <p>
 * 输出："1211"
 * <p>
 * 解释：
 * <p>
 * countAndSay(1) = "1"
 * <p>
 * countAndSay(2) = "1" 的行程长度编码 = "11"
 * <p>
 * countAndSay(3) = "11" 的行程长度编码 = "21"
 * <p>
 * countAndSay(4) = "21" 的行程长度编码 = "1211"
 */
class Solution {
    public static String countAndSay(int n) {
        String str = "1";

        for (int i = 2; i <= n; ++i) {
            StringBuilder s = new StringBuilder();
            int start = 0;
            int pos = 0;
            while (pos < str.length()) {
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                    pos++;
                }
                s.append(pos - start).append(str.charAt(start));
                start = pos;
            }
            str = String.valueOf(s);
        }
        return str;
    }

    public static void main(String[] args) {
        String s = countAndSay(5);
        System.out.println(s);
    }
}
