public class LongestSubStringWithAtmost2DistinctChar159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int si = 0, ei = 0, len = 0;
        int[] arr = new int[128];
        int count = 0;

        if(s.length()<=1) return s.length();
        int n = s.length();
        while(ei < n) {
            if(arr[s.charAt(ei++)]++ == 0) count++;

            while(count>2){
                if(arr[s.charAt(si++)]-- == 1) count--;
            }
             len = Math.max(len,ei-si);

        }
        return len;
        
    }
    public static void main(String[] args) {
        LongestSubStringWithAtmost2DistinctChar159 obj = new LongestSubStringWithAtmost2DistinctChar159();
        String s = "ababacc";
        System.out.println(obj.lengthOfLongestSubstringTwoDistinct(s)); // Output: 3
    }
    
}
