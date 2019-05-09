/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.13%)
 * Total Accepted:    538.1K
 * Total Submissions: 2M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        
        char[] data = s.toCharArray();
        boolean[][] A = new boolean[length][length];
        
        int start = 0, max = 1;
        for (int i = 0; i < length; i++) {
            A[i][i] = true;
        }
        
        for (int i = 0; i < length - 1; i++) {
            A[i][i + 1] = (data[i] == data[i + 1]);
            if (A[i][i + 1] && 2 > max) {
                start = i;
                max = 2;
            }
        }
        
        for (int k = 3; k <= length; k++) {
            for (int i = 0; i < length - k + 1; i++) {
                int j = i + k - 1;
                if (A[i + 1][j - 1] && data[i] == data[j]) {
                    A[i][j] = true;
                }
                
                if (A[i][j] && k > max) {
                    start = i;
                    max = k;
                }
            }
        }
        return s.substring(start, start + max);
    }
}
