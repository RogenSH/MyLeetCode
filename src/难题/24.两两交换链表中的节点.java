/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (62.77%)
 * Likes:    324
 * Dislikes: 0s
 * Total Accepted:    50.4K
 * Total Submissions: 80.3K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
 * 
 * 示例:
 * 
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 
 * 
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        // return func1(head);

        return func2(head);
    }

    //todo: 栈: 空间O(1)，时间O(n) 
    public ListNode func3(ListNode head) {
        //用stack保存每次迭代的两个节点
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode p = new ListNode(-1);
		ListNode cur = head;
		//head指向新的p节点，函数结束时返回head.next即可
		head = p;
		while(cur!=null && cur.next!=null) {
			//将两个节点放入stack中
			stack.add(cur);
			stack.add(cur.next);
			//当前节点往前走两步
			cur = cur.next.next;
			//从stack中弹出两个节点，然后用p节点指向新弹出的两个节点
			p.next = stack.pop();
			p = p.next;
			p.next = stack.pop();
			p = p.next;
		}
		//注意边界条件，当链表长度是奇数时，cur就不为空
		if(cur!=null) {
			p.next = cur;
		} else {
			p.next = null;
		}
		return head.next;
    }

    // 递归！！！
    public ListNode func2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head.next;
        head.next = func2(temp.next);
        temp.next = head;
        return temp;
    }

    // 迭代
    public ListNode func1(ListNode head) {
        ListNode newHead = head.next, curr = head, next = curr.next, pre = null;

        while (curr != null && next != null) {
            curr.next = next.next;
            next.next = curr;
            if (pre != null) pre.next = next;
            if (curr.next == null) break;
            next = curr.next.next;
            pre = curr;
            curr = curr.next;
        }
        return newHead;

        // while (curr != null && curr.next != null) {
        //     ListNode temp = curr.next.next; // 3
        //     curr.next.next = curr; // 
        //     pre.next = curr.next;
        //     curr.next = temp;
        //     pre = curr;
        //     curr = temp;
        // }
        // return pre;
    }

}
// @lc code=end

