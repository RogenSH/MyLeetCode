/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        return solution1(head, k);
    }

    public ListNode solution1(ListNode head, int k) {
        if (!isFullLoop(head, k)) return head;
        ListNode temp = reverseSingleList(head, k);
        ListNode last = getLastNode(head, k);
        ListNode node = solution1(last, k);
        head.next = node;
        return temp;
    }

    public ListNode reverseSingleList(ListNode head, int k) {
        ListNode pre = null;
        ListNode curr = head;
        int i = 0;
        while (i < k - 1) {
            ListNode nextNode = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextNode;
            i++;
        }
        return pre;
    }

    public boolean isFullLoop(ListNode preNode, int k) {
        if (preNode == null) return false;
        ListNode current = preNode.next;
        int index = 0;
        while (index < k - 1) {
            if (current == null) {
                return false;
            }
            current = current.next;
            index++;
        }
        return true;
    }

    /// todo: 先实现，后抽出
    public ListNode getLastNode(ListNode preNode, int k) {
        if (preNode == null || preNode.next == null) return null;
        ListNode current = preNode.next;
        int index = 0;
        while (index < k) {
            if (current.next == null) {
                if (index == k - 1) {
                    return current;
                }
                return null;
            }
            current = current.next;
            index++;
        }
        return current;
    }
}
// @lc code=end

