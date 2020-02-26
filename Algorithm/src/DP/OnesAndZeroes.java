package DP;

public class OnesAndZeroes {
    public static void main(String[] args) {

    }
    public static int oaz(String [] A,int m,int n){
        int T = A.length;
int [] count0=new int[T];
int [] count1=new int[T];
        for (int i = 0; i <T ; i++) {
            count0[i]=count1[i]=0;
            char[] s = A[i].toCharArray();
            for (int j = 0; j <s.length ; j++) {
                if (s[j]=='0'){
                    count0[i]++;
                }else {
                    count1[i]++;
                }
            }
        }
        int[][][] f = new int[T + 1][m + 1][n + 1];
        for (int i = 0; i <=m ; i++) {
            for (int j = 0; j <=n ; j++) {
f[0][i][j]=0;
            }
        }
        for (int k = 1; k<=T ; k++) {
            for (int i = 0; i <=m ; i++) {
                for (int j = 0; j <=n ; j++) {
                    f[k][i][j]=f[k-1][i][j];
                    if (i>=count0[k-1]&&j>=count1[k-1]){
                        //f[i][j][k] = max{f[i-1][j][k], f[i-1][j- a i-1 ][k- b i-1 ] + 1| j>= a i-1 AND k>=b i-1 }
                    }
                }
            }
        }
        return f[T][m][n];
    }
}
