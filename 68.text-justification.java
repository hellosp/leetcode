/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 *
 * https://leetcode.com/problems/text-justification/description/
 *
 * algorithms
 * Hard (23.41%)
 * Likes:    360
 * Dislikes: 1016
 * Total Accepted:    97.8K
 * Total Submissions: 417.7K
 * Testcase Example:  '["This", "is", "an", "example", "of", "text", "justification."]\n16'
 *
 * Given an array of words and a width maxWidth, format the text such that each
 * line has exactly maxWidth characters and is fully (left and right)
 * justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly maxWidth characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * 
 * Note:
 * 
 * 
 * A word is defined as a character sequence consisting of non-space characters
 * only.
 * Each word's length is guaranteed to be greater than 0 and not exceed
 * maxWidth.
 * The input array words contains at least one word.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall
 * be",
 * because the last line must be left-justified instead of fully-justified.
 * ⁠            Note that the second line is also left-justified becase it
 * contains only one word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * words =
 * ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 * "Science  is  what we",
 * ⁠ "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 * 
 * 
 */
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int index = 0;
        while (index < words.length) {
            int last = index, totalLen = 0, wordLen = 0;
            for (; last < words.length; last++) {
                totalLen += words[last].length() + 1;
                if (totalLen - 1 > maxWidth) {
                    break;
                }
                wordLen += words[last].length();
            }

            StringBuilder builder = new StringBuilder();
            int count = last - index - 1;
            if (last == words.length || count == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i] + " ");
                }
                builder.deleteCharAt(builder.length() - 1);
                for (int i = builder.length(); i < maxWidth; i++) {
                    builder.append(" ");
                }
            } else {
                int space = (maxWidth - wordLen) / count;
                int extra = (maxWidth - wordLen) % count;
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i != last - 1) {
                        int n = (i - index) < extra ? space + 1 : space;
                        for (int j = 0; j < n; j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            result.add(builder.toString());
            index = last;
        }
        return result;
    }
}

