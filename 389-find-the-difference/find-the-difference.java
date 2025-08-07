class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length()==0) return t.charAt(0);
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)) map.put(ch,map.get(ch)+1);
            else map.put(ch,1);
        }

        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(mp.containsKey(ch)) mp.put(ch,mp.get(ch)+1);
            else mp.put(ch,1);
        }

        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(!map.containsKey(ch)) return ch;
            else{
                if(map.get(ch)!=mp.get(ch)) return ch;
            }
        }
        return 'a';
    }
}