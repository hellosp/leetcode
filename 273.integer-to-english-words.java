/*
 * @lc app=leetcode id=273 lang=java
 *
 * [273] Integer to English Words
 *
 * https://leetcode.com/problems/integer-to-english-words/description/
 *
 * algorithms
 * Hard (24.41%)
 * Likes:    542
 * Dislikes: 1488
 * Total Accepted:    104.8K
 * Total Submissions: 429.1K
 * Testcase Example:  '123'
 *
 * Convert a non-negative integer to its english words representation. Given
 * input is guaranteed to be less than 2^31 - 1.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * 
 * Example 3:
 * 
 * 
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty
 * Seven"
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty
 * Seven Thousand Eight Hundred Ninety One"
 * 
 * 
 */
class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder builder = new StringBuilder();

        int b = num / 1000000000;
        num %= 1000000000;
        if (b > 0) {
            builder.append(getNumWords(b)).append(" ").append("Billion");
            if (num > 0) {
                builder.append(" ");
            }
        }

        int m = num / 1000000;
        num %= 1000000;
        if (m > 0) {
            builder.append(getNumWords(m)).append(" ").append("Million");
            if (num > 0) {
                builder.append(" ");
            }
        }

        int t = num / 1000;
        num %= 1000;
        if (t > 0) {
            builder.append(getNumWords(t)).append(" ").append("Thousand");
            if (num > 0) {
                builder.append(" ");
            }
        }

        if (num > 0) {
            builder.append(getNumWords(num));
        }
        return builder.toString();
    }

    private String getNumWords(int num) {
        StringBuilder builder = new StringBuilder();

        int h = num / 100;
        num %= 100;
        if (h > 0) {
            builder.append(getDigitalWord(h)).append(" ").append("Hundred");
            if (num > 0) {
                builder.append(" ");
            }
        }

        int t = num / 10;
        if (t == 1) {
            builder.append(getTensWord(num));
        } else if (t >= 2) {
            builder.append(getDecadeWord(t));

            num %= 10;
            if (num > 0) {
                builder.append(" ").append(getDigitalWord(num));
            }
        } else {
            if (num > 0) {
                builder.append(getDigitalWord(num));
            }
        }
        return builder.toString();
    }

    private String getDigitalWord(int num) {
        String[] dict = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        if (num >= 1 && num <= 9) {
            return dict[num - 1];
        }
        return "";
    }

    private String getDecadeWord(int num) {
        String[] dict = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        if (num >= 2 && num <= 9) {
            return dict[num - 2];
        }
        return "";
    }

    private String getTensWord(int num) {
        String[] dict = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        if (num >= 10 && num <= 19) {
            return dict[num - 10];
        }
        return "";
    }
}

