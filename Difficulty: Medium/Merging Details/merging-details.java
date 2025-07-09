// User function Template for Java

class Solution {
    public static int [] size;
    public static int [] parent;
    
    public static int find(int u){
        if(parent[u]==u) return u;
        return parent[u] = find(parent[u]);
    }
    
    public static void union(int u,int v){
        int a = find(u);
        int b = find(v);
        
        if(a!=b){
            if(size[a]>size[b]){
                parent[b] = a;
                size[a]+=size[b];
            }
            else{
                parent[a] = b;
                size[b]+=size[a];
            }
        }
    }
    public List<List<String>> mergeDetails(List<List<String>> details) {
        // Your code here
        int n = details.size();
        parent = new int[n];
        size = new int[n];
        
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            for(int j=1;j<details.get(i).size();j++){
                String mail = details.get(i).get(j);
                if(map.containsKey(mail)){
                    union(i,map.get(mail));
                }
                else map.put(mail,i);
            }
        }
        
        List<List<String>> merge = new ArrayList<>();
        for(int i=0;i<n;i++) merge.add(new ArrayList<>());
        
        for(String key:map.keySet()){
            String mail = key;
            int node = find(map.get(mail));
            merge.get(node).add(mail);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(merge.get(i).size()==0) continue;
            Collections.sort(merge.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(details.get(i).get(0));
            for(int j=0;j<merge.get(i).size();j++){
                temp.add(merge.get(i).get(j));
            }
            ans.add(temp);
        }
        return ans;
    }
}