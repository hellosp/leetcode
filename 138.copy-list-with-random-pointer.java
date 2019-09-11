import java.util.*;

/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 *
 * algorithms
 * Medium (26.98%)
 * Likes:    1524
 * Dislikes: 417
 * Total Accepted:    244.2K
 * Total Submissions: 905.2K
 * Testcase Example:  '{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}'
 *
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input:
 * 
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * 
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer
 * points to itself.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * You must return the copy of the given head as a reference to the cloned
 * list.
 * 
 * 
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Integer, Node> map = new HashMap<>();
        Node dummy = new Node();

        Node p = head, q = dummy;
        while (p != null) {
            Node n = new Node();
            n.val = p.val;
            q.next = n;
            map.put(n.val, n);

            q = q.next;
            p = p.next;
        }

        p = head;
        q = dummy.next;
        while (p != null) {
            Node r = p.random;
            if (r != null) {
                Node n = map.get(r.val);
                q.random = n;
            }

            q = q.next;
            p = p.next;
        }
        return dummy.next;
    }
}

