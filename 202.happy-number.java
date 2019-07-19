import java.util.Set;

/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 *
 * https://leetcode.com/problems/happy-number/description/
 *
 * algorithms
 * Easy (45.40%)
 * Likes:    870
 * Dislikes: 222
 * Total Accepted:    236.9K
 * Total Submissions: 521.9K
 * Testcase Example:  '19'
 *
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 
 * 
 * 
 * Input: 19
 * Output: true
 * Explanation: 
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 
 */
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        do {
            n = calSumNum(n);
            if (!set.add(n)) {
                return false;
            }
        } while (n != 1);

        return true;
    }

    private int calSumNum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += Math.pow((num % 10), 2);
            num /= 10;
        }
        return sum;
    }
}

