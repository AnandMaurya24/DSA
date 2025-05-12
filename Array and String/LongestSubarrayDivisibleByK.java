import java.util.HashMap;
// https://www.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1
public class LongestSubarrayDivisibleByK {
       int longestSubarrayDivK(int[] arr, int k) {
        // Complete the function
        HashMap<Integer,Integer> map = new HashMap<>();
        int i =0, sum = 0, len =0;
        map.put(0,-1);
        while(i<arr.length){
            sum+=arr[i];
            int mod = (sum%k+ k)%k;
            if(map.containsKey(mod)) len = Math.max(len,i-map.get(mod));
            else map.put(mod,i);
            i++;
        }
        return len;
    }

}
