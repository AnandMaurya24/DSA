/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (44.82%)
 * Likes:    18825
 * Dislikes: 782
 * Total Accepted:    1.7M
 * Total Submissions: 3.8M
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given two strings s and t of lengths m and n respectively, return the
 * minimum window substring of s such that every character in t (including
 * duplicates) is included in the window. If there is no such substring, return
 * the empty string "".
 * 
 * The testcases will be generated such that the answer is unique.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
 * from string t.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 10^5
 * s and t consist of uppercase and lowercase English letters.
 * 
 * 
 * 
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 * 
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int si = 0, ei = 0, nt= t.length(), ns = s.length();

        int[] freq = new int[128];
        int i=0, count = nt, len = (int)1e8, head = 0;
        while(i<nt) freq[t.charAt(i++)]++;

        while(ei< ns){

            if(freq[s.charAt(ei++)]-->0) count --;

            while(count == 0){
                if (ei-si<len) len = (ei-(head = si));

                if(freq[s.charAt(si++)]++ == 0) count++;
            }
        }

        return len == (int)1e8?"":s.substring(head,head+len);
        
        
    }
}
// @lc code=end

