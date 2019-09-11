/*
 * @lc app=leetcode id=654 lang=java
 *
 * [654] Maximum Binary Tree
 *
 * https://leetcode.com/problems/maximum-binary-tree/description/
 *
 * algorithms
 * Medium (76.22%)
 * Likes:    1226
 * Dislikes: 158
 * Total Accepted:    95.5K
 * Total Submissions: 124K
 * Testcase Example:  '[3,2,1,6,0,5]'
 *
 * 
 * Given an integer array with no duplicates. A maximum tree building on this
 * array is defined as follow:
 * 
 * The root is the maximum number in the array. 
 * The left subtree is the maximum tree constructed from left part subarray
 * divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray
 * divided by the maximum number. 
 * 
 * 
 * 
 * 
 * Construct the maximum tree by the given array and output the root node of
 * this tree.
 * 
 * 
 * Example 1:
 * 
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 * 
 * ⁠     6
 * ⁠   /   \
 * ⁠  3     5
 * ⁠   \    / 
 * ⁠    2  0   
 * ⁠      \
 * ⁠       1
 * 
 * 
 * 
 * Note:
 * 
 * The size of the given array will be in the range [1,1000].
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int partition = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[partition]) {
                partition = i;
            }
        }

        TreeNode node = new TreeNode(nums[partition]);
        node.left = constructTree(nums, start, partition - 1);
        node.right = constructTree(nums, partition + 1, end);
        return node;
    }
}

