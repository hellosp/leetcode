/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (30.36%)
 * Likes:    1052
 * Dislikes: 403
 * Total Accepted:    231.4K
 * Total Submissions: 762K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * Input:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }

        int[][] d = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] mark = new boolean[matrix.length][matrix[0].length];

        int direction = 0;
        int target = matrix.length * matrix[0].length;

        mark[0][0] = true;
        result.add(matrix[0][0]);

        int x = 0, y = 0;
        while (result.size() < target) {
            for (;;) {
                int nextX = x + d[direction][0];
                int nextY = y + d[direction][1];
                if (nextX < 0 || nextY < 0 || nextX >= matrix.length || nextY >= matrix[0].length) {
                    break;
                }
                if (mark[nextX][nextY]) {
                    break;
                }
                x = nextX;
                y = nextY;
                mark[x][y] = true;
                result.add(matrix[x][y]);
            }
            direction = (direction + 1) % 4;
        }
        return result;
    }
}

