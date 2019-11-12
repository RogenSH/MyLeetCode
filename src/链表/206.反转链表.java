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
       if (head == null || head.next == null) return head;
       
    //    return func1(head);

       return func2(head);
    }

    // 递归!!!
    public ListNode func1(ListNode head) {
        ListNode p = func1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    // 迭代
    public ListNode func2(ListNode head) {
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

