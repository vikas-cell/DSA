class Solution {
    int lo ,max;
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n<2) return s;
        for(int i=0;i<n-1;i++){
            helper(s,i,i);
            helper(s,i,i+1);
        }
        return s.substring(lo,lo+max);
    }
    public void helper(String s,int j,int k){
        while(j>=0 && k<s.length() && s.charAt(j)==s.charAt(k)){
            j--;
            k++;
        }
        if(max<k-j-1){
            lo = j+1;
            max = k-j-1;
        }
    }
}