/*
 * @lc app=leetcode id=1191 lang=java
 *
 * [1191] K-Concatenation Maximum Sum
 *
 * https://leetcode.com/problems/k-concatenation-maximum-sum/description/
 *
 * algorithms
 * Medium (24.11%)
 * Likes:    1476
 * Dislikes: 125
 * Total Accepted:    39.1K
 * Total Submissions: 161.6K
 * Testcase Example:  '[1,2]\n3'
 *
 * Given an integer array arr and an integer k, modify the array by repeating
 * it k times.
 * 
 * For example, if arr = [1, 2] and k = 3 then the modified array will be [1,
 * 2, 1, 2, 1, 2].
 * 
 * Return the maximum sub-array sum in the modified array. Note that the length
 * of the sub-array can be 0 and its sum in that case is 0.
 * 
 * As the answer can be very large, return the answer modulo 10^9 + 7.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [1,2], k = 3
 * Output: 9
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [1,-2,1], k = 5
 * Output: 2
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: arr = [-1,-2], k = 7
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 10^5
 * 1 <= k <= 10^5
 * -10^4 <= arr[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    long mod = (int)1e9+7;
    public int kadanes(int[] arr){
        int gSum = 0, cSum = 0;

        for(int i = 0; i<arr.length; i++){
            cSum = Math.max(arr[i], cSum + arr[i]);
            gSum = Math.max(gSum, cSum);
        }
        return gSum;
    }
    public int arraySum(int[] arr){
        int sum = 0;

        for(int i = 0;i<arr.length; i++){
            sum+= arr[i];
        }
        return sum;
    }

    public long prefixSum(int[] arr){

        long prefixSum = 0;
        long gSum = -(int)1e9;

        for(int i = 0; i<arr.length; i++){
            prefixSum = (prefixSum+arr[i])%mod;
            gSum = Math.max(prefixSum, gSum);

        }

        return gSum;


    }

    public long suffixSum(int[] arr){

        long suffixSum = 0;
        long gSum = -(int)1e9;

        for(int i = arr.length-1; i>=0 ; i--){
            suffixSum = (suffixSum + arr[i])%mod;
            gSum = Math.max(suffixSum,gSum);
        }

        return gSum;

    }
    public int kConcatenationMaxSum(int[] arr, int k) {

        long max = 0;

        long arraySum = arraySum(arr);
        long pSum = prefixSum(arr);
        long sSum = suffixSum(arr);
        long kadanesSum = kadanes(arr);

        if(k==1){
             max = kadanesSum;
        }
        else if(arraySum>0){
            max = ((k-2)*arraySum + pSum + sSum)%mod;
        }else{
            max = Math.max(pSum + sSum, kadanesSum);
        }
        return (int)max;
    }
}
// @lc code=end

