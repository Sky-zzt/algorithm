package DP;

public class CoinsInALineIII {
    public static void main(String[] args) {


    }

    public static boolean firstwillwin(int[] a) {
        int n = a.length;
        if (n == 0) {
            return true;
        }
        int[][] f = new int[n][n];
        //len==1
        for (int i = 0; i < n; i++) {
            f[i][i] = a[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len - 1;
                f[i][j] = Math.max(a[i] - f[i + 1][j], a[j] - f[i][j - 1]);
            }
        }

        return f[0][n - 1] >= 0;
    }
}
