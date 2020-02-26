package DP;

public class CopyBooks {
    public static void main(String[] args) {

    }
    public static int copyBooks(int[] pages, int k) {
        // write your code here
        if (pages==null||pages.length==0){
            return 0;
        }

        int m = pages.length;
        if (k>m){
           m=k;
        }
        int[][] f = new int[k + 1][m + 1];
        for (int i = 1; i <= m; i++) {
            f[0][i]=Integer.MAX_VALUE;
        }
        for (int i = 0; i <=k; i++) {
            f[i][0]=0;
        }
        int sum=0;//体会这么做的好处
        for (int i = 1; i <= k ; i++) {
            for (int j = 1; j <= m ; j++) {
                f[i][j]=Integer.MAX_VALUE;
                sum=0;
                for (int l = j; l>=0 ; l--) {
                    f[i][j]=Math.min(f[i][j],Math.max(f[i-1][l],sum));
                  if (l>0){
                      sum+=pages[l-1];
                  }
                }

            }
        }

return f[k][m];

    }
}
