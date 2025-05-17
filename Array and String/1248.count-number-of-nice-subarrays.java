/*
 * @lc app=leetcode id=1248 lang=java
 *
 * [1248] Count Number of Nice Subarrays
 *
 * https://leetcode.com/problems/count-number-of-nice-subarrays/description/
 *
 * algorithms
 * Medium (72.55%)
 * Likes:    4926
 * Dislikes: 128
 * Total Accepted:    346.6K
 * Total Submissions: 475.6K
 * Testcase Example:  '[1,1,2,1,1]\n3'
 *
 * Given an array of integers nums and an integer k. A continuous subarray is
 * called nice if there are k odd numbers on it.
 * 
 * Return the number of nice sub-arrays.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and
 * [1,2,1,1].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There are no odd numbers in the array.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numberOfSubarraysatMost(int[] nums, int k) {
        
        int si=0,ei=0,n=nums.length,count=0;
        int oddCount=0;
        while(ei<n){
            if(nums[ei++]%2!=0) oddCount++;
            
            while(oddCount>k){
                
                if(nums[si++]%2!=0) oddCount--;
                
            }
            count+=ei-si;
        }
        
        return count;
    }
   public int numberOfSubarrays(int[] nums, int k) {
        
        int n=nums.length;
        
        if(n==0) return 0;
        
        return numberOfSubarraysatMost(nums,k)-numberOfSubarraysatMost(nums,k-1);
    }
}
// @lc code=end

