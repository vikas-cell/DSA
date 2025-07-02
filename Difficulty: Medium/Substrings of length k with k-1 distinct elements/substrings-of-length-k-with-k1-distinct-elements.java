class Solution {
    public int substrCount(String s, int k) {
        // code here
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        for(int i=0;i<k;i++){
            char key = s.charAt(i);
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }
            else map.put(key,1);
        }
        int count = 0;
        int i = 0;
        int j = k;
        if(map.size()==(k-1)) count++;
        while(j<n){
            int freq = map.get(s.charAt(i));
            if(freq==1) map.remove(s.charAt(i));
            else map.put(s.charAt(i),freq-1);
            
            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j),map.get(s.charAt(j))+1);
            }
            else map.put(s.charAt(j),1);
            if(map.size()==(k-1)) count++;
            i++;
            j++;
        }
        return count;
    }
}