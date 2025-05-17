class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int si=0,ei=0;
        
        int[] arr=new int[128];
        
        int n=s.length();
        int count=0;
        int maxLength=(int)-1e8;
        if(s.length()<=1) return s.length();
        while(ei<n){
            if(arr[s.charAt(ei++)]++>0) count++;
            
            while(count>0)
                if(arr[s.charAt(si++)]-->1) count--;
            
            maxLength=Math.max(maxLength,ei-si);
        }
        return maxLength;
        
    }
}