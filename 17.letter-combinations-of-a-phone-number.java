/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (41.27%)
 * Total Accepted:    379.3K
 * Total Submissions: 918.7K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
class Solution {
    Map<String, String> map = new HashMap<String, String>() {{
        put("0", "");
        put("1", "");
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> result = new ArrayList<>();

    private void backtrack(String combination, String digits) {
        if (digits.length() == 0) {
            result.add(combination);
            return;
        }

        String letters = map.get(digits.substring(0, 1));
        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            backtrack(combination + letter, digits.substring(1));
        }
    }
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() > 0) {
            backtrack("", digits);
        }
        return result;
    }
}
