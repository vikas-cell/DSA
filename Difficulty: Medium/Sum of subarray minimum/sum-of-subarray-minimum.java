class Solution {
    public int sumSubMins(int[] arr) {
        // code here
        int n = arr.length;
        int [] nse = new int[n];
        int [] pse = new int[n];
        
        Stack<Integer> st = new Stack<>();
        nse[n-1] = n;
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]>=arr[i]) st.pop();
            if(st.size()==0) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }
        
        while(st.size()>0) st.pop();
        
        pse[0] = -1;
        st.push(0);
        
        for(int i=1;i<n;i++){
            while(st.size()>0 && arr[st.peek()]>arr[i]) st.pop();
            if(st.size()==0) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }
        // for(int i=0;i<n;i++) System.out.println(nse[i]+" "+pse[i]);
        int ans = 0;
        for(int i=0;i<n;i++){
            int left = i-pse[i];
            int right = nse[i]-i;
            ans = ans + (left*right*arr[i]);
            
            // System.out.print();
        }
        return ans;
    }
}
