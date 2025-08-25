class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i=0;i<(m+n);i++) al.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int idx = (i+j);
                al.get(idx).add(mat[i][j]);
            }
        }
        int [] ans = new int[m*n];
        int idx = 0;

        for(int i=0;i<(m+n);i++){
            if(i%2==0){
                for(int j=al.get(i).size()-1;j>=0;j--){
                    ans[idx++] = al.get(i).get(j);
                }
            }
            else{
                for(int j=0;j<al.get(i).size();j++){
                    ans[idx++] = al.get(i).get(j);
                }
            }
        }
        return ans;
    }
}