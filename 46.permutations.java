/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (54.74%)
 * Total Accepted:    373.6K
 * Total Submissions: 680.2K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        boolean[] mark = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        dfs(nums, list, mark);
        return result;
    }
    
    private void dfs(int[] nums, List<Integer> list, boolean[] mark) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (mark[i]) {
                continue;
            }
            mark[i] = true;
            list.add(Integer.valueOf(nums[i]));
            dfs(nums, list, mark);
            mark[i] = false;
            list.remove(Integer.valueOf(nums[i]));
        }
    }
}
