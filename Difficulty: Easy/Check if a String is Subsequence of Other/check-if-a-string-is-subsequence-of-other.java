class Solution {
    public boolean isSubSeq(String s1, String s2) {
        // code here
        int n1 = s1.length();
        int n2 = s2.length();
        
        int i=0; int j=0;
        while(i<n1 && j<n2){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
            }
            j++;
        }
        if(i==n1) return true;
        return false;
    }
}