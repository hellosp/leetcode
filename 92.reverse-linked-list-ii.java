/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (35.87%)
 * Likes:    1412
 * Dislikes: 100
 * Total Accepted:    211.7K
 * Total Submissions: 589.8K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p = dummy, q = dummy;
        for (int i = 0; i < m - 1 && p != null; i++) {
            p = p.next;
        }
        for (int i = 0; i < n && q != null; i++) {
            q = q.next;
        }

        ListNode c;
        for (int i = 0; i < n - m; i++) {
            c = p.next;
            p.next = c.next;
            c.next = q.next;
            q.next = c;
        }
        return dummy.next;
    }
}

