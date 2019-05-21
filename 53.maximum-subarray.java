/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (43.39%)
 * Likes:    4192
 * Dislikes: 144
 * Total Accepted:    523.1K
 * Total Submissions: 1.2M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 */
class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArraySum(nums, 0, nums.length - 1);
    }

    // Find the maximum possible sum in arr[]  
    // such that arr[m] is part of it 
    private int maxCrossingSum(int arr[], int l, int m, int h) { 
        // Include elements on left of mid.
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum = sum + arr[i];
            if (sum > left_sum) {
                left_sum = sum;
            }
        } 
  
        // Include elements on right of mid 
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m + 1; i <= h; i++) {
            sum = sum + arr[i];
            if (sum > right_sum) {
                right_sum = sum;
            }
        }
  
        // Return sum of elements on left and right of mid 
        return left_sum + right_sum;
    }

    // Returns sum of maxium sum subarray  
    // in aa[l..h]
    private int maxSubArraySum(int arr[], int l, int h) {
        // Base Case: Only one element 
        if (l == h) {
            return arr[l];
        }
        
        // Find middle point
        int m = (l + h) / 2;

        /* Return maximum of following three possible cases: 
            a) Maximum subarray sum in left half 
            b) Maximum subarray sum in right half 
            c) Maximum subarray sum such that the subarray crosses the midpoint
        */
        return Math.max(Math.max(maxSubArraySum(arr, l, m), maxSubArraySum(arr, m+1, h)),
                        maxCrossingSum(arr, l, m, h)); 
    }
}

