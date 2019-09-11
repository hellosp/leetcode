import java.util.*;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (49.48%)
 * Likes:    2374
 * Dislikes: 188
 * Total Accepted:    430.2K
 * Total Submissions: 866.3K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);

        k = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            final int p = partition(nums, lo, hi);
            if (p < k) {
                lo = p + 1;
            } else if (p > k) {
                hi = p - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private void shuffle(int[] a) {
        final Random random = new Random();
        for (int i = a.length - 1; i >= 0; i--) {
            swap(a, i, random.nextInt(i + 1));
        }
    }

    private int partition(int[] a, int lo, int hi) {
        int pivot = a[lo];
        while (lo < hi) {
            while (a[hi] >= pivot && lo < hi) {
                hi--;
            }
            a[lo] = a[hi];
            while (a[lo] <= pivot && lo < hi) {
                lo++;
            }
            a[hi] = a[lo];
        }
        a[lo] = pivot;
        return lo;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

