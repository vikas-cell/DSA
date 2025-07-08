class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        // code here
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int key = arr[i];
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }
            else map.put(key,1);
        }
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            while(st.size()>0 && map.get(st.peek())<=map.get(arr[i])){
                st.pop();
            }
            if(st.size()==0) al.add(-1);
            else al.add(st.peek());
            
            st.push(arr[i]);
        }
        Collections.reverse(al);
        return al;
    }
}