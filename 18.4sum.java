/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (30.30%)
 * Total Accepted:    228.3K
 * Total Submissions: 753.1K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int sum = target - nums[i] - nums[j];
                int m = j + 1, n = nums.length - 1;
                while (m < n) {
                    if (nums[m] + nums[n] == sum) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        m++;
                        n--;
                        while (m < n && nums[m] == nums[m - 1]) m++;
                    } else if (nums[m] + nums[n] < sum) {
                        m++;
                    } else {
                        n--;
                    }
                }
            }
        }
        return result;
    }
}
