class Solution {
    public int countBalanced(String[] arr) {
        // code here
        int n = arr.length;
        int [] freq = new int[n];
        
        for(int i=0;i<n;i++){
            int m = arr[i].length();
            int v = vowels(arr[i]);
            int c = m-v;
            freq[i] = v-c;
        }
        
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        
        for(int i=0;i<n;i++){
            sum = sum+freq[i];
            
            if(map.containsKey(sum)){
                ans = ans+map.get(sum);
                map.put(sum,map.get(sum)+1);
            }
            else map.put(sum,1);
        }
     
        return ans;
    }
    
    public int vowels(String str){
        int count= 0;
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i'|| ch=='o' || ch=='u') count++;
        }
        return count;
    }
}