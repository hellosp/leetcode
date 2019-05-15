/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 *
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 *
 * algorithms
 * Hard (23.47%)
 * Total Accepted:    130.7K
 * Total Submissions: 556.5K
 * Testcase Example:  '"barfoothefoobarman"\n["foo","bar"]'
 *
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * ⁠ s = "barfoothefoobarman",
 * ⁠ words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar"
 * respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * ⁠ s = "wordgoodgoodgoodbestword",
 * ⁠ words = ["word","good","best","word"]
 * Output: []
 * 
 * 
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) {
            return result;
        }
        
        HashMap<String, Integer> wordsMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (wordsMap.containsKey(words[i])) {
                wordsMap.put(words[i], wordsMap.get(words[i]) + 1);
            } else {
                wordsMap.put(words[i], 1);
            }
        }
        
        HashMap<String, Integer> sMap = new HashMap<>();
        for (int i = 0; i < words[0].length(); i++) {
            int count = 0;
            int j = i, start = i;
            int step = words[0].length();
            sMap.clear();
            
            while (j <= s.length() - step) {
                String tmpWord = s.substring(j, j + step);
                if (wordsMap.containsKey(tmpWord)) {
                    if (sMap.containsKey(tmpWord)) {
                        sMap.put(tmpWord, sMap.get(tmpWord) + 1);
                    } else {
                        sMap.put(tmpWord, 1);
                    }
                    
                    if (sMap.get(tmpWord) <= wordsMap.get(tmpWord)) {
                        count++;
                    } else {
                        while (sMap.get(tmpWord) > wordsMap.get(tmpWord)) {
                            String startWord = s.substring(start, start + step);
                            if (sMap.containsKey(startWord)) {
                                sMap.put(startWord, sMap.get(startWord) - 1);
                            }
                            if (sMap.get(startWord) < wordsMap.get(startWord)) {
                                count--;
                            }
                            start += step;
                        }
                    }
                    
                    if (count == words.length) {
                        result.add(start);
                        
                        String startWord = s.substring(start, start + step);
                        if (sMap.containsKey(startWord)) {
                            sMap.put(startWord, sMap.get(startWord) - 1);
                        }
                        count--;
                        start += step;
                    }
                    j += step;
                } else {
                    sMap.clear();
                    j += step;
                    start = j;
                    count = 0;
                }
            }
        }
        return result;
    }
}
