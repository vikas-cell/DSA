class Solution {
    public List<Integer> majorityElement(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            int elem = arr[i];
            if(map.containsKey(arr[i])){
                map.put(elem,map.get(elem)+1);
            }
            else map.put(elem,1);
        }
        
        for(int key:map.keySet()){
            int freq = map.get(key);
            if(freq>n/3) al.add(key);
        }
        Collections.sort(al);
        return al;
    }
}