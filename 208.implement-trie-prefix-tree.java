/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (40.21%)
 * Likes:    1840
 * Dislikes: 35
 * Total Accepted:    200K
 * Total Submissions: 494.8K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Example:
 * 
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");   
 * trie.search("app");     // returns true
 * 
 * 
 * Note:
 * 
 * 
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 * 
 * 
 */
class Trie {
    private TrieNode mRoot;

    /** Initialize your data structure here. */
    public Trie() {
        mRoot = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        char[] cWords = word.toCharArray();
        TrieNode node = this.mRoot;
        for (int i = 0; i < cWords.length; i++) {
            int pos = (int)(cWords[i] - 'a');
            if (node.son[pos] == null) {
                node.son[pos] = new TrieNode();
                node.son[pos].val = cWords[i];
            }
            node = node.son[pos];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] cWords = word.toCharArray();
        TrieNode node = this.mRoot;
        for (int i = 0; i < cWords.length; i++) {
            int pos = (int)(cWords[i] - 'a');
            if (node.son[pos] == null) {
                return false;
            }
            node = node.son[pos];
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] cWords = prefix.toCharArray();
        TrieNode node = this.mRoot;
        for (int i = 0; i < cWords.length; i++) {
            int pos = (int)(cWords[i] - 'a');
            if (node.son[pos] == null) {
                return false;
            }
            node = node.son[pos];
        }
        return true;
    }

    class TrieNode {
        TrieNode[] son;
        boolean isEnd;
        char val;
        
        public TrieNode() {
            this.son = new TrieNode[26];
            this.isEnd = false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

