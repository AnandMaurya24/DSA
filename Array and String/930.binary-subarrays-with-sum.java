/*
 * @lc app=leetcode id=930 lang=java
 *
 * [930] Binary Subarrays With Sum
 *
 * https://leetcode.com/problems/binary-subarrays-with-sum/description/
 *
 * algorithms
 * Medium (65.26%)
 * Likes:    4314
 * Dislikes: 144
 * Total Accepted:    357.8K
 * Total Submissions: 544.8K
 * Testcase Example:  '[1,0,1,0,1]\n2'
 *
 * Given a binary array nums and an integer goal, return the number of
 * non-empty subarrays with a sum goal.
 * 
 * A subarray is a contiguous part of the array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,0,1,0,1], goal = 2
 * Output: 4
 * Explanation: The 4 subarrays are bolded and underlined below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,0,0,0,0], goal = 0
 * Output: 15
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 3 * 10^4
 * nums[i] is either 0 or 1.
 * 0 <= goal <= nums.length
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] freq = new int[300001];
        int count = 0, ei = 0, n = nums.length, psum = 0;
        freq[0] = 1;
        while(ei<n){
            psum +=nums[ei++];

            if(psum-goal>=0) count+= freq[psum-goal];
            freq[psum]++;
        }
        return count;
    }
}
// @lc code=end

