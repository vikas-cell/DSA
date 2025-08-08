class Solution {
    int maxLength(int arr[]) {
        // code here
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int sum = 0;
        int ans = 0;
        
        for(int i=0;i<n;i++){
            sum = sum+arr[i];
            
            if(sum==0) ans = i+1;
            else{
                if(map.containsKey(sum)){
                    ans = Math.max(ans,i-map.get(sum));
                }
                else map.put(sum,i);
            }
        }
        return ans;
    }
}