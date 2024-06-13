package com.pyr.linkList;

/**
 * 给定两个单链表的头节点 headA 和 headB ，请找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}

/**
 * \同样的步数：当两个指针都遍历完第一次遍历后，它们实际上都走过了
 * 𝑚
 * +
 * 𝑛
 * m+n 步（m是链表A的长度，n是链表B的长度），无论它们的起始点如何，当它们交换链表后，再次开始遍历，它们将会在交点相遇。
 * 交点：因为两个指针都走了相同的总步数
 * 𝑚
 * +
 * 𝑛
 * m+n，它们在第二次遍历时将会在交点相遇。如果没有交点，它们最终都会指向 null。
 */