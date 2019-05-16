/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 *
 * https://leetcode.com/problems/sudoku-solver/description/
 *
 * algorithms
 * Hard (36.52%)
 * Total Accepted:    126.9K
 * Total Submissions: 346K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * 
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3
 * sub-boxes of the grid.
 * 
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * 
 * A sudoku puzzle...
 * 
 * 
 * ...and its solution numbers marked in red.
 * 
 * Note:
 * 
 * 
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique
 * solution.
 * The given board size is always 9x9.
 * 
 * 
 */
class Solution {
    private int[] rowMark = new int[9];
    private int[] columnMark = new int[9];
    private int[] blockMark = new int[9];
    
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int r = i/3*3 + j/3;
                    rowMark[i] |= 1 << num;
                    columnMark[j] |= 1 << num;
                    blockMark[r] |= 1 << num;
                }
            }
        }
        dfs(board);
    }
    
    private boolean dfs(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        int num = c - '0';
                        if (isValid(i, j, num)) {
                            board[i][j] = c;
                            markNum(i, j, num, true);
                            if (dfs(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                            markNum(i, j, num, false);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(int i, int j, int num) {
        int r = i/3*3 + j/3;
        boolean isRowValid = (rowMark[i] & (1 << num)) == 0;
        boolean isColumnValid = (columnMark[j] & (1 << num)) == 0;
        boolean isBlockValid = (blockMark[r] & (1 << num)) == 0;
        return isRowValid && isColumnValid && isBlockValid;
    }
    
    private void markNum(int i, int j, int num, boolean isMark) {
        int r = i/3*3 + j/3;
        if (isMark) {
            rowMark[i] |= 1 << num;
            columnMark[j] |= 1 << num;
            blockMark[r] |= 1 << num;
        } else {
            rowMark[i] &= ~(1 << num);
            columnMark[j] &= ~(1 << num);
            blockMark[r] &= ~(1 << num);
        }
    }
}
