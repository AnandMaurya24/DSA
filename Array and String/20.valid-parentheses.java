/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (40.22%)
 * Likes:    25075
 * Dislikes: 1845
 * Total Accepted:    5.6M
 * Total Submissions: 13.3M
 * Testcase Example:  '"()"'
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "()"
 * 
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "()[]{}"
 * 
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "(]"
 * 
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "([])"
 * 
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {

        Stack<Character> st=new Stack<>();
        int i=0;
        int n=s.length();
        while(i<n){
            char ch=s.charAt(i);
            if(st.size()!=0 && st.peek()=='(' && ch==')'){
                st.pop();
            }else if(st.size()!=0 && st.peek()=='{' && ch=='}'){
                st.pop();
            }else if (st.size()!=0 && st.peek()=='[' && ch==']'){
                st.pop();
            }else{
                st.push(ch);
            }
            i++;
        }
        return st.size()==0;
    }
        
}
// @lc code=end

