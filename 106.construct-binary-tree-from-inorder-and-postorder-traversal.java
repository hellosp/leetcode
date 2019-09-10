/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (40.76%)
 * Likes:    1010
 * Dislikes: 21
 * Total Accepted:    168.5K
 * Total Submissions: 411.7K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    private int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        return buildTree(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[index--]);
        if (start == end) {
            return node;
        }
        int partition = 0;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == node.val) {
                partition = i;
                break;
            }
        }
        node.right = buildTree(inorder, postorder, partition + 1, end);
        node.left = buildTree(inorder, postorder, start, partition - 1);
        return node;
    }

    // public class TreeNode {
    //     int val;
    //     TreeNode left;
    //     TreeNode right;
    //     TreeNode(int x) { val = x; }
    // }
}

