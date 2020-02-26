package DP;

public class Coinchange {

    public static void main(String[] args) {
        int coinChange = coinChange(new int[]{2, 5, 7}, 27);
        System.out.println(coinChange);
    }

    public static int coinChange(int[] A, int M) {
        int[] f = new int[M + 1];
        int n = A.length;
        f[0] = 0;
        int i, j;
        for (i = 1; i <= M; ++i) {
            f[i] = -1;
            for (j = 0; j < n; ++j) {
                if (i >= A[j] && f[i - A[j]] != -1) {
                    if (f[i] == -1 || f[i - A[j]] + 1 < f[i]) {
                        f[i] = f[i - A[j]] + 1;
                    }
                }
            }
        }

        return f[M];
    }
}

