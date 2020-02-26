package DP;

public class BombEnemy {
    public static void main(String[] args) {

    }
    public static int bombenemy(char [][] A){
if (A==null||A.length==0||A[0].length==0){
    return 0;
}
        int m = A.length;
        int n = A[0].length;
        int[][] f = new int[m][n];
        int[][] res = new int[m][n];
        int i,j;
        for ( i = 0; i <m ; i++) {
            for (j = 0; j < n; j++) {
res[i][j]=0;
            }
        }
        //up
        //others is the same
        for ( i = 0; i <m ; i++) {
            for ( j = 0; j <n ; j++) {
                if (A[i][j]=='W'){
                    f[i][j]=0;
                }else {
                    f[i][j]=0;
                      if (A[i][j]=='E'){
                          f[i][j]=1;
                      }
                      if (i-1>=0){
                          f[i][j]+=f[i-1][j];
                      }
                }
                res[i][j]+=f[i][j];
            }
        }
        //down 知道一个点  向下计算  需要知道下面的 所以需要从下往上计算
        for ( i = m-1; i >=0 ; i--) {
            for ( j = 0; j <n ; j++) {
                if (A[i][j]=='W'){
                    f[i][j]=0;
                }else {
                    f[i][j]=0;
                    if (A[i][j]=='E'){
                        f[i][j]=1;
                    }
                    if (i+1<m){
                        f[i][j]+=f[i+1][j];
                    }
                }
                res[i][j]+=f[i][j];
            }
        }

        return 0;
    }
}
