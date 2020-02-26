package DP;

public class PaintHousetwo {
    public static void main(String[] args) {
        System.out.println(painthouse(new int [][]{{14,2,11},{11,14,5},{14,3,10}}));
        System.out.println(painthouse(new int [][]{}));
    }
    /*
    还可以优化
    如下：


     */


    public static int painthouse(int[][] cost) {
        if (cost==null||cost.length==0){
            return 0;
        }
        int m = cost.length;
        int n=cost[0].length;
        int[][] f = new int[m + 1][n];
        if (m == 0) {
            return 0;
        }
        for (int i = 0; i <n ; i++) {
            f[0][i]=0;
        }
     //   f[0][0] = f[0][1] = f[0][2] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) { //j is the color of house i-1
                f[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {  //k is the color of house i-2
                    if (j==k){
                        continue;
                    }
                    if (f[i-1][k]+cost[i-1][j]<f[i][j]){
                        f[i][j]  = f[i-1][k]+cost[i-1][j];
                    }

                }

            }
        }
        int min=0;
        min=f[m][0];
        for (int i = 0; i <n-1 ; i++) {

             min = Math.min(min, f[m][i + 1]);
        }
        return min;

    }
}
