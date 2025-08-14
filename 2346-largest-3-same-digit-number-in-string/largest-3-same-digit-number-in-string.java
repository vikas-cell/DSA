class Solution {
    public String largestGoodInteger(String s) {
       int num = Integer.MIN_VALUE;
       int n = s.length();
    //    if(n==3 && s.charAt(0)==s.charAt(1) && s.charAt(1)==s.charAt(2)) return s;
       for(int i=0;i<n-2;i++){
        if(s.charAt(i)==s.charAt(i+1) && s.charAt(i+1)==s.charAt(i+2)){
            int n1 = s.charAt(i)-'0';
            num = Math.max(n1,num);
        }
       }
       if(num==Integer.MIN_VALUE) return "";
       String ans = "";
       String ss = Integer.toString(num);
       ans = ans+ss;
       ans = ans+ss;
       ans = ans+ss;

       return ans;
    }
}