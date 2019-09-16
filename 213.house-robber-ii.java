/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 *
 * https://leetcode.com/problems/house-robber-ii/description/
 *
 * algorithms
 * Medium (35.54%)
 * Likes:    1040
 * Dislikes: 35
 * Total Accepted:    128.7K
 * Total Submissions: 361.9K
 * Testcase Example:  '[2,3,2]'
 *
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last
 * one. Meanwhile, adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were broken into on
 * the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money
 * = 2),
 * because they are adjacent houses.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money =
 * 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 */
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // Fn = max(Fn-2 + nums[n], Fn-1)
        int f1, f2, result;

        f1 = nums[0];
        f2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            int f = Math.max(f1 + nums[i], f2);
            f1 = f2;
            f2 = f;
        }
        result = f2;
        
        f1 = nums[1];
        f2 = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i++) {
            int f = Math.max(f1 + nums[i], f2);
            f1 = f2;
            f2 = f;
        }
        result = Math.max(result, f2);
        return result;
    }
}

