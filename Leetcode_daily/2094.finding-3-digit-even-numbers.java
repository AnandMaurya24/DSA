package Leetcode_daily;
/*
 * @lc app=leetcode id=2094 lang=java
 *
 * [2094] Finding 3-Digit Even Numbers
 *
 * https://leetcode.com/problems/finding-3-digit-even-numbers/description/
 *
 * algorithms
 * Easy (63.52%)
 * Likes:    1251
 * Dislikes: 311
 * Total Accepted:    126.5K
 * Total Submissions: 163.2K
 * Testcase Example:  '[2,1,3,0]'
 *
 * You are given an integer array digits, where each element is a digit. The
 * array may contain duplicates.
 * 
 * You need to find all the unique integers that follow the given
 * requirements:
 * 
 * 
 * The integer consists of the concatenation of three elements from digits in
 * any arbitrary order.
 * The integer does not have leading zeros.
 * The integer is even.
 * 
 * 
 * For example, if the given digits were [1, 2, 3], integers 132 and 312 follow
 * the requirements.
 * 
 * Return a sorted array of the unique integers.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: digits = [2,1,3,0]
 * Output: [102,120,130,132,210,230,302,310,312,320]
 * Explanation: All the possible integers that follow the requirements are in
 * the output array. 
 * Notice that there are no odd integers or integers with leading zeros.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: digits = [2,2,8,8,2]
 * Output: [222,228,282,288,822,828,882]
 * Explanation: The same digit can be used as many times as it appears in
 * digits. 
 * In this example, the digit 8 is used twice each time in 288, 828, and
 * 882. 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: digits = [3,7,5]
 * Output: []
 * Explanation: No even integers can be formed using the given digits.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 3 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> nums = new HashSet<>();
        int n = digits.length;
        // Traverse the indices of three digits
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    // Determine whether it meets the condition of the target even number
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num >= 100 && num % 2 == 0) {
                        nums.add(num);
                    }
                }
            }
        }
        // Converted to an array sorted in ascending order
        List<Integer> res = new ArrayList<>(nums);
        Collections.sort(res);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            result[i] = res.get(i);
        }
        return result;
    }
}
// @lc code=end

