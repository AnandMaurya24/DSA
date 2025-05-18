/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 *
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/
 *
 * algorithms
 * Medium (65.41%)
 * Likes:    9418
 * Dislikes: 162
 * Total Accepted:    974K
 * Total Submissions: 1.5M
 * Testcase Example:  '[1,1,1,0,0,0,1,1,1,1,0]\n2'
 *
 * Given a binary array nums and an integer k, return the maximum number of
 * consecutive 1's in the array if you can flip at most k 0's.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is
 * underlined.
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is
 * underlined.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * nums[i] is either 0 or 1.
 * 0 <= k <= nums.length
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {

        int ei = 0, si = 0, zeroCount = 0, len = 0;

        while(ei<nums.length){

            if(nums[ei++]==0) zeroCount++;

            while(zeroCount>k) {
                if(nums[si++] == 0) zeroCount--;

            }

            len = Math.max(len,ei-si);
        }

        return len;
        
    }
}
// @lc code=end

