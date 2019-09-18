/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 *
 * algorithms
 * Hard (30.78%)
 * Likes:    1963
 * Dislikes: 147
 * Total Accepted:    220.1K
 * Total Submissions: 713.1K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the
 * root.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   3
 * 
 * Output: 6
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-10,9,20,null,null,15,7]
 * 
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * 
 * Output: 42
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int result;

    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        calPath(root);
        return result;
    }

    private int calPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(calPath(root.left), 0);
        int right = Math.max(calPath(root.right), 0);
        result = Math.max(result, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}

