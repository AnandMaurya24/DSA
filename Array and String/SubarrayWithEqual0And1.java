// https://www.geeksforgeeks.org/problems/count-subarrays-with-equal-number-of-1s-and-0s-1587115620/1?

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithEqual0And1 {
     // Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
        // add your code here
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0, count = 0, i = 0;
        map.put(0,1);
        while(i<n){
            int val = arr[i++];
            if(val == 0) val = -1;
            sum+= val;
            count+=map.getOrDefault(sum,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
            
        }
        return count;
    }
    
}
