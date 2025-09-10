class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int ans = 0;
        while(j<n){
           while(set.contains(s.charAt(j))){
            set.remove(s.charAt(i));
            i++;
           }
           set.add(s.charAt(j));
           ans = Math.max(ans,j-i+1);
           j++;
        }
        return ans;
    }
}