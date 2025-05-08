/*
 * @lc app=leetcode id=1456 lang=java
 *
 * [1456] Maximum Number of Vowels in a Substring of Given Length
 *
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
 *
 * algorithms
 * Medium (59.98%)
 * Likes:    3700
 * Dislikes: 144
 * Total Accepted:    519.3K
 * Total Submissions: 863.1K
 * Testcase Example:  '"abciiidef"\n3'
 *
 * Given a string s and an integer k, return the maximum number of vowel
 * letters in any substring of s with length k.
 * 
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isVowel(char c){
        if(c=='a'||c=='e'|| c=='i' || c=='o' || c=='u') return true;
        return false;
    }
    public int maxVowels(String s, int k) {

        int si=0,ei=0,count=0,vCount = 0, n=s.length();

        while(ei<n){
            if(isVowel(s.charAt(ei))) count++;

            if(ei-si == k-1){
                vCount = Math.max(count,vCount);
                if(isVowel(s.charAt(si++))) count--;
            }
            ei++;
        }

        return vCount;
        
    }
}
// @lc code=end

