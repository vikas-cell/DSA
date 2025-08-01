class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character,Integer> mapv = new HashMap<>();
        HashMap<Character,Integer> mapc = new HashMap<>();
        int n = s.length();
        int maxv = 0; int maxc = 0;

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='a'|| ch=='e'||ch=='i'|| ch=='o'||ch=='u'){
                if(mapv.containsKey(ch)){
                    mapv.put(ch,mapv.get(ch)+1);
                }
                else mapv.put(ch,1);

                maxv = Math.max(maxv,mapv.get(ch));
            }
            else{
                if(mapc.containsKey(ch)){
                    mapc.put(ch,mapc.get(ch)+1);
                }
                else mapc.put(ch,1);

                maxc = Math.max(maxc,mapc.get(ch));
            }
        }
        return maxv+maxc;
    }
}