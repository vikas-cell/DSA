class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double [] prob = new double[n+1];
        prob[0] = 1;
        double currsum = 1.0;
        if(k==0) currsum = 0.0;

        for(int i=1;i<=n;i++){
            prob[i] = currsum/maxPts;

            if(i<k) currsum +=prob[i];

            if(i-maxPts>=0 && i-maxPts<k) currsum -=prob[i-maxPts]; 
        }

        double ans = 0.0;
        for(int i=k;i<=n;i++) ans = ans+prob[i];
        return ans;
    }
}