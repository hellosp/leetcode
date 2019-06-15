/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 *
 * https://leetcode.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (28.82%)
 * Likes:    1118
 * Dislikes: 68
 * Total Accepted:    114.4K
 * Total Submissions: 396.9K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n["oath","pea","eat","rain"]'
 *
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: 
 * board = [
 * ⁠ ['o','a','a','n'],
 * ⁠ ['e','t','a','e'],
 * ⁠ ['i','h','k','r'],
 * ⁠ ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * 
 * Output: ["eat","oath"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 * 
 * 
 */
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (exist(board, word)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return false;
        }
        char[] cWords = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != cWords[0]) {
                    continue;
                }
                boolean[][] mark = new boolean[board.length][board[0].length];
                if (dfs(board, cWords, 0, i, j, mark)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int current, int i, int j, boolean[][] mark) {
        if (current == words.length) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || mark[i][j]) {
            return false;
        }
        if (board[i][j] != words[current]) {
            return false;
        }

        mark[i][j] = true;
        int[][] d = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int k = 0; k < 4; k++) {
            int x = i + d[k][0];
            int y = j + d[k][1];
            if (dfs(board, words, current + 1, x, y, mark)) {
                return true;
            }
        }
        mark[i][j] = false;
        return false;
    }
}

