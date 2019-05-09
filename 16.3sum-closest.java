/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (44.97%)
 * Total Accepted:    335.1K
 * Total Submissions: 744.3K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int newSum = nums[i] + nums[j] + nums[k];
                sum = Math.abs(target - sum) < Math.abs(target - newSum) ?
                            sum : newSum;
                if (newSum < target) {
                    j++;
                } else if (newSum > target) {
                    k--;
                } else {
                    return target;
                }
            }
        }
        return sum;
    }
}
