class Solution {
    public static int balanceSums(int[][] mat) {
        // code here
        int n = mat.length;
        int max = Integer.MIN_VALUE;
        int [] col = new int[n];
        int [] row = new int[n];
        
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=0;j<n;j++){
                sum  = sum + mat[i][j];
            }
            row[i] = sum;
            max = Math.max(sum,max);
        }
         
        for(int j=0;j<n;j++){
            int sum = 0;
            for(int i=0;i<n;i++){
                sum = sum + mat[i][j];
            }
            col[j] = sum;
            max = Math.max(sum,max);
        }
        
        // for(int i=0;i<n;i++) {
        //     System.out.print(col[i]+" ");
        // }
        // for(int i=0;i<n;i++) {
        //     System.out.print(row[i]+" ");
        // }
        
        int rowsum = 0; int colsum = 0;
        for(int i=0;i<n;i++){ 
            rowsum = rowsum+Math.abs(max-row[i]);
            colsum = colsum+Math.abs(max-col[i]);
        }
        
        return Math.max(rowsum,colsum);
    }
}