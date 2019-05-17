/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (40.16%)
 * Total Accepted:    239.9K
 * Total Submissions: 595.3K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,1,2]
 * Output:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 */
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if (i > 0 && nums[i] == nums[i - 1] && !mark[i - 1]) {
                continue;
            }
            
            mark[i] = true;
            list.add(Integer.valueOf(nums[i]));
            dfs(nums, list, mark);
            mark[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
