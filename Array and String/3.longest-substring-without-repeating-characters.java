/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (36.47%)
 * Likes:    41843
 * Dislikes: 2025
 * Total Accepted:    7.3M
 * Total Submissions: 20M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string s, find the length of the longest substring without duplicate
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not
 * a substring.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {

        int si = 0, ei = 0, len = 0;
        int[] arr = new int[128];
        int count = 0;

        if(s.length()<=1) return s.length();
        int n = s.length();
        while(ei < n) {
            if(arr[s.charAt(ei++)]++ > 0) count++;

            while(count>0){
                if(arr[s.charAt(si++)]-- > 1) count--;
            }
             len = Math.max(len,ei-si);

        }
        return len;
        
        
    }
}
// @lc code=end

