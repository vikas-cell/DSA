class Solution {
    public int minValue(String s, int k) {
        // code here
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            char key = s.charAt(i);
            if(map.containsKey(key)) map.put(key,map.get(key)+1);
            else map.put(key,1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(char ch:map.keySet()){
            int i = map.get(ch);
            pq.offer(i);
        }
        while(k>0){
            int freq = pq.remove();
            pq.offer(freq-1);
            k--;
        }
        
        int ans = 0;
        while(pq.size()>0){
            int val = pq.poll();
            ans +=val*val;
        }
        return ans;
    }
}