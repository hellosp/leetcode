/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 *
 * https://leetcode.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (39.12%)
 * Total Accepted:    143.1K
 * Total Submissions: 362K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * Example:
 * 
 * 
 * Input: 4
 * Output: [
 * ⁠[".Q..",  // Solution 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 * 
 * ⁠["..Q.",  // Solution 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as
 * shown above.
 * 
 * 
 */
class Solution {
    private List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
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
            List<String> list = new ArrayList<>();
            for (int i = 0; i < map.length; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < map[i].length; j++) {
                    builder.append(map[i][j]);
                }
                list.add(builder.toString());
            }
            result.add(list);
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
