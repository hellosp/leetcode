/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 *
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (48.03%)
 * Likes:    575
 * Dislikes: 87
 * Total Accepted:    151K
 * Total Submissions: 311K
 * Testcase Example:  '3'
 *
 * Given a positive integer n, generate a square matrix filled with elements
 * from 1 to n^2 in spiral order.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 8, 9, 4 ],
 * ⁠[ 7, 6, 5 ]
 * ]
 * 
 * 
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int iStart = 0, iEnd = n - 1, jStart = 0, jEnd = n - 1;
        int num = 1;
        while (iStart <= iEnd && jStart <= jEnd) {
            for (int j = jStart; j <= jEnd; j++) {
                result[iStart][j] = num++;
            }
            iStart++;
            for (int i = iStart; i <= iEnd; i++) {
                result[i][jEnd] = num++;
            }
            jEnd--;
            for (int j = jEnd; j >= jStart; j--) {
                result[iEnd][j] = num++;
            }
            iEnd--;
            for (int i = iEnd; i >= iStart; i--) {
                result[i][jStart] = num++;
            }
            jStart++;
        }
        return result;
    }
}

