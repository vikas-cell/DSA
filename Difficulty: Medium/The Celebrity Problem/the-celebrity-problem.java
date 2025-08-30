class Solution {
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        int [] ans = new int[n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(mat[i][j]==1) ans[i]=1;
                }
            }
        }
        
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(ans[i]==0){
                st.push(i);
            }
        }
        
        while(st.size()>0){
            boolean ispossible = true;
            int elem = st.pop();
            for(int i=0;i<n;i++){
                if(i!=elem){
                    if(mat[i][elem]==0) ispossible = false;
                }
            }
            if(ispossible) return elem;
        }
        
        return -1;
    }
}