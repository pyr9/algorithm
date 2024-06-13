package com.pyr.jingDongWuLiu;

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
class CountAndSay {
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


/**
 * 详细步骤
 * 初始化序列：
 * <p>
 * String str = "1";：从第 1 项开始，初始化为 "1"。
 * 生成第 2 到第 n 项：
 * <p>
 * 使用 for 循环，从 2 开始，循环到 n。
 * 在每次循环中，使用一个 StringBuilder sb 来构建当前项的描述。
 * 用 start 和 pos 两个指针来遍历当前序列 str。
 *   start：标记一段连续相同字符的起始位置。
 *   pos：用于遍历当前字符串，并找到下一段不同字符的起始位置。
 * 遍历当前序列：
 * <p>
 * 外层 while (pos < str.length()) 循环确保遍历整个当前序列。
 * 内层 while (pos < str.length() && str.charAt(pos) == str.charAt(start)) 循环用于找出一段连续相同字符的长度。
 * 找到一段连续相同字符后，sb.append(pos - start).append(str.charAt(start)); 将这段字符的长度和字符本身追加到 StringBuilder sb 中。
 * 更新 start 到 pos 的位置，以处理下一段字符。
 * 更新当前项：
 * <p>
 * str = sb.toString();：在完成一个新的序列生成后，将 sb 转换成字符串，更新为新的当前项。
 * 返回结果：
 * <p>
 * 最后，返回生成的第 n 项的序列 str。
 */