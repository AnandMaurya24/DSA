/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Medium (50.27%)
 * Likes:    34994
 * Dislikes: 1483
 * Total Accepted:    4.6M
 * Total Submissions: 8.8M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the subarray with the largest sum, and
 * return its sum.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 * 
 */

// @lc code=start
//Kadanes algorithm
class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];

        int i=1;
        while(i < nums.length){
            currSum = Math.max(nums[i],nums[i]+currSum);
            maxSum = Math.max(maxSum,currSum);
            i++;
        }

        return maxSum;
        
    }
}
// @lc code=end

