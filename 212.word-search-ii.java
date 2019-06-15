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
    Set<String> result = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String str : words) {
            trie.insert(str);
        }

        boolean[][] mark = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, "", i, j, mark, trie);
            }
        }
        return new ArrayList<String>(result);
    }

    private void dfs(char[][] board, String current, int i, int j, boolean[][] mark, Trie trie) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || mark[i][j]) {
            return;
        }

        current += board[i][j];
        if (!trie.startsWith(current)) {
            return;
        }
        if (trie.search(current)) {
            result.add(current);
        }

        mark[i][j] = true;
        int[][] d = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int k = 0; k < 4; k++) {
            int x = i + d[k][0];
            int y = j + d[k][1];
            dfs(board, current, x, y, mark, trie);
        }
        mark[i][j] = false;
    }

    class TrieNode {
        int num; // How many words go through this TrieNode
        TrieNode[] son; // Collection of sons
        boolean isEnd;
        char val;
        
        public TrieNode() {
            this.num = 0;
            this.son = new TrieNode[26];
            this.isEnd = false;
        }
    }

    class Trie {
        private TrieNode root;
    
        public Trie() {
            root = new TrieNode();
        }
    
        // Inserts a word into the trie.
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }

            char[] cWords = word.toCharArray();
            TrieNode node = this.root;
            for (int i = 0; i < cWords.length; i++) {
                int pos = (int)(cWords[i] - 'a');
                if (node.son[pos] == null) {
                    node.son[pos] = new TrieNode();
                    node.son[pos].num++;
                    node.son[pos].val = cWords[i];
                }
                else {
                    node.son[pos].num++;
                }
                node = node.son[pos];
            }
            node.isEnd = true;
        }
    
        // Returns if the word is in the trie.
        public boolean search(String word) {
            char[] cWords = word.toCharArray();
            TrieNode node = this.root;
            for (int i = 0; i < cWords.length; i++) {
                int pos = (int)(cWords[i] - 'a');
                if (node.son[pos] == null) {
                    return false;
                }
                node = node.son[pos];
            }
            return node.isEnd;
        }
    
        // Returns if there is any word in the trie that starts with the given prefix.
        public boolean startsWith(String prefix) {
            char[] cWords = prefix.toCharArray();
            TrieNode node = this.root;
            for (int i = 0; i < cWords.length; i++) {
                int pos = (int)(cWords[i] - 'a');
                if (node.son[pos] == null) {
                    return false;
                }
                node = node.son[pos];
            }
            return true;
        }
    }
}

