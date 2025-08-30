class Solution {
    public static String smallestWindow(String s, String p) {
        // code here
        if(s.length()<p.length()) return "";
        
        int [] freqp = new int[26];
        for(char c:p.toCharArray()) freqp[c-'a']++;
        
        int [] freqs = new int[26];
        int start = 0; int minlen = Integer.MAX_VALUE; int startindex = -1;
        int count = 0;
        
        for(int end=0;end<s.length();end++){
            char c = s.charAt(end);
            freqs[c-'a']++;
            
            if(freqp[c-'a']>0 && freqs[c-'a']<=freqp[c-'a']) count++;
            
            while(count==p.length()){
                if(end-start+1<minlen){
                    minlen = end-start+1;
                    startindex=start;
                }
            
            char leftChar = s.charAt(start);
            freqs[leftChar-'a']--;
            if(freqp[leftChar-'a']>0 && freqs[leftChar-'a']<freqp[leftChar-'a']) count--;
            start++;
            }
        }
        if(startindex==-1) return "";
        return s.substring(startindex,startindex+minlen);
    }
}