import java.util.*;

/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 *
 * https://leetcode.com/problems/reconstruct-itinerary/description/
 *
 * algorithms
 * Medium (32.42%)
 * Likes:    897
 * Dislikes: 586
 * Total Accepted:    91.9K
 * Total Submissions: 283.3K
 * Testcase Example:  '[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]'
 *
 * Given a list of airline tickets represented by pairs of departure and
 * arrival airports [from, to], reconstruct the itinerary in order. All of the
 * tickets belong to a man who departs from JFK. Thus, the itinerary must begin
 * with JFK.
 * 
 * Note:
 * 
 * 
 * If there are multiple valid itineraries, you should return the itinerary
 * that has the smallest lexical order when read as a single string. For
 * example, the itinerary ["JFK", "LGA"] has a smaller lexical order than
 * ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is
 * ["JFK","SFO","ATL","JFK","ATL","SFO"].
 * But it is larger in lexical order.
 * 
 * 
 */
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            
            // if (adj.containsKey(from)) {
            //     adj.get(from).add(to);
            // } else {
            //     PriorityQueue<String> set = new PriorityQueue<>();
            //     set.add(to);
            //     adj.put(from, set);
            // }
            adj.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }

        List<String> result = new ArrayList<>();
        dfs("JFK", adj, result);
        return result;
    }

    private void dfs(String node, HashMap<String, PriorityQueue<String>> adj, List<String> result) {
        if (adj.containsKey(node)) {
            PriorityQueue<String> set = adj.get(node);
            while (!set.isEmpty()) {
                dfs(set.poll(), adj, result);
            }
        }
        result.add(0, node);
    }
}

