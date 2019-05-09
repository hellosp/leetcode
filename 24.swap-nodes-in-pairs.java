/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (44.30%)
 * Total Accepted:    307.3K
 * Total Submissions: 692.9K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        
        /*
         dum->1->2->3->4
          p  n1 n2
         
         dum->2->1->3->4
          p  n2 n1
         */
        while (p.next != null && p.next.next != null) {
            ListNode n1 = p.next;
            ListNode n2 = n1.next;
            p.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            p = n1;
        }
        return dummy.next;
    }
}
