package DP;

public class PerfectSquares {
    public static void main(String[] args) {

    }
    public static int Perfectsquares(int n){
        int[] f = new int[n + 1];
        f[0]=0;
        for (int i = 1; i <=n; i++) {
             f[i]=Integer.MAX_VALUE;
            for (int j = 1; j *j<=i ; j++) {
                if (f[i-j*j]+1<f[i]){
                    f[i]=f[i-j*j]+1;
                }
            }
        }

return f[n];
    }
}
