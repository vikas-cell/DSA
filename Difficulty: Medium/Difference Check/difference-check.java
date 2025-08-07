class Solution {
    public int minDifference(String[] arr) {
        // code here
        int n = arr.length;
        int [] nums = new int[n];
        
        for(int i=0;i<n;i++){
            String str = arr[i];
            String h = str.substring(0,2);
            String m = str.substring(3,5);
            String s = str.substring(6,8);
            
            int hr = Integer.parseInt(h)*60*60;
            int min = Integer.parseInt(m)*60;
            int sec = Integer.parseInt(s);
            
            nums[i] = hr+min+sec;
        }
        
        
        int mid = 60*60*24;
        Arrays.sort(nums);
        int ans = mid;
        
        for(int i=1;i<n;i++){
            int diff = nums[i]-nums[i-1];
            ans = Math.min(ans,diff);
            ans = Math.min(ans,(mid-nums[i])+nums[0]);
        }
        
        return ans;
    }
}
