import java.util.*;

/*
 * @lc app=leetcode id=336 lang=java
 *
 * [336] Palindrome Pairs
 *
 * https://leetcode.com/problems/palindrome-pairs/description/
 *
 * algorithms
 * Hard (31.05%)
 * Likes:    779
 * Dislikes: 104
 * Total Accepted:    70.4K
 * Total Submissions: 226.8K
 * Testcase Example:  '["abcd","dcba","lls","s","sssll"]'
 *
 * Given a list of unique words, find all pairs of distinct indices (i, j) in
 * the given list, so that the concatenation of the two words, i.e. words[i] +
 * words[j] is a palindrome.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]] 
 * Explanation: The palindromes are
 * ["dcbaabcd","abcddcba","slls","llssssll"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]] 
 * Explanation: The palindromes are ["battab","tabbat"]
 * 
 * 
 * 
 * 
 */
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            search(root, words[i], i, result);
        }
        return result;
    }

    private void addWord(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            if (isPalindrome(word, 0, i)) {
                root.list.add(index);
            }

            int pos = (int) (word.charAt(i) - 'a');
            if (root.next[pos] == null) {
                root.next[pos] = new TrieNode();
            }
            root = root.next[pos];
        }

        root.list.add(index);
        root.index = index;
    }

    private void search(TrieNode root, String word, int index, List<List<Integer>> result) {
        for (int i = 0; i < word.length(); i++) {
            if (root.index >= 0 && root.index != index &&
                    isPalindrome(word, i, word.length() - 1)) {
                result.add(Arrays.asList(index, root.index));
            }

            int pos = (int) (word.charAt(i) - 'a');
            if (root.next[pos] == null) {
                return;
            }
            root = root.next[pos];
        }

        for (int i : root.list) {
            if (index == i) {
                continue;
            }
            result.add(Arrays.asList(index, i));
        }
    }

    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    class TrieNode {
        TrieNode[] next;
        int index;
        List<Integer> list;

        TrieNode() {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }
}
