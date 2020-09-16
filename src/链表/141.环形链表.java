import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(final ListNode head) {
        // return solution1(head);
        return solution2(head);
        /// 另外还有 递归：破坏链表结构/递归：标记法
    }

    public boolean solution1(final ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (set.contains(current)) {
                return true;
            }
            set.add(current);
        }
        return false;
    }

    public boolean solution2(final ListNode head) {
        if (null == head) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    private boolean traverseBreakSolution1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 判断是否是自环状态
        if (head == head.next) {
            return true;
        }
        // 让遍历过的节点自环
        ListNode breaker = head.next;
        head.next = head;
        return traverseBreakSolution1(breaker);
    }
    
    private boolean traverseMarkSolution2(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.val == 0xcafebabe) {
            return true;
        }
        head.val = 0xcafebabe;
        return traverseMarkSolution2(head.next);
    }

}
// @lc code=end

