/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (22.20%)
 * Likes:    1356
 * Dislikes: 1552
 * Total Accepted:    258.2K
 * Total Submissions: 1.2M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */
class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        char[] data = s.toCharArray();
        int[] dp = new int[data.length];
        dp[0] = isValid(data[0]) ? 1 : 0;
        for (int i = 1; i < data.length; i++) {
            if (i == 1) {
                dp[i] = (isValid(data[i]) ? dp[i - 1] : 0) +
                        (isValid(data[i - 1], data[i]) ? 1 : 0);
            } else {
                dp[i] = (isValid(data[i]) ? dp[i - 1] : 0) +
                        (isValid(data[i - 1], data[i]) ? dp[i - 2] : 0);
            }
        }
        return dp[data.length - 1];
    }

    private boolean isValid(char a) {
        int m = (int)(a - '0');
        return m >= 1 && m <= 9;
    }

    private boolean isValid(char a, char b) {
        if (a == '0') {
            return false;
        }
        int m = (int)(a - '0');
        int n = (int)(b - '0');
        int num = m * 10 + n;
        return num >= 1 && num <= 26;
    }
}

