/*
 * @lc app=leetcode id=385 lang=java
 *
 * [385] Mini Parser
 *
 * https://leetcode.com/problems/mini-parser/description/
 *
 * algorithms
 * Medium (31.87%)
 * Likes:    168
 * Dislikes: 576
 * Total Accepted:    29.8K
 * Total Submissions: 93.5K
 * Testcase Example:  '"324"'
 *
 * Given a nested list of integers represented as a string, implement a parser
 * to deserialize it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be
 * integers or other lists.
 * 
 * Note:
 * You may assume that the string is well-formed:
 * 
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 * 
 * 
 * 
 * Example 1:
 * 
 * Given s = "324",
 * 
 * You should return a NestedInteger object which contains a single integer
 * 324.
 * 
 * 
 * 
 * Example 2:
 * 
 * Given s = "[123,[456,[789]]]",
 * 
 * Return a NestedInteger object containing a nested list with 2 elements:
 * 
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 * ⁠   i.  An integer containing value 456.
 * ⁠   ii. A nested list with one element:
 * ⁠        a. An integer containing value 789.
 * 
 * 
 */
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        char[] data = s.toCharArray();
        Stack<NestedInteger> stack = new Stack<>();

        boolean isParsingNum = false;
        int num = 0, sign = 1;
        NestedInteger integer = null;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == '[') {
                if (integer != null) {
                    stack.push(integer);
                }
                integer = new NestedInteger();
            } else if (data[i] == ']') {
                if (isParsingNum) {
                    integer.add(new NestedInteger(num));
                    isParsingNum = false;
                    num = 0;
                    sign = 1;
                }
                if (!stack.isEmpty()) {
                    stack.peek().add(integer);
                    integer = stack.pop();
                }
            } else if (data[i] == ',') {
                if (isParsingNum) {
                    integer.add(new NestedInteger(num));
                    isParsingNum = false;
                    num = 0;
                    sign = 1;
                }
            } else if (data[i] == '-') {
                isParsingNum = true;
                sign = -1;
            } else if (Character.isDigit(data[i])) {
                isParsingNum = true;
                num = num * 10 + sign * (data[i] - '0');
            }
        }
        return integer;
    }
}

