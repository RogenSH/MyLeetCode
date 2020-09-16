import java.util.List;

/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
    //    return solution1(head);
       return solution2(head);
    }

    public ListNode test1(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public ListNode test2(ListNode head) {
        if (head == null) return head;
        ListNode node = test2(head.next);
    }

    // 递归!!!
    public ListNode solution1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = solution1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    // 迭代
    public ListNode solution2(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextNode;
        }
        return pre;
    }

}
// @lc code=end

