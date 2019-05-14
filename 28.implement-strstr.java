/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 *
 * https://leetcode.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (31.81%)
 * Total Accepted:    417.8K
 * Total Submissions: 1.3M
 * Testcase Example:  '"hello"\n"ll"'
 *
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Example 1:
 * 
 * 
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * 
 * 
 * Clarification:
 * 
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 * 
 */
class Solution {
    public int strStr(String haystack, String needle) {
        char[] cHaystack = haystack.toCharArray();
        char[] cNeedle = needle.toCharArray();
        
        int[] next = getNextArray(cNeedle);
        int i = 0, j = 0;
        while (i < cHaystack.length && j < cNeedle.length) {
            if (cHaystack[i] == cNeedle[j]) {
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = next[j - 1];
                } else {
                    i ++;
                }
            }
        }
        if (j >= cNeedle.length) {
            return i - j;
        } else {
            return -1;
        }
    }
    
    private int[] getNextArray(char[] c) {
        if (c.length == 0) {
            return new int[0];
        }
        
        int[] next = new int[c.length];
        next[0] = 0;
        int j = 0, i = 1;
        while (i < c.length) {
            if (c[i] == c[j]) {
                next[i] = j + 1;
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = next[j - 1];
                } else {
                    next[i] = 0;
                    i++;
                }
            }
        }
        return next;
    }
}
