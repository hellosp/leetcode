import java.util.*;

/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 *
 * https://leetcode.com/problems/network-delay-time/description/
 *
 * algorithms
 * Medium (43.54%)
 * Likes:    747
 * Dislikes: 181
 * Total Accepted:    44K
 * Total Submissions: 100.7K
 * Testcase Example:  '[[2,1,1],[2,3,1],[3,4,1]]\n4\n2'
 *
 * There are N network nodes, labelled 1 to N.
 * 
 * Given times, a list of travel times as directed edges times[i] = (u, v, w),
 * where u is the source node, v is the target node, and w is the time it takes
 * for a signal to travel from source to target.
 * 
 * Now, we send a signal from a certain node K. How long will it take for all
 * nodes to receive the signal? If it is impossible, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * Output: 2
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * N will be in the range [1, 100].
 * K will be in the range [1, N].
 * The length of times will be in the range [1, 6000].
 * All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
 * 
 * 
 */
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            adj.get(u).add(new Node(v, w));
        }

        int[] dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> queue = new PriorityQueue<>(N, new Node());

        dist[K] = 0;
        queue.add(new Node(K, 0));
        while (!queue.isEmpty()) {
            int u = queue.remove().node;
            if (visited[u]) {
                continue;
            }
            visited[u] = true;

            List<Node> nodes = adj.get(u);
            for (int i = 0; i < nodes.size(); i++) {
                Node v = nodes.get(i);
                if (!visited[v.node]) {
                    int newDist = dist[u] + v.cost;
                    if (newDist < dist[v.node]) {
                        dist[v.node] = newDist;
                    }
                    queue.add(new Node(v.node, dist[v.node]));
                }
            }
        }

        int result = -1;
        for (int i = 1; i <= N; i++) {
            if (i == K) {
                continue;
            }
            if (dist[i] == Integer.MAX_VALUE) {
                result = -1;
                break;
            }
            if (result < dist[i]) {
                result = dist[i];
            }
        }
        return result;
    }

    class Node implements Comparator<Node> {
        int node;
        int cost;

        public Node() {}
        
        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node n1, Node n2) {
            if (n1.cost > n2.cost) {
                return 1;
            } else if (n1.cost < n2.cost) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

