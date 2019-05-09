/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (54.49%)
 * Total Accepted:    330.1K
 * Total Submissions: 605.2K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */
class Solution {
    private List<String> result = new ArrayList<>();
    
    private void backtrack(String s, int n, int left, int right) {
        if (s.length() == n * 2) {
            result.add(s);
            return;
        }
        if (left < n) {
            backtrack(s + '(', n, left + 1, right);
        }
        if (right < left) {
            backtrack(s + ')', n, left, right + 1);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        backtrack("", n, 0, 0);
        return result;
    }
}
