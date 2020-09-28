package DP;

public class CoinChageTest {
    public static void main(String[] args) {


    }

    public static int coinChange(int[] A, int M) {
        int[] f = new int[M + 1];
        //f(x)=min(m-a[1]+1)
        f[0] = 0;
        int maxValue = Integer.MAX_VALUE;
        for (int i = 1; i < M; i++) {
            f[i]=Integer.MAX_VALUE;
            for (int j = 0; j < 2; j++) {
                if (i >= A[j] && f[i - A[j]] + 1 < f[i]) {
                    maxValue = Math.min(f[i - A[0]], f[i - A[1]]);
                  //  break;
                }
            }
            f[i] = maxValue + 1;
        }
        return f[M];
    }
}
