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
    //    return func1(head);
    //    return func2(head);
        return test(head);
    }

    public ListNode test(ListNode head) {

        

    }

    // 递归!!! [解释](https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/)
    public ListNode func1(ListNode head) {
        // # 递归终止条件是当前为空，或者下一个节点为空，也就是返回最后一个节点，即 5
        if (head == null || head.next == null) return head;
        // # 这里的cur就是最后一个节点
        ListNode p = solution1(head.next);
        // # 如果链表是 1->2->3->4->5，那么此时的cur就是5
		// # 而head是4，head的下一个是5，下下一个是空
		// # 所以head.next.next 就是5->4
        head.next.next = head;
        // 防止链表循环，需要将head.next设置为空
        head.next = null;
        // 每层递归函数都返回cur，也就是最后一个节点
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

