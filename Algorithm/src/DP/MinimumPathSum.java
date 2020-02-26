package DP;

public class MinimumPathSum {
    public static void main(String[] args) {

    }
    public static int minoathsum(int mat[][]){
        if (mat.length==0||mat[0].length==0||mat==null){
            return 0;
        }
        int m = mat.length;
        int n = mat[0].length;
        int[][] f = new int[m][n];
        f[0][0]=mat[0][0];
        /*
        f[0][0]=0;
        for (int i = 0; i < m; i++) {
            f[i][0]+=grid[i][0];
        }
        for (int i = 0; i < n; i++) {
            f[0][i]+=grid[0][i];
        }

        这样f【0】【0】重复加了
         */
        for (int i = 1; i < n; i++) {
//  f[i][0]+=grid[i][0];   不对
                f[0][i]=f[0][i-1]+mat[0][i];
            }
        for (int i = 1; i < m; i++) {

                f[i][0]=f[i-1][0]+mat[i][0];

        }


        for (int i =1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {

            if (i>0&&j>0){
                f[i][j]=Math.min(f[i-1][j],f[i][j-1])+mat[i][j];
            }
            }

        }

return f[m-1][n-1];

    }
}
