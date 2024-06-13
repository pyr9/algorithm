package com.pyr.jingDongWuLiu;

import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 */
public class MyQueue {
    Stack<Integer> stackIn = new Stack<>();
    Stack<Integer> stackOut = new Stack<>();

    public Integer push(Integer num) {
        Integer push = stackIn.push(num);
        return push;
    }


    public Integer pop() {
        if (stackOut.empty()) {
            reverseStack();
        }
        return stackOut.pop();
    }

    public Integer peek() {
        // 注意这里加判断
        if (stackOut.empty()) {
            reverseStack();
        }
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    private void reverseStack() {
        while (!stackIn.empty()) {
            // 这里是关键步骤
            stackOut.push(stackIn.pop());
        }
    }
}

/**
 * 将一个栈当作输入栈，用于压入 push传入的数据；另一个栈当作输出栈，用于 pop\texttt{pop}pop 和 peek\texttt{peek}peek 操作。
 * <p>
 * 每次 poppop 或 peek 时，若输出栈为空则将输入栈的全部数据依次弹出并压入输出栈，这样输出栈从栈顶往栈底的顺序就是队列从队首往队尾的顺序。
 */