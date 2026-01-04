package com.s2u2m.it_study.algo_40.linear;

/**
 * 前后指针
 * <a href="https://leetcode.cn/problems/reverse-linked-list/" />
 */
public class ReverseListSolution {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }
}
