package Leetcode_daily;
/*
 * @lc app=leetcode id=3335 lang=java
 *
 * [3335] Total Characters in String After Transformations I
 *
 * https://leetcode.com/problems/total-characters-in-string-after-transformations-i/description/
 *
 * algorithms
 * Medium (26.31%)
 * Likes:    461
 * Dislikes: 33
 * Total Accepted:    81K
 * Total Submissions: 185.5K
 * Testcase Example:  '"abcyy"\n2'
 *
 * You are given a string s and an integer t, representing the number of
 * transformations to perform. In one transformation, every character in s is
 * replaced according to the following rules:
 * 
 * 
 * If the character is 'z', replace it with the string "ab".
 * Otherwise, replace it with the next character in the alphabet. For example,
 * 'a' is replaced with 'b', 'b' is replaced with 'c', and so on.
 * 
 * 
 * Return the length of the resulting string after exactly t transformations.
 * 
 * Since the answer may be very large, return it modulo 10^9 + 7.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abcyy", t = 2
 * 
 * Output: 7
 * 
 * Explanation:
 * 
 * 
 * First Transformation (t = 1):
 * 
 * 
 * 'a' becomes 'b'
 * 'b' becomes 'c'
 * 'c' becomes 'd'
 * 'y' becomes 'z'
 * 'y' becomes 'z'
 * String after the first transformation: "bcdzz"
 * 
 * 
 * Second Transformation (t = 2):
 * 
 * 'b' becomes 'c'
 * 'c' becomes 'd'
 * 'd' becomes 'e'
 * 'z' becomes "ab"
 * 'z' becomes "ab"
 * String after the second transformation: "cdeabab"
 * 
 * 
 * Final Length of the string: The string is "cdeabab", which has 7
 * characters.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "azbk", t = 1
 * 
 * Output: 5
 * 
 * Explanation:
 * 
 * 
 * First Transformation (t = 1):
 * 
 * 
 * 'a' becomes 'b'
 * 'z' becomes "ab"
 * 'b' becomes 'c'
 * 'k' becomes 'l'
 * String after the first transformation: "babcl"
 * 
 * 
 * Final Length of the string: The string is "babcl", which has 5
 * characters.
 * 
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s consists only of lowercase English letters.
 * 1 <= t <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    private static final int MOD = 1000000007;

    public int lengthAfterTransformations(String s, int t) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            ++cnt[ch - 'a'];
            System.out.println(ch - 'a');
        }
        System.out.println(cnt.toString());
        for (int round = 0; round < t; ++round) {
            int[] nxt = new int[26];
            nxt[0] = cnt[25];
            nxt[1] = (cnt[25] + cnt[0]) % MOD;
            for (int i = 2; i < 26; ++i) {
                nxt[i] = cnt[i - 1];
            }
            cnt = nxt;
        }
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            ans = (ans + cnt[i]) % MOD;
        }
        return ans;
    }
}
// @lc code=end

