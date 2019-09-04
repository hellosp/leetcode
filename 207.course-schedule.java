import java.util.*;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (39.03%)
 * Likes:    2136
 * Dislikes: 99
 * Total Accepted:    250.5K
 * Total Submissions: 641.3K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * Example 1:
 * 
 * 
 * Input: 2, [[1,0]] 
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * Example 2:
 * 
 * 
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should
 * also have finished course 1. So it is impossible.
 * 
 * 
 * Note:
 * 
 * 
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input
 * prerequisites.
 * 
 * 
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] adj = new boolean[numCourses][numCourses];
        int[] inEdge = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new boolean[numCourses];
            inEdge[i] = 0;
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            int p = prerequisites[i][1];
            int q = prerequisites[i][0];
            adj[p][q] = true;
            inEdge[q]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inEdge[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int n = queue.pop();
            for (int i = 0; i < numCourses; i++) {
                if (adj[n][i]) {
                    adj[n][i] = false;
                    inEdge[i]--;
                    if (inEdge[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
                if (adj[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

