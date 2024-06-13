package com.pyr.jingDongWuLiu;

import java.util.Stack;

/**
 * 1190. 反转每对括号间的子串
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 * <p>
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 解释：先反转子字符串 "love" ，然后反转整个字符串。
 * 示例 3：
 * <p>
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 解释：先反转子字符串 "oc" ，接着反转 "etco" ，然后反转整个字符串。
 * 示例 4：
 * <p>
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 */


public class ReverseParentheses {
    public static String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(String.valueOf(str));
                str = new StringBuilder("");
            } else if (c == ')') {
                StringBuilder reverse = str.reverse();
                reverse.insert(0, stack.pop());
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = "(u(love)i)";
        String s1 = reverseParentheses(s);
        System.out.println(s1);
    }
}

/**
 * 我们从左到右遍历该字符串，使用字符串 str 记录当前层所遍历到的小写英文字母。对于当前遍历的字符：
 * <p>
 * 如果是左括号，将 str 插入到栈中，并将 str 置为空，进入下一层；
 * 如果是右括号，则说明遍历完了当前层，需要将 str反转，返回给上一层。具体地，将栈顶字符串弹出，然后将反转后的 str 拼接到栈顶字符串末尾，将结果赋值给 str。
 * 如果是小写英文字母，将其加到 str 末尾。
 * <p>
 * <p>
 * <p>
 * 输入字符串分析：(u(love)i)
 * 初始化：
 * <p>
 * stack = []
 * sb = ""
 * 第一个字符 (：
 * <p>
 * 将 sb 压入栈中（此时 sb 为空）。
 * 清空 sb。
 * stack = [""]
 * sb = ""
 * 第二个字符 u：
 * <p>
 * 将 u 追加到 sb。
 * stack = [""]
 * sb = "u"
 * 第三个字符 (：
 * <p>
 * 将 sb 压入栈中（此时 sb 为 "u"）。
 * 清空 sb。
 * stack = ["", "u"]
 * sb = ""
 * 第四个字符 l：
 * <p>
 * 将 l 追加到 sb。
 * stack = ["", "u"]
 * sb = "l"
 * 第五个字符 o：
 * <p>
 * 将 o 追加到 sb。
 * stack = ["", "u"]
 * sb = "lo"
 * 第六个字符 v：
 * <p>
 * 将 v 追加到 sb。
 * stack = ["", "u"]
 * sb = "lov"
 * 第七个字符 e：
 * <p>
 * 将 e 追加到 sb。
 * stack = ["", "u"]
 * sb = "love"
 * 第八个字符 )：
 * <p>
 * 反转 sb。
 * 弹出栈顶元素并将其插入到反转后的 sb 开头。
 * sb.reverse() = "evol"
 * sb.insert(0, stack.pop()) = "uevol"
 * stack = [""]
 * sb = "uevol"
 * 第九个字符 i：
 * <p>
 * 将 i 追加到 sb。
 * stack = [""]
 * sb = "uevoli"
 * 第十个字符 )：
 * <p>
 * 反转 sb。
 * 弹出栈顶元素并将其插入到反转后的 sb 开头。
 * sb.reverse() = "iloveu"
 * sb.insert(0, stack.pop()) = "iloveu"
 * stack = []
 * sb = "iloveu"
 * 最终返回的字符串是 "iloveu"。
 */