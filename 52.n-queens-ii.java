/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 *
 * https://leetcode.com/problems/n-queens-ii/description/
 *
 * algorithms
 * Hard (51.80%)
 * Total Accepted:    100.4K
 * Total Submissions: 192.4K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return the number of distinct solutions to the n-queens
 * puzzle.
 * 
 * Example:
 * 
 * 
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as
 * shown below.
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * 
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 
 * 
 */
class Solution {
    private int result = 0;
    
    public int totalNQueens(int n) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = new char[n];
            for (int j = 0; j < n; j++) {
                map[i][j] = '.';
            }
        }
        dfs(map, 0);
        return result;
    }
    
    private void dfs(char[][] map, int row) {
        if (row == map.length) {
            result++;
            return;
        }
        for (int i = 0; i < map[row].length; i++) {
            if (isValid(map, row, i)) {
                map[row][i] = 'Q';
                dfs(map, row + 1);
                map[row][i] = '.';
            }
        }
    }
    
    private boolean isValid(char[][] map, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (map[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (map[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < map[row].length; i--, j++) {
            if (map[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
