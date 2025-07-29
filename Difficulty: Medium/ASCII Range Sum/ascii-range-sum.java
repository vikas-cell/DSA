class Solution {
    public ArrayList<Integer> asciirange(String s) {
        // code here
        int [] first = new int[26];
        int [] last = new int[26];
        Arrays.fill(first,-1);
        Arrays.fill(last,-1);
        int n = s.length();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            int idx = (int)ch-'a';
            
            if(first[idx]==-1){
                first[idx] = i;
            }
            last[idx] = i;
        }
        
        for(int i=0;i<26;i++){
            int sum = 0;
            
            if(first[i]!=-1 && last[i]!=-1 && first[i]<last[i]){
                for(int j=first[i]+1;j<last[i];j++){
                    sum = sum+(int)s.charAt(j);
                }
            }
            
            if(sum>0){
                ans.add(sum);
            }
        }
        return ans;
    }
}