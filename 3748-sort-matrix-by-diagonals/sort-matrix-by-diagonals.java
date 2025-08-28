class Solution {
    public int[][] sortMatrix(int[][] grid) { 
        int n = grid.length;
        int count = 1;

        while(count<n){
            ArrayList<Integer> al = new ArrayList<>();
            int i=0;int j=count;
            while(i<n && j<n){
                al.add(grid[i][j]);
                i++; j++;
            }
            Collections.sort(al);
            i=0;j=count; int k = 0;
            while(i<n && j<n){
                grid[i][j] = al.get(k++);
                i++; j++;
            }
            count++;
        }
        
        count = 0;
        while(count<n){
            ArrayList<Integer> al = new ArrayList<>();
            int i=count;int j=0;
            while(i<n && j<n){
                al.add(grid[i][j]);
                i++; j++;
            }
            Collections.sort(al);
            i=count; j=0;int k=al.size()-1;

            while(i<n && j<n){
                grid[i][j] = al.get(k--);
                i++;j++;
            }
            count++;
        }

       return grid;
    }
}