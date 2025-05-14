/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (45.05%)
 * Likes:    23085
 * Dislikes: 748
 * Total Accepted:    1.7M
 * Total Submissions: 3.8M
 * Testcase Example:  '[1,1,1]\n2'
 *
 * Given an array of integers nums and an integer k, return the total number of
 * subarrays whose sum equals to k.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an
 * array.
 * 
 * 
 * Example 1:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 * 
 * 
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {

        int count=0,sum=0;
         HashMap<Integer,Integer> map=new HashMap<>();
         map.put(0,1);
         for(int i=0;i<nums.length;i++){
             sum+=nums[i];
             
             count+=map.getOrDefault(sum-k,0);
             map.put(sum,map.getOrDefault(sum,0)+1);
         }
         return count;
         
     }
}
// @lc code=end

