/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (31.17%)
 * Likes:    1708
 * Dislikes: 82
 * Total Accepted:    278.6K
 * Total Submissions: 894K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * 
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return false;
        }
        char begin = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != begin) {
                    continue;
                }
                boolean[][] mark = new boolean[board.length][board[0].length];
                if (dfs(board, word, 0, i, j, mark)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int current,
                        int i, int j, boolean[][] mark) {
        if (current == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || mark[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(current)) {
            return false;
        }

        mark[i][j] = true;
        int[][] d = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int k = 0; k < 4; k++) {
            int x = i + d[k][0];
            int y = j + d[k][1];
            if (dfs(board, word, current + 1, x, y, mark)) {
                return true;
            }
        }
        mark[i][j] = false;
        return false;
    }
}

