package com.s2u2m.it_study.algo_40.linear;

/**
 * 快慢指针
 * <a href="https://leetcode.cn/problems/linked-list-cycle/" />
 */
public class HasCycleSolution {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
