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
        char[] cWords = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != cWords[0]) {
                    continue;
                }
                if (dfs(board, cWords, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int current, int i, int j) {
        if (current == words.length) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
            return false;
        }
        if (board[i][j] != words[current]) {
            return false;
        }

        char c = board[i][j];
        board[i][j] = '*';
        int[][] d = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int k = 0; k < 4; k++) {
            int x = i + d[k][0];
            int y = j + d[k][1];
            if (dfs(board, words, current + 1, x, y)) {
                return true;
            }
        }
        board[i][j] = c;
        return false;
    }
}

