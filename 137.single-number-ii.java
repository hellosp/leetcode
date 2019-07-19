/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 *
 * https://leetcode.com/problems/single-number-ii/description/
 *
 * algorithms
 * Medium (46.07%)
 * Likes:    874
 * Dislikes: 261
 * Total Accepted:    172K
 * Total Submissions: 370.5K
 * Testcase Example:  '[2,2,3,2]'
 *
 * Given a non-empty array of integers, every element appears three times
 * except for one, which appears exactly once. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * 
 * Input: [2,2,3,2]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 * 
 */
class Solution {
    public int singleNumber(int[] nums) {
        int low = 0, high = 0;
        for (int i = 0; i < nums.length; i++) {
            low = (low ^ nums[i]) & ~high;
            high = (high ^ nums[i]) & ~low;
        }
        return low;
    }
}

