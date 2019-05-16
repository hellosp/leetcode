/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (41.23%)
 * Total Accepted:    217.9K
 * Total Submissions: 526.5K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note:
 * 
 * 
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 */
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, list, 0);
        return result;
    }
    
    private void dfs(int[] candidates, int target, List<Integer> list, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            if (target - candidates[i] >= 0) {
                list.add(Integer.valueOf(candidates[i]));
                dfs(candidates, target - candidates[i], list, i + 1);
                list.remove(Integer.valueOf(candidates[i]));
            }
        }
    }
}
